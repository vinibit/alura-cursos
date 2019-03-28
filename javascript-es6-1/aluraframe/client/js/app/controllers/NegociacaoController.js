// aluraframe/client/js/app/controllers/NegociacaoController.js

class NegociacaoController {

    constructor() {

        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');
        
        this._listaNegociacoes = new Bind(new ListaNegociacoes(), new NegociacoesView($('#negociacoesView')), 
            'adiciona', 'esvazia', 'ordena', 'inverteOrdem');
                
        this._mensagem = new Bind(new Mensagem(), new MensagemView($('#mensagemView')), 
            'texto');

        this._service = new NegociacaoService();

        this._ordemAtual = '';
    }

    adiciona(event) {

        event.preventDefault();

        try {            
            this._listaNegociacoes.adiciona(this._criaNegociacao());
            this._mensagem.texto = "Negociação adicionada com sucesso."
            this._limpaFormulario();            
        } catch (erro) {
            this._mensagem.texto = erro;
        }
    }

    importaNegociacoes() {
      /*   let xhr = new XMLHttpRequest();
        xhr.open('GET', 'negociacoes/semana');
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {                    
                    JSON.parse(xhr.responseText)
                        .map(json  => new Negociacao(new Date(json.data), json.quantidade, json.valor))
                        .forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
                        this._mensagem.texto = 'Negociações importadas com sucesso.';
                } else {                    
                    console.log(xhr.responseText);
                    this._mensagem.texto = 'Não foi possível obter as negociações do servidor.';
                }
            }
        };
        xhr.send(); */
        
       this._service
            .obterTodasNegociacoes()
            .then(negociacoes => {                
                negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));                
                this._mensagem.texto = 'Negociações do período importadas com sucesso';
            })
            .catch(erro => this._mensagem.texto = erro);                         

    }

    _criaNegociacao() {

        return new Negociacao(                       
            DateHelper.textoParaData(this._inputData.value),
            this._inputQuantidade.value,
            this._inputValor.value
        );
    }

    _limpaFormulario() {

        this._inputData.value = '';
        this._inputQuantidade.value = "1";
        this._inputValor.value = "0.0";
        
        this._inputData.focus();
    }

    apaga() {

        this._listaNegociacoes.esvazia();
        this._mensagem.texto = 'Negociações apagadas com sucesso';
    }

    ordena(coluna) {
        if (this._ordemAtual == coluna) {
            this._listaNegociacoes.inverteOrdem();
        } else {
            this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
            this._ordemAtual = coluna;
        }
    }
}

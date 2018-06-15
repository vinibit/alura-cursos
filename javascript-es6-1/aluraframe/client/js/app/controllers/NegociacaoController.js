// aluraframe/client/js/app/controllers/NegociacaoController.js

class NegociacaoController {

    constructor() {

        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');

        this._lista = new ListaNegociacoes();
        this._negociacoesView = new NegociacoesView($('#negociacoesView'));
        this._negociacoesView.update(this._lista);

        this._mensagem = new Mensagem();
        this._mensagemView = new MensagemView($('#mensagemView'));
        this._mensagemView.update(this._mensagem);
    }

    adiciona(event) {

        event.preventDefault();

        let data = this._inputData.value.replace(/-/g, ',');
        let novaNegociacao = this._criaNegociacao();
        console.log(novaNegociacao);
        
        this._limpaForumlario();
        this._lista.adiciona(novaNegociacao);
        this._negociacoesView.update(this._lista);

        this._mensagem.texto = "Negociação gravada com sucesso."
        this._mensagemView.update(this._mensagem);
    }

    _criaNegociacao() {

        return new Negociacao(                       
            DateHelper.textoParaData(this._inputData.value),
            this._inputQuantidade.value,
            this._inputValor.value
        );
    }

    _limpaForumlario() {

        this._inputData.value = '';
        this._inputQuantidade.value = "1";
        this._inputValor.value = "0.0";
        
        this._inputData.focus();
    }

}

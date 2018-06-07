// NegociacaoController.js

class NegociacaoController {

    constructor() {

        let $ = document.querySelector.bind(document);

        this._inputData = $('#data');
        this._inputQuantidade = $('#quantidade');
        this._inputValor = $('#valor');

        this._lista = new ListaNegociacoes();
    }

    adiciona(event) {

        event.preventDefault();

        let data = this._inputData.value.replace(/-/g, ',');
        let novaNegociacao = this._criaNegociacao();
        
        
        this._limpaForumlario();
        
        console.log(novaNegociacao);
    }

    _criaNegociacao() {

        return new Negociacao(                       
            DateHelper.textoParaData(this._inputData),
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

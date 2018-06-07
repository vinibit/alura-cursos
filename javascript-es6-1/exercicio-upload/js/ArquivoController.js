class ArquivoController {

    constructor() {
        this._inputDados = document.querySelector('.dados-arquivo');
    }

    envia() {
        
        if (!/^\w*\/\d*\/\w{3,5}$/g.test(this._inputDados.value)) 
            throw new Error('Formato inválido! Use [texto/numero/texto(3 letras)]...');

        //cria um Arquivo com as suas propriedades;
        let arquivo = ArquivoHelper.cria(this._inputDados.value);

        // exibe mensagem no console com os dados do arquivo.
        console.log(`Dados do arquivo: ${arquivo.nome}, ${arquivo.tamanho}, ${arquivo.tipo}`);
        
        this._limpaFormulario();
    }

    _limpaFormulario() {
        this._inputDados.value = '';
        this._inputDados.focus();
    }
}
class DateHelper {

    constructor () {
        throw new Error('Esta classe não pode ser instanciada.');
    }

    static textoParaData(texto) {
        
        if(!/\d{4}-\d{2}-\d{2}/.test(texto))
            throw new Error('Formato inválido! O texto deve estar no formato aaaa-mm-dd.');

        return new Date(... texto
                .split('-')
                .map((e, i) => e - i % 2)
            );
    }

    static dataParaTexto(data) {
        
        //return `${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
        return data.toLocaleDateString('pt-BR');
    }
}
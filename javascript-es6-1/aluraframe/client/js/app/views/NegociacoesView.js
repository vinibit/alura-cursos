// aluraframe/client/js/app/views/NegociacoesView.js

class NegociacoesView extends View {

    template(model) {
        return `<table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th onclick="negociacaoController.ordena('data')">DATA</th>
                            <th onclick="negociacaoController.ordena('quantidade')">QUANTIDADE</th>
                            <th onclick="negociacaoController.ordena('valor')">VALOR</th>
                            <th onclick="negociacaoController.ordena('volume')">VOLUME</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr></tr>
                        ${model.negociacoes
                            .map(n => {
                                return `<tr>
                                            <td>${DateHelper.dataParaTexto(n.data)}</td>
                                            <td>${n.quantidade}</td>
                                            <td>${n.valor}</td>
                                            <td>${n.volume}</td>
                                        </tr>`;
                            })
                            .join('')
                        }                        
                    </tbody>

                    <tfoot>
                        <td colspan="3"></td>
                        <td style="text-align: right">
                            Total: 
                            ${model.volumeTotal()}
                        </td>
                    </tfoot>
                </table>`;
    }

}
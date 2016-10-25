var atualizaDados = function () {
    var totalValor = 0;
    var totalQuantidade = 0;

    var rows = $("tbody").find("tr:visible");
    for (i = 0; i < rows.length; i++) {
        totalValor += parseFloat($(rows[i]).find(".sub-total").text());
        totalQuantidade += parseInt($(rows[i]).find(".subquantidade").text());
    }

    $("#valor-total").text(totalValor);
    $("#quantidade-de-itens").text(totalQuantidade);
}

var removeItem = function (event) {
    event.preventDefault();
    $(this).closest("tr").hide();
    atualizaDados();
}
$(".remove-item").click(removeItem);

var undo = function () {
    $("tr:visible").removeClass("recuperado");
    var hiddenRows = $("tr:hidden");
    hiddenRows.addClass("recuperado");
    hiddenRows.show();
    atualizaDados();
}
$("#undo").click(undo);

var aposInicializado = function () {
    atualizaDados();
}
$(aposInicializado);
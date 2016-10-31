var umaPropaganda = function() {
    var propagandas = ["O que acha de comprar uma motocicleta?",
               "O que acha de comprar uma lancha?",
               "O que acha de comprar uma bicicleta?",
               "O que acha de comprar uma carro?"
               ];
    var posicao = Math.floor(propagandas.length * Math.random());
    var texto = propagandas[posicao];

    var row = $("<tr>")
        .addClass("propaganda")        
        .append($("<td>"))
        
    row.find("td").attr("colspan", 6).text(texto);

    return row;
}

var atualizaDados = function () {
    $(".carrinho").each(function() {
        var totalValor = 0;
        var totalQuantidade = 0;
        var rows = $(this).find(".row:visible");
        rows.each(function() {
            totalValor += parseFloat($(this).find(".sub-total").text());
            totalQuantidade += parseInt($(this).find(".subquantidade").text());
        });
        $(this).find(".valor-total").text(totalValor);
        $(this).find(".quantidade-de-itens").text(totalQuantidade);
    });
}

var removeItem = function (event) {
    event.preventDefault();
    $(this).closest("tr").hide();
    atualizaDados();
}

var undo = function () {
    var carrinho = $(this).closest(".carrinho");
    carrinho.find(".row:visible").removeClass("recuperado");
    var hiddenRows = carrinho.find(".row:hidden");
    hiddenRows.addClass("recuperado");
    hiddenRows.show();
    atualizaDados();
}

var escondePropagandas = function(event) {
    event.preventDefault();
    $(".propaganda").fadeOut();
}

var mostraPropagandas = function(event) {
    event.preventDefault();
    $(".propaganda").fadeIn();
}

var alternaPropagandas = function(event) {
    event.preventDefault();
    $(".propaganda").fadeToggle();
    $(".alterna-propagandas").toggle();
}

var aposInicializado = function () {
    atualizaDados();
    $(".carrinho").each(function() {
        var carrinho = $(this);
        carrinho.find("tr:nth-child(3n), tr:last").each(function() {
             umaPropaganda().insertAfter($(this));
        })
    });
    $(".row").hover(
        function() {
            $(this).addClass("hovering");
            $(this).find(".remove-item").fadeIn();
        },
        function() {
            $(this).find(".remove-item").fadeOut();
            $(this).removeClass("hovering");
        }
    )
    $(".remove-item").click(removeItem);
    $(".undo").click(undo);        
    //$("#esconde-propagandas").click(alternaPropagandas);
    //$("#mostra-propagandas").click(alternaPropagandas);
    $(".alterna-propagandas").click(alternaPropagandas);
}
$(aposInicializado);    
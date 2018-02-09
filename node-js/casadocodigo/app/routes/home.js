module.exports = function(app) {
    
    var database = 'casadocodigo_nodejs';

    app.get('/', function (req, res, next) {
        var connection = app.infra.connectionFactory(database);
        var produtosDAO = new app.infra.ProdutosDAO(connection);

        produtosDAO.lista(function(err, results) {
            res.render('home/index', {livros: results});
        });        
    });

}
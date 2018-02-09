module.exports = function (app) {
    var database = 'casadocodigo_nodejs';
    
    app.get('/promocoes/form', function (req, res, next) {
        var connection = app.infra.connectionFactory(database);
        var produtosDAO = new app.infra.ProdutosDAO(connection);
        produtosDAO.lista(function(err, results) {
            if (err) return next();
            res.render('promocoes/form', {produtos: results});
        });
        connection.end();        
    });

    app.post('/promocoes', function (req, res) {
        var promocao = req.body;
        console.log(promocao);
        app.get('io').emit('novaPromocao', promocao);
        res.redirect('promocoes/form')
    });
}
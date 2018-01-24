module.exports = function (app) {
    
    app.get('/produtos', function(req, res) {
        var connection = app.infra.connectionFactory();
        var produtosDAO = new app.infra.ProdutosDAO(connection);

        produtosDAO.lista(function(err, results) {
            res.format({
                    html: function() {
                        res.render('produtos/lista', {lista: results});
                    },
                    json: function() {
                        res.json(results);
                    }
                }
            )
        });

        connection.end();
    });

    app.get('/produtos/form', function (req, res) {
        res.render('produtos/form', {validacoes: {}, produto: {}});
    });
    
    app.post('/produtos', function (req, res){ 
        var produto = req.body;

        req.assert('titulo', 'Título é obrigatório').notEmpty();
        req.assert('preco', 'Valor inválido').isFloat();
        
        var errors = req.validationErrors();
        if (errors) {
            res
                .status(400)
                .format({
                    html: function() {
                        res.render('produtos/form', {validacoes: errors, produto: produto});
                    },
                    json: function() {
                        res.json(errors);
                    }
                });
            return;
        }
        
        var connection = app.infra.connectionFactory();
        var produtosDAO = new app.infra.ProdutosDAO(connection);
        produtosDAO.salva(produto, function(erros, resultado) {
            res.redirect('/produtos')
        })

        connection.end();
    });
}

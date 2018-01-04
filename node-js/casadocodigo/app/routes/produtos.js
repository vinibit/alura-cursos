module.exports = function (app) {
    app.get('/produtos',function(req,res){
        var mysql = require('mysql');
        var connection = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "prodam01",
            database: "casadocodigo_nodejs",
        });

        connection.query('select * from produtos', function(err, results){
            res.render('produtos/lista', {lista: results});
        });

        connection.end();
    });
}

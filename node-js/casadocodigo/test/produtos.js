var express = require('../config/express')();
var request = require('supertest')(express);

describe('#ProdutosController', function() {
    
    
    beforeEach(function(done) {
        var conn = express.infra.connectionFactory('casadocodigo_nodejs_test');
        conn.query("delete from produtos", function (err, result) {
            if (err) {
                console.log("Erros: " + err)
            }
            done();
        });
        conn.end();
    });    

    it('#listagem json', function(done) {
        request.get('/produtos')
            .set('Accept', 'application/json')
            .expect('Content-Type', /json/)
            .expect(200, done);
    });

    it('#cadastro de produto inválido', function (done) {
        request.post('/produtos')
            .send({titulo: "", descricao: "novo livro"})
            .expect(400, done);
    });

    it('#cadastro de produto válido', function (done) {
        request.post('/produtos')
            .send({titulo: "titulo", descricao: "novo livro", preco: 25.90})
            .expect(302, done);
    });

}); 
module.exports = function () {
    console.log("Carregando o módulo...");
    var app = require('express')();    
    app.set('view engine', 'ejs');
    return app;
}
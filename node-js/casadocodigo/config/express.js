var express = require('express');
var load = require('express-load');
var parser = require('body-parser');

module.exports = function () {    
    var app = express();
    app.set('view engine', 'ejs');
    app.set('views', './app/views');

    app.use(parser.urlencoded({extended: true}));
    app.use(parser.json());

    load('routes', {cwd: 'app'})
        .then('infra')
        .into(app);

    return app;
}
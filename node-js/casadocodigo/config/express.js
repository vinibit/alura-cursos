var express = require('express');
var load = require('express-load');
var parser = require('body-parser');
var validator = require('express-validator');

module.exports = function () {    
    var app = express();

    app.use(express.static('./app/public'));

    app.set('view engine', 'ejs');
    app.set('views', './app/views');

    app.use(parser.urlencoded({extended: true}));
    app.use(parser.json());
    app.use(validator());

    load('routes', {cwd: 'app'})
        .then('infra')
        .into(app);

    return app;
}
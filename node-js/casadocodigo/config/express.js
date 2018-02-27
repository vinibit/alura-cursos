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
    
    app.use(function (req, res, next) {
        res.status(404).render('errors/404');
    });

    app.use(function (error, req, res, next) {
        if (process.env.NODE_ENV == 'production') {
            res.status(500).render('errors/500');
            return;
        }
        next(error);
    })

    return app;
}
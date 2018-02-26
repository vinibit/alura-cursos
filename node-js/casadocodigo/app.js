var app = require('./config/express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.set('io', io);

//var host = "localhost"
var defaultPort = process.env.PORT || 3000;

var server = http.listen(defaultPort, function() {
    var host = server.address().host || 'localhost';
    var port = server.address().port        
    console.log("Server running at http://%s:%s", host, port);
});
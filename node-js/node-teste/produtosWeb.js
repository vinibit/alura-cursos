var http = require('http');
var porta = 3000;
var ip = "localhost";

var server = http.createServer(function(request, response) {
    console.log("Recebendo request");
    response.writeHead(    200, {'Content-Type': 'text/html'});
    response.end('<html><body>Request recebido! Olá Mundo!</body></html>');
});

server.listen(porta, ip);

console.log("Server running at http://" + ip + ":" + porta + "/");
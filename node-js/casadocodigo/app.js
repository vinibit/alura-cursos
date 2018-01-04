var ip = "localhost";
var port = 3000;

var app = require ('./config/express')();
var rotasProdutos = require ('./app/routes/produtos')(app);

app.listen(port, function() {
    console.log("Server running at http://" + ip + ":" + port + "/");
})
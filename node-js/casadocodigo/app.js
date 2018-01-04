
var ip = "localhost";
var port = 3000;

var app = require ('./config/express')();

app.set("view engine", "ejs");

app.get('/produtos', function(req,res){
    //res.send("<html><body><h1>Listagem de produtos</h1></body></html>")
    res.render("produtos/lista.ejs");
})

app.listen(port, function() {
    console.log("Server running at http://" + ip + ":" + port + "/");
})
var ip = "localhost";
var port = 3000;

var app = require ('./config/express')();

app.listen(port, function() {
    console.log("Server running at http://" + ip + ":" + port + "/");
})
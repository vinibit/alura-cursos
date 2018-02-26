var mysql = require('mysql');

function createDBConnection(database) {
    var env = process.env.NODE_ENV;
    if (env == 'production') {
        var url = process.env.CLEARDB_DATABASE_URL;
        var parts = url.match(/mysql:\/\/(.*):(.*)@(.*)\/(.*)\?/);
        return mysql.createConnection({
            host: parts[3],
            user: parts[1],
            password: parts[2],
            database: parts[4]
        });
    } 

    return mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: 'prodam01',
        database: database 
    });
}

module.exports = function() {
    return createDBConnection;
}
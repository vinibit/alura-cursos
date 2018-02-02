var mysql = require('mysql');

function createDBConnection(database) {
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
// aluraframe/client/js/app/services/HttpService.js

class HttpService {

    get(uri) {

        return new Promise((resolve, reject) => {
           
            let xhr = new XMLHttpRequest();
            xhr.open('GET', uri);
            xhr.onreadystatechange = () => {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        resolve(JSON.parse(xhr.responseText));
                    } else {
                        console.log(xhr.responseText);
                        reject(xhr.responseText);
                    }
                }
            }
            xhr.send();
            
        });
    }

    post(uri, data) {

        return new Promise((resolve, reject) => {

            let xhr = new XMLHttpRequest();
            xhr.open('POST', uri, true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.onreadystatechange = () => {
                if (xhr.readyState == 4) {
                    if (xhr.status = 200) {

                        resolve(JSON.parse(xhr.responseText));
                    } else {

                        reject(xhr.responseText);
                    }
                }
            };
            xhr.send(JSON.stringify(data));
        });
    }
}
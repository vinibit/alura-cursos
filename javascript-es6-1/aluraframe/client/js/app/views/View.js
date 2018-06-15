// aluraframe/client/js/app/views/View.js

class View {

    constructor(domElement) {
        this._domElement = domElement;
    }

    update(model) {
        this._domElement.innerHTML = this.template(model);
    }

    template(model) {
        throw new Error('Você deve sobrescrever este método em seu template');
    }
}
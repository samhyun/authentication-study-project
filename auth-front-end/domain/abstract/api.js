
export default class AbstractApiService {
    constructor(endpoint) {
        this.endpoint = endpoint;
        this.$axios = null;
    }

    getUrl(path) {
        if (path.startsWith('/')) {
            path = path.replace('/', '');
        }
        return `${this.endpoint}/${path}`;
    }

    get(path, header) {
        return this.$axios.$get(this.getUrl(path), header);
    }

    post(path, body, header) {
        return this.$axios.$post(this.getUrl(path), body, header);
    }

    put(path, body, header) {
        return this.$axios.$put(this.getUrl(path), body, header);
    }

    delete(path, header) {
        return this.$axios.$delete(this.getUrl(path), header);
    }

    get classname() {
        return this.constructor.name;
    }

}
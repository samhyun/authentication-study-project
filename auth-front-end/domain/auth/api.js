import AbstractApiService from '../abstract/api';

const AUTH_ENDPOINT = '/api/auth';

export default class AuthApiService extends AbstractApiService {
    constructor() {
        super(AUTH_ENDPOINT);
    }

    join(user) {
        return this.post('join', user);
    }

    login(email, password) {
        return this.post('login', {
                email, password,
            },
        );
    }

    fetchPrincipal() {
        return this.get('principal');
    }
}

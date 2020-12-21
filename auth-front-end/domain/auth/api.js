import AbstractApiService from '@/domain/abstract/api';

const AUTH_ENDPOINT = '/api/auth';

export default class AuthApiService extends AbstractApiService{
    constructor() {
        super(AUTH_ENDPOINT);
    }

    async join(user) {
        return this.post('join', user);
    }
}

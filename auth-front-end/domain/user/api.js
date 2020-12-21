import AbstractApiService from '@/domain/abstract/api';

const AUTH_ENDPOINT = '/api/user';

export default class UserApiService extends AbstractApiService{
    constructor() {
        super(AUTH_ENDPOINT);
    }

    isValid(type, pathParameter) {
        return this.get(`/valid/${type}/${pathParameter}`);
    }
}

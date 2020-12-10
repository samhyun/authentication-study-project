export default class User {
    constructor() {
        this.email = '';
        this.password = '';
        this.confirmPassword = '';
        this.nickname = '';
        this.lastName = '';
        this.firstName = '';
        this.mobile = '';
    }


    validatePassword() {
        return this.password === this.confirmPassword;
    }
}
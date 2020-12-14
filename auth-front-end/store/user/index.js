

export const actions = {
    async saveUser(context, user) {
        console.log(context);
        console.log(user);
        const result = await this.$axios.$post('/api/auth/join', user)
    }
}
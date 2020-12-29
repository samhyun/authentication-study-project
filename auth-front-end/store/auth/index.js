export const state = () => ({
    principal: null
});

export const mutations = {
    setPrincipal(state, principal) {
        console.log(principal);
        state.principal = principal;
    },
}

export const actions = {
    async login({commit, state}, {email, password}) {
        commit('setPrincipal', await this.$api.auth.login(email, password));
    },
    async fetchPrincipal({commit}) {
        commit('setPrincipal', await this.$api.auth.fetchPrincipal());
    },
    async logout() {
        await this.$axios.$post('/api/logout');
    },

}
export default async ({store}) => {
    console.log('fetch principal ');
    if (!store.state.auth.principal) {
        await store.dispatch('auth/fetchPrincipal');
    }
};
export const state = () => ({
    title: 'Home'
});

export const mutations = {
    setTitle(state, {title}) {
        state.title = title;
    }
};


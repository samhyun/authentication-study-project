export const state = () => ({
    title: 'Home',
    sequence: 0
});

export const mutations = {
    setTitle(state, title) {
        state.title = title;
    },
    increment(state) {
        state.sequence++;
    }
};


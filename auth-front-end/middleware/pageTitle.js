const TITLE = {
    index: 'HOME',
    join: '회원 가입',
    login: 'Login'
};

export default function setPageTitle({store, route}) {
    store.commit('layout/setTitle', {title: TITLE[route.name]});
}
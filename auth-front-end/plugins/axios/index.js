export default function ({ $axios }) {
    $axios.defaults.withCredentials = true;

    $axios.interceptors.response.use((response) => {
        switch (response.status) {
            case 244:
                return Promise.reject(response.data);
            default:
                return Promise.resolve(response);
        }
    }, (error) => {
        console.log(error.response);
        switch (error.response.status) {
            case 444:
                //TODO custom error handling
                return Promise.reject(error.response.data);
            default:
                return Promise.reject(error);
        }
    })
}
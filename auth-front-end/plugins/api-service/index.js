import {NuxtAxiosInstance} from '@nuxtjs/axios';

const requireApiService = require.context(
    '@/domain/', true, /api\.js$/,
);

const api = {};

export default function (context, inject) {

    requireApiService.keys().reduce((result, filepath) => {
        let module;
        try {
            module = requireApiService(filepath);
        } catch (e) {
            return result;
        }
        const filePaths = filepath.split('/');
        const moduleName = filePaths[filePaths.length - 2];

        if (!module.default || moduleName === 'abstract') {
            return result;
        }

        const apiService = new module.default();

        apiService.$axios = context.$axios;

        api[filePaths[filePaths.length - 2]] = apiService;
        return result;
    }, {});


    context.$api = api;
    inject('api', api);
};

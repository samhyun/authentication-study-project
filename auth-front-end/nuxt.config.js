import tailwindTypography from '@tailwindcss/typography';

export default {
    buildModules: [
        '@nuxtjs/tailwindcss'
    ],
    router: {
        middleware: ['pageTitle']
    },
    tailwindcss: {
        config: {
            plugins: [tailwindTypography]
        }
    },
    plugins: ['~/plugins/global-components']

};
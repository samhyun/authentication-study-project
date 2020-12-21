import tailwindTypography from '@tailwindcss/typography';

export default {
    buildModules: [
        '@nuxtjs/tailwindcss',
        '@nuxtjs/axios',
        '@nuxtjs/proxy'
    ],
    axios: {
        proxy: true
    },
    proxy: {
        '/api/': {target: 'http://localhost:8080', pathRewrite: {'/api/': '/'}},
    },
    router: {
        middleware: ['pageTitle']
    },
    tailwindcss: {
        config: {
            plugins: [tailwindTypography]
        }
    },
    plugins: ['~/plugins/global-components', '@/plugins/axios', '@/plugins/api-service']
};
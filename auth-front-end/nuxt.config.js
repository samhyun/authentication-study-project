import tailwindTypography from '@tailwindcss/typography';

export default {
    buildModules: [
        '@nuxtjs/tailwindcss'
    ],
    tailwindcss: {
        config: {
            plugins: [tailwindTypography]
        }
    },
    plugins: ['~/plugins/global-components']

}
const defaultTheme = require('tailwindcss/defaultTheme');

module.exports = {
    purge: [
        './components/**/*.{vue,js}',
        './layouts/**/*.vue',
        './pages/**/*.vue',
        './plugins/**/*.{js,ts}',
        './nuxt.config.{js,ts}',
    ],
    theme: {
        extend: {
            colors: {
                primary: defaultTheme.colors.green
            }
        }
    },
    variants: {
        opacity: ({after}) => after(['disabled']),
        cursor: ({after}) => after(['disabled'])
    },
};
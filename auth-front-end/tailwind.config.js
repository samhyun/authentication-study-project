const defaultTheme = require('tailwindcss/defaultTheme');

module.exports = {
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
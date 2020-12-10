export default {
    name: 'AbstractInput',
    data: function() {
        return {
            inputValue: this.value
        };
    },
    props: {
        value: {
            type: String,
            default: ''
        },
        label: {
            type: String,
            default: ''
        }
    },
    methods: {
        onChangeInput() {
            this.$emit('input', this.inputValue);
        }
    },
    computed: {
        inputId() {
            return `${this.label}-input-element`;
        }
    }
};
import AbstractClassComponent from '@/component/AbstractClassComponent';

export default {
    name: 'AbstractInput',
    // mixins: [AbstractClassComponent],
    data: function () {
        return {
            inputValue: this.value,
            sequence: 0
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
        },
        name: {
            type: String,
            default: 'input'
        }
    },
    methods: {
        onChangeInput() {
            this.$emit('input', this.inputValue);
        }
    },
    computed: {
        inputId() {
            return `${this.name}-${new Date().getTime()}-${this.sequence}`;
        }
    },
    beforeMount() {
        this.sequence = this.$store.state.layout.sequence;
        this.$store.commit('layout/increment');
    }
};
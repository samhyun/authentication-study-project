export default {
    name: 'AbstractClassComponent',
    data() {
        return {
            defaultClass: []
        }
    },
    computed: {
        sizeClass() {
            return [];
        },
        colorClass() {
            return [];
        },
        appendClass() {
            if (this.$attrs['class']) {
                if (typeof this.$attrs['class'] === 'string') {
                    return this.$attrs['class'].split(' ');
                } else {
                    return this.$attrs['class'];
                }
            } else {
                return [];
            }
        },
        clazz() {
            return [
                ...this.defaultClass,
                ...this.sizeClass,
                ...this.colorClass,
                ...this.appendClass,
            ];
        }
    }
};
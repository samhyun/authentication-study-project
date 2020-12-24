export default {
    name: 'AbstractClassComponent',
    data() {
        return {
            defaultClass: []
        };
    },
    computed: {
        sizeClass() {
            return [];
        },
        colorClass() {
            return [];
        },
        appendClass() {
            if (this.$el) {
                return this.$el.classList;
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
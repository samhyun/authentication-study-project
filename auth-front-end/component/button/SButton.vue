<template>
  <button type="submit"
          :class="clazz">
    <slot>버튼</slot>
  </button>
</template>

<script>
import AbstractClassComponent from '@/component/AbstractClassComponent';

export default {
  name: 'SButton',
  mixins: [AbstractClassComponent],
  data() {
    return {
      defaultClass: ['inline-flex', 'justify-center', 'py-2', 'px-4', 'border',
        'border-transparent', 'shadow-sm', 'font-medium',
        'rounded-md', 'focus:outline-none', 'focus:ring-2', 'focus:ring-offset-2']
    }
  },
  props: {
    size: {
      type: String,
      default: 'md',
      required: false
    },
    color: {
      type: String,
      default: 'indigo',
      required: false
    }

  },
  computed: {
    sizeClass() {
      return [`text-${this.size}`];
      // switch (this.size) {
      //   case
      //   case 'md':
      //     return ['text-md'];
      //   default:
      //     return ['text-sm'];
      // }
    },

    colorClass() {
      const result = [`bg-${this.color}-600`, `hover:bg-${this.color}-700`, `focus:ring-${this.color}-500`];
      if (this.$attrs['dark'] !== undefined ) {
        result.push('text-white');
      }
      return result;
    }
  }
};
</script>

<style scoped>

</style>
<template>
  <fieldset>
    <label :for="inputId" class="block text-sm font-medium text-gray-700">{{ label }}</label>
    <input :type="type" :name="name" :id="inputId" v-model="inputValue" @input="onChangeInput"
           :class="clazz">
<!--           class="w-full bg-white rounded border border-gray-300 focus:border-indigo-500 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">-->
<!--           class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-xs h-10 px-2">-->
  </fieldset>
</template>

<script>
import AbstractInput from '@/component/input/AbstractInput';
import AbstractClassComponent from '@/component/AbstractClassComponent';

export default {
  name: 'TextField',
  mixins: [AbstractInput, AbstractClassComponent],
  data() {
    return {
      defaultClass: ['w-full', 'bg-gray-100', 'rounded', 'border', 'border-gray-300', 'focus:border-indigo-500', 'text-base', 'outline-none', 'text-gray-700', 'py-1.5', 'px-3', 'leading-8', 'transition-colors', 'duration-200', 'ease-in-out']
    }
  },
  props: {
    type: {
      type: String,
      required: false,
      default: 'text'
    }
  },
  mounted() {
    const input = this.$el.getElementsByTagName('input')[0];
    if (this.$attrs['required'] != null) {
      input.setAttribute('required', this.$attrs['required']);
    }
    if (this.$attrs['pattern'] != null) {
      input.setAttribute('pattern', this.$attrs['pattern']);
    }
  }

};
</script>

<style scoped>

</style>
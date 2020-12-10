<template>
  <div>
    <label :for="inputId" class="block text-sm font-medium text-gray-700">{{ label }}</label>
    <input :type="type" :name="name" :id="inputId" v-model="inputValue" @input="onChangeInput"
           class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-xs h-10 px-2">
  </div>
</template>

<script>
import AbstractInput from '@/component/input/AbstractInput';

export default {
  name: 'TextField',
  mixins: [AbstractInput],
  data() {
    return {
      defaultClass: ['mt-1', 'focus:ring-indigo-500', 'focus:border-indigo-500', 'block', 'w-full', 'shadow-sm', 'sm:text-sm', 'border-gray-300', 'rounded-xs', 'h-10', 'px-2']
    }
  },
  props: {
    type: {
      type: String,
      required: false,
      default: 'text'
    }
  }

};
</script>

<style scoped>

</style>
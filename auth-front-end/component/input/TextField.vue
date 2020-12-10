<template>
  <div>
    <label :for="inputId" class="block text-sm font-medium text-gray-700">{{label}}</label>
    <input type="text" :name="label" :id="inputId" v-model="inputValue" @input="onChangeInput"
           class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-xs h-10 px-2">
  </div>
</template>

<script>
import abstractInput from '@/component/input/abstractInput';

export default {
  name: 'TextField',
  mixins: [abstractInput],

};
</script>

<style scoped>

</style>
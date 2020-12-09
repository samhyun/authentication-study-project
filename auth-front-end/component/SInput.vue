<template>
  <div>
    <label for="first_name" class="block text-sm font-medium text-gray-700">{{label}}</label>
    <input type="text" name="first_name" id="first_name" autocomplete="given-name"
           v-model="inputValue" @input="onChangeInput"
           class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-xs h-10 px-2">
  </div>
</template>

<script>
export default {
  name: 'SInput',
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
  }
};
</script>

<style scoped>

</style>
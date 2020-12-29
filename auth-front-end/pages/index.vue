<template>
  <div>
    <s-btn @click="test" dark>
      test
    </s-btn>
  </div>
</template>


<script>
export default {

  methods: {
    test() {
      this.$axios.$get('/api/user/test');
    },
  }

}
</script>
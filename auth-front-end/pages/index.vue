<template>
  <div>

    <s-btn color="blue" dark @click="logout" >
      logout
    </s-btn>
    <s-btn @click="test">
      test
    </s-btn>
  </div>
</template>


<script>
export default {

  methods: {
    logout() {
      this.$axios.$post('/api/logout');
    },
    test() {
      this.$axios.$get('/api/user/test');
    },
  }

}
</script>
<template>
  <div id="app">
    <app-header></app-header>
    <router-view />
    <div class="container">
      <br />
      <button class="btn btn-primary" @click="backWard">Back</button>
    </div>
  </div>
</template>

<script>
import Header from "./Component/header.vue";

export default {
  components: {
    appHeader: Header,
  },
  methods: {
    backWard() {
      this.$router.push("/");
    },
  },
};
</script>

<style>
@import "~bootstrap/dist/css/bootstrap.css";
</style>
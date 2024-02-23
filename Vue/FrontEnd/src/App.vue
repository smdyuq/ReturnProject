<template>
  <div class="app">
    <router-view> </router-view>
  </div>
</template>

<script>
import Header from "./components/layout/Header.vue";
import Home from "./views/Home.vue";

export default {
  components: { Home, Header },
};
</script>

<style scoped>
.app {
  /* background-color: lightblue; */
  width: 1024px;
  min-height: 100vh;
}

router-link {
  color: black;
}
</style>


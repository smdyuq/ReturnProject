<template>
  <nav style="display: flex; margin-bottom: 20px; font-size: large">
    <router-link to="/SalesManagement"><span>상품등록</span></router-link>
    <router-link to="/ProductManagement"
      ><span style="margin-left: 25px">상품관리</span></router-link
    >
  </nav>
</template>

<script>
</script>

<style scoped>
span {
  color: black;
  font-size: 1.2em;
  font-weight: 700;
}
</style>
<template>
  <div>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <SlideVue />
    <p v-if="loggedIn">환영합니다, {{ user }}님!</p>
    <p v-else>로그인이 필요합니다.</p>
    <p class="todayProduct">오늘의 상품추천</p>
    <CardWrapperVue />
    <FooterVue></FooterVue>
  </div>
</template>
  
<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import axiosApi from '../services/axios';
import { mapActions } from 'pinia';
import { usersStore } from '../stores/Home';

export default {
  components: {
    HeaderVue,
    SlideVue,
    FooterVue,
    CardWrapperVue,
    SidebarVue
  },
  data() {
    return {
      users: []
    };
  },
  mounted() {
    this.getUsers();
  },
  methods: {
    ...mapActions(usersStore, ['addUsers']),
    getUsers() {
      axiosApi.get('/')
        .then(response => {
          this.addUsers(response.data.sales);
        })
        .catch(error => {
          console.error(error);
        });
    }
  },
  // computed: {
  //   user() {
  //     return this.$session.get('user'); // 세션에서 사용자 아이디를 가져옵니다
  //   },
  //   loggedIn() {
  //     return this.$session.exists(); // 세션이 존재하면 로그인 상태로 판단합니다
  //   }
  // }
};
</script>
  

<style scoped>
.todayProduct {
  font-size: x-large;
  display: flex;
  width: 1024px;
  margin-top: 1rem;
  font-weight: bold;
}
</style>



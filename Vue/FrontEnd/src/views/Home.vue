<template>
  <div>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <SlideVue />

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
    SidebarVue,
  },

  mounted() {
    this.getUsers();
  },

  methods: {
    ...mapActions(usersStore, ["addUsers"]),
    getUsers() {

      axiosApi.get('/main/mainPage')
        .then(response => {

          this.addUsers(response.data.list);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
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



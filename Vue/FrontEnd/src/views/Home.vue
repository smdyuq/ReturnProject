<template>
  <div>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <SlideVue />

    <p class="todayProduct">
      오늘의 상품추천
      <!--{{ getMemberNo }}-->
    </p>
    <CardWrapperVue />
    <FooterVue></FooterVue>
  </div>
</template>
  
<script>
import HeaderVue from "../components/layout/Header.vue";
import FooterVue from "../components/layout/Footer.vue";
import SlideVue from "../components/layout/Slide.vue";
import CardWrapperVue from "../components/layout/CardWrapper.vue";
import SidebarVue from "../components/layout/Sidebar.vue";
import axiosApi from "../services/axios";
import { mapActions, mapState } from "pinia";
import { usersStore } from "../stores/Home";
import { userStore } from "../stores/Member";

export default {
  components: {
    HeaderVue,
    SlideVue,
    FooterVue,
    CardWrapperVue,
    SidebarVue,
  },
  data() {
    return {
      users: [],
    };
  },
  mounted() {
    this.getUsers();
  },
  computed: {
    ...mapState(userStore, ["getMemberNo"]),
  },
  methods: {
    ...mapActions(usersStore, ["addUsers"]),
    getUsers() {
      axiosApi
        .get("/main/mainPage")
        .then((response) => {
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



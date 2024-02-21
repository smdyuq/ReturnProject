<template>
  <body class="d-flex flex-column h-100">
    <header-vue />
    <main class="flex-shrink-0">
      <div class="container">
        <br /><br /><br />
        <h2>자유 게시판</h2>
        <hr />
        <br />
        <list-vue />

        <!-- <pagination-vue :pi="pi" /> -->
        <pagination-vue />
      </div>
    </main>
  </body>
</template>

<script>
import axiosApi from "../services/axios";
import paginationVue from "../components/pagination.vue";
import headerVue from "../components/header.vue";
import listVue from "../components/list.vue";
import { mapActions } from "pinia";
import { boardListStore } from "../stores/boardList";

export default {
  components: {
    paginationVue,
    headerVue,
    listVue,
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    ...mapActions(boardListStore, ["addPi", "addRow", "addUsers", "addType"]),
    fetchData() {
      axiosApi
        .get("/free/list.do")
        .then((res) => {
          this.addType("/freeEnroll");
          this.addUsers(res.data.list);
          this.addRow(res.data.row);
          this.addPi(res.data.pi);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>




















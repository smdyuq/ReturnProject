<template>
  <body class="d-flex flex-column h-100">
    <infoHeader-vue />
    <main class="flex-shrink-0">
      <div class="container">
        <br /><br /><br />
        <h2>정보 게시판</h2>
        <hr />
        <br />
        <infoList-vue />

        <!-- <pagination-vue :pi="pi" /> -->
        <infoPagination-vue />
      </div>
    </main>
  </body>
</template>

<script>
import axiosApi from "../services/axios";
import infoPaginationVue from "../components/infoPagination.vue";
import infoHeaderVue from "../components/infoHeader.vue";
import infoListVue from "../components/infoList.vue";
import { mapActions } from "pinia";
import { infoListStore } from "../stores/infoList";

export default {
  components: {
    infoPaginationVue,
    infoHeaderVue,
    infoListVue,
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    ...mapActions(infoListStore, ["addPi", "addRow", "addUsers", "addType"]),
    fetchData() {
      axiosApi
        .get("/info/list.do")
        .then((res) => {
          this.addType("/infoEnroll");
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
<template>
  <body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <header-vue></header-vue>
    <!-- Begin page content -->
    <main class="flex-shrink-0">
      <div class="container">
        <h3>글 수정</h3>
        <hr />
        <br />
        <!-- 타이틀 컴포넌트 : components/board/title.vue -->
        <div class="mb-3 justify-content-center">
          <input
            type="text"
            class="form-control"
            name="title"
            id="exampleFormControlInput1"
            v-model="getDetail.title"
            placeholder="제목을 입력하세요."
          />
        </div>
        <div class="row mb-3">
          <div class="col-md-4">
            <p class="fw-bold">조회수: {{ getDetail.views }}</p>
          </div>
          <div class="col-md-4">
            <p class="fw-bold">작성자: {{ getDetail.writer }}</p>
          </div>
        </div>

        <div>
          <textarea v-model="getDetail.content" rows="13" cols="100"></textarea>
          <p>content: {{ getDetail.content }}</p>
          <p>title: {{ getDetail.title }}</p>
        </div>

        <div class="row">
          <div class="col text-center">
            <button
              type="button"
              class="btn btn-danger"
              onclick="history.back()"
            >
              취소
            </button>
            <c:if test="${sessionScope.memberName eq free.writer}">
              <button type="submit" @click="goToEdit" class="btn btn-primary">
                수정
              </button>
            </c:if>
          </div>
        </div>
      </div>
    </main>
  </body>
</template>

<script>
import headerVue from "../components/header.vue";
import axiosApi from "../services/axios";
import { mapState, mapActions } from "pinia";
import { boardListStore } from "../stores/boardList";

export default {
  components: {
    headerVue,
  },
  mounted() {
    this.fetchData();
  },
  computed: {
    ...mapState(boardListStore, ["getDetail"]),
  },
  methods: {
    ...mapActions(boardListStore, ["addDetail"]),
    fetchData() {
      // REST API 중심 규칙
      // /free/detail/140
      axiosApi
        .get("/free/detail/" + this.$route.query.idx)
        .then((res) => {
          this.addDetail(
            res.data.title,
            res.data.content,
            res.data.views,
            res.data.writer
          );
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goToEdit() {
      axiosApi
        .put("/free/edit/" + this.$route.query.idx, this.getDetail)
        .then((res) => {
          if (res.data === "success") {
            this.$router.push("/boardList");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
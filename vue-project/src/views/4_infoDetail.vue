<template>
  <body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <infoHeaderVue></infoHeaderVue>
    <!-- Begin page content -->
    <main class="flex-shrink-0">
      <div class="container">
        <h3>상세보기</h3>
        <hr />
        <br />
        <!-- 타이틀 컴포넌트 : components/board/title.vue -->
        <div class="mb-3 justify-content-center">
          <input
            type="text"
            class="form-control"
            name="title"
            id="exampleFormControlInput1"
            :value="getDetail.title"
            placeholder="제목을 입력하세요."
            readonly
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

        <div>{{ getDetail.content }}</div>

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
              <button
                type="submit"
                @click="goToEditForm"
                class="btn btn-primary"
              >
                수정
              </button>
              <button
                type="submit"
                @click="boardDelete"
                class="btn btn-primary"
              >
                삭제
              </button>
            </c:if>
          </div>
        </div>
      </div>
    </main>
  </body>
</template>

<script>
import infoHeaderVue from "../components/infoHeader.vue";
import axiosApi from "../services/axios";
import { mapState, mapActions } from "pinia";
import { infoListStore } from "../stores/infoList";

export default {
  components: {
    infoHeaderVue,
  },
  mounted() {
    this.fetchData();
  },
  computed: {
    ...mapState(infoListStore, ["getDetail"]),
  },
  methods: {
    ...mapActions(infoListStore, ["addDetail"]),
    fetchData() {
      // REST API 중심 규칙
      // /free/detail/140
      axiosApi
        .get("/info/detail/" + this.$route.query.idx)
        .then((res) => {
          this.addDetail(
            res.data.title,
            res.data.category,
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
    boardDelete() {
      axiosApi
        .delete("/info/delete/" + this.$route.query.idx)
        .then((res) => {
          if (res.data === "success") {
            this.$router.push("/infoList");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goToEditForm() {
      this.$router.push("/infoEditForm?idx=" + this.$route.query.idx);
    },
  },
};
</script>
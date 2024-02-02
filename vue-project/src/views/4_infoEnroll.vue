<template>
  <body class="d-flex flex-column h-100">
    <!-- Fixed navbar -->
    <header-vue></header-vue>
    <!-- Begin page content -->
    <main class="flex-shrink-0">
      <div class="container">
        <h3>글쓰기</h3>
        <hr />
        <br />

        <form @submit.prevent="savePost">
          <div class="mb-3 justify-content-center">
            <input
              v-model="post.title"
              type="text"
              class="form-control"
              name="title"
              id="exampleFormControlInput1"
              placeholder="제목을 입력하세요."
            />
          </div>
          <div id="marteditor mb-3 justify-content-center">
            <textarea
              v-model="post.content"
              name="content"
              id="editorTxt"
              class="form-control"
              rows="13"
              cols="10"
              placeholder="내용을 입력해주세요"
            ></textarea>
          </div>

          <!-- <input type="file" name="upload" /> -->

          <div class="row">
            <div class="col text-center">
              <button type="button" class="btn btn-danger" onclick="history.back()">
                취소
              </button>

              
              <button type="submit" onclick="save()" class="btn btn-primary">
                작성
              </button>
            </div>
          </div>
        </form>
      </div>
    </main>
  </body>
</template>

<script>
import headerVue from "../components/header.vue";
import axiosApi from "../services/axios";

export default {
  components: {
    headerVue,
  },
  data() {
    return {
      post: {
        title: "",
        content: "",
      },
    };
  },
  methods: {
    savePost() {
      // REST API 규칙
      // GET : 조회
      // POST : 생성
      // PUT : 수정
      // DELETE : 삭제
      axiosApi
        .post("/free/enroll.do", this.post)
        .then((res) => {
          if (res.data === "success") {
            this.$router.push('/boardList');
          }
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>
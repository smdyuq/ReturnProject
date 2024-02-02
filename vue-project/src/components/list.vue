<template>
  <table class="table table-hover">
    <thead>
      <tr>
        <td>번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수</td>
      </tr>
    </thead>

    <tbody>
      <tr
        @click="goToDetail(item.idx)"
        v-for="(item, index) in getUsers"
        :key="index"
      >
        <td>{{ rowMinus(getRow, index) }}</td>
        <td>{{ item.title }}</td>
        <td>{{ item.writer }}</td>
        <td>{{ item.indate }}</td>
        <td>{{ item.views }}</td>
      </tr>
    </tbody>
    <div class="d-grid gap-2d-md-flex justify-content-end float-right">
      <button class="btn btn-dark me-md-2" type="button">
        <router-link :to="getType"> 글쓰기</router-link>
      </button>
    </div>
  </table>
</template>

<script>
import { mapState } from "pinia";
import { boardListStore } from "../stores/boardList";

export default {
  computed: {
    // getters 사용할 때
    ...mapState(boardListStore, ["getRow", "getUsers", "getType"]),
  },
  methods: {
    // actions 사용할 때
    rowMinus(row, index) {
      return row - index;
    },
    goToDetail(idx) {
      // /freeDetail?idx=${idx}
      // $router -> URL 이동
      // $route -> 쿼리스트링 꺼낼 때
      this.$router.push(`/freeDetail?idx=${idx}`);
    },
  },
};
</script>
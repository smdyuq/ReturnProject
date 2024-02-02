<template>
  <table class="table table-hover">
    <thead>
      <tr>
        <td>번호</td>
        <td>카테고리</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수</td>
      </tr>
    </thead>

    <tbody>
      <tr
        onclick="location.href='/info/detail.do?boardIdx=${item.idx}'"
        v-for="(item, index) in getUsers"
        :key="index"
      >
        <td>{{ rowMinus(getRow, index) }}</td>
        <td>{{ item.category }}</td>
        <td>{{ item.title }}</td>
        <td>{{ item.writer }}</td>
        <td>{{ item.indate }}</td>
        <td>{{ item.views }}</td>
      </tr>
    </tbody>
    <div class="d-grid gap-2d-md-flex justify-content-end float-right">
      <router-link :to="getType"> 글쓰기</router-link>
    </div>
  </table>
</template>

<script>
import { mapState } from "pinia";
import { infoListStore } from "../stores/infoList";

export default {
  computed: {
    ...mapState(infoListStore, ["getRow", "getUsers", "getType"]),
  },
  methods: {
    rowMinus(row, index) {
      return row - index;
    },
  },
};
</script>
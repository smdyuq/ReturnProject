<template>
    <div>
      <div>
        <span>홈 > </span>
        <select v-model="selectedCategory" @change="handleCategoryChange">
          <option>전체</option>
          <option>의류</option>
          <option>주얼리</option>
          <option>가전</option>
          <option>식품</option>
        </select>
      </div>
      <div>
        <div class="categoryBar">
          <div @click="goAll" class="category">전체</div>
          <div @click="goCloth" class="category">의류</div>
          <div @click="goJewelry" class="category">주얼리</div>
          <div @click="goHomeAppliances" class="category">가전</div>
          <div @click="goFood" class="category">식품</div>

        </div>
     
      </div>
      <div></div>
    </div>
  </template>
  
  <script>
  import { defineComponent, watch } from 'vue';
  
  export default defineComponent({
    data() {
      return {
        selectedCategory: '' // 초기에는 선택된 카테고리가 없도록 빈 문자열로 설정합니다.
      };
    },
    methods: {
      handleCategoryChange() {
        switch (this.selectedCategory) {
          case '의류':
            this.$router.push({name: 'CategoryCloth', query: {keyword: this.$route.query.keyword}});
            break;
          case '주얼리':
            this.$router.push({name: 'CategoryJewelry', query: {keyword: this.$route.query.keyword}});
            break;
          case '가전':
            this.$router.push({name: 'CategoryHomeAppliances', query: {keyword: this.$route.query.keyword}});
            break;
          case '식품':
            this.$router.push({name: 'CategoryFood', query: {keyword: this.$route.query.keyword}});
            break;
          default:
            this.$router.push({name: 'CategoryAll', query: {keyword: this.$route.query.keyword}});
            break;
        }
      },

      goAll() {
          this.$router.push({name: 'CategoryAll', query: {keyword: this.$route.query.keyword}});
      },
      goHomeAppliances() {
          this.$router.push({name: 'CategoryHomeAppliances', query: {keyword: this.$route.query.keyword}});
      },
      goFood() {
          this.$router.push({name: 'CategoryFood', query: {keyword: this.$route.query.keyword}});
      },
      goJewelry() {
          this.$router.push({name: 'CategoryJewelry', query: {keyword: this.$route.query.keyword}});
      },
      goCloth() {
          this.$router.push({name: 'CategoryCloth', query: {keyword: this.$route.query.keyword}});
      }
    },
    mounted() {
      // 현재 라우트에 따라 선택된 카테고리 설정
      switch (this.$route.path) {
        case '/CategoryCloth':
          this.selectedCategory = '의류';
          break;
        case '/CategoryJewelry':
          this.selectedCategory = '주얼리';
          break;
        case '/CategoryHomeAppliances':
          this.selectedCategory = '가전';
          break;
        case '/CategoryFood':
          this.selectedCategory = '식품';
          break;
        default:
          this.selectedCategory = '전체';
          break;
      }
    }
  });
  </script>
  
  <style scoped>
  .categoryBar {
    display: flex;
    justify-content: space-between;
    border: 0.5px solid gray;
    height: 60px;
    margin-top: 4%;
    margin-bottom: 4%;
    cursor: pointer;
  }
  
  .category {
    display: flex;
    justify-content: center;
    flex-direction: column;
    border: 0.5px solid gray;
    width: 20%;
    text-align: center;
  }
  </style>
  
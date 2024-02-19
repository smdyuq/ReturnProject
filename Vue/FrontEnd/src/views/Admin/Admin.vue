<template>
  <div class="adminWrapper">
    <h2 style="margin-top: 30px; margin-bottom: 30px;">관리자 페이지 - 문의내역</h2>
    <table class="post-table">
      <thead>
        <tr>
          <th>글번호</th>
          <th>제목</th>
          <th>작성자(ID)</th>
          <th>작성일</th>
          <th>답변여부</th>
        </tr>
        <tr @click="goToAnswer">
          <td>1</td>
          <td>테스트입니다</td>
          <td>qwer1234</td>
          <td>2024-02-15</td>
          <td>답변 전</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(post, index) in displayedPosts" :key="post.id" @click="handlePostClick(post.id)">
          <td>1{{ startIndex + index }}</td>
          <td>테스트{{ post.title }}</td>
          <td>qwer1234{{ post.author }}</td>
          <td>2024-02-15{{ post.date }}</td>
          <td>답변 전{{ post.status }}</td>
        </tr>
      </tbody>
    </table>

    <div class="pagination">
      <button @click="goToPreviousPage" :disabled="currentPage === 1">이전</button>
      <span style="font-size:x-large;">페이지: {{ currentPage }}</span>
      <button @click="goToNextPage" :disabled="currentPage === totalPages">다음</button>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, computed } from 'vue';
import axios from 'axios';

export default {
  setup() {
    const posts = ref([]);
    const currentPage = ref(1);
    const pageSize = 30;

    const fetchPosts = async () => {
      try {
        const response = await axios.get('/api/posts');
        posts.value = response.data;
      } catch (error) {
        console.error('Failed to fetch posts:', error);
      }
    };

    onMounted(fetchPosts);

    const startIndex = computed(() => {
      return (currentPage.value - 1) * pageSize + 1;
    });

    const endIndex = computed(() => {
      return currentPage.value * pageSize;
    });

    const displayedPosts = computed(() => {
      return posts.value.slice(startIndex - 1, endIndex);
    });

    const totalPages = computed(() => {
      return Math.ceil(posts.value.length / pageSize);
    });

    const goToPreviousPage = () => {
      if (currentPage.value > 1) {
        currentPage.value--;
      }
    };

    const goToNextPage = () => {
      if (currentPage.value < totalPages.value) {
        currentPage.value++;
      }
    };

    const handlePostClick = (postId) => {
      // 해당 글의 페이지로 이동
      // 예시: /posts/:id
      this.$router.push({ name: 'post', params: { id: postId }});
    };

    return { displayedPosts, currentPage, totalPages, goToPreviousPage, goToNextPage, handlePostClick, startIndex };
  },
  methods: {
    goToAnswer() {
      this.$router.push('/AdminAnswer')
    }
  }
};
</script>

<style>


.post-table {
  width: 100%;
  height:72vh;
  border-collapse: collapse;
}

.post-table th, .post-table td {
  padding: 10px;
  border-bottom: 1px solid #ddd;
  text-align: center;
}

.post-table th {
  background-color: #f2f2f2;
}

.pagination {
  margin-top: 20px;
  text-align: center;
}

.pagination button {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin: 0 5px;
}

.pagination button:hover {
  background-color: #45a049;
}

.pagination button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}
/* 
button {
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
} */
</style>

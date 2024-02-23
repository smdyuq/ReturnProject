<template>
    <div>
      <h2 style="margin-top:30px; margin-bottom:30px;">문의글 확인 및 답변 작성</h2>
      <div class="post-details">
        <div><strong>글번호:</strong> {{ post.id }}</div>
        <div><strong>제목:</strong> {{ post.title }}</div>
        <div><strong>작성자(ID):</strong> {{ post.author }}</div>
        <div><strong>작성일:</strong> {{ post.date }}</div>
        <div><strong>내용:</strong> {{ post.content }}</div>
      </div>
      <div class="answer-form">
        <textarea v-model="answer" placeholder="답변을 입력하세요"></textarea>
        <button @click="submitAnswer">답변 작성</button>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  import axios from 'axios';
  
  export default {
    data() {
      return {
        post: {}, // 현재 선택된 문의글
        answer: '' // 답변 내용
      };
    },
    methods: {
      // 서버에 답변 작성 요청을 보냅니다.
      async submitAnswer() {
        try {
          // 답변 작성 요청을 서버에 보냅니다.
          await axios.post('/api/answer', {
            postId: this.post.id,
            answer: this.answer
          });
          
          // 답변 작성 후 처리할 작업을 수행합니다. (예: 화면 갱신)
          alert('답변이 작성되었습니다.');
          // 예시: 답변 작성 후 홈페이지로 이동
          this.$router.push('/Admin')
          
        } catch (error) {
          console.error('Failed to submit answer:', error);
          this.$router.push('/Admin')
        //   alert('답변을 작성하는 중에 오류가 발생했습니다.');
        }
      }
    },
    mounted() {
      // 이 페이지가 로드될 때 선택된 문의글을 가져옵니다.
      // 예시: this.post = 서버에서 가져온 문의글 데이터;
      this.post = {
        id: 1,
        title: '문의 제목',
        author: '사용자ID',
        date: '2024-02-15',
        content: '문의 내용이 여기에 표시됩니다.'
      };
    }
  };
  </script>
  
  <style scoped>
  .post-details {
    margin-bottom: 20px;
  }
  
  .post-details div {
    margin-bottom: 10px;
  }
  
  .answer-form textarea {
    width: 100%;
    height: 100px;
    margin-bottom: 10px;
  }
  </style>
  
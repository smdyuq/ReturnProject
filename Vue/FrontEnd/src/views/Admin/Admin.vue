<template>
  <div class="admin">
      <div class="loginSignup" style="margin-top:0;">
            <button @click="goLogin()" style="color:gray;">로그인</button>
            <button @click="goSignUp()" style="color:gray;">회원가입</button>
            </div>
      <h1>관리자 페이지</h1>
      <div class="form-container">
        <form @submit.prevent="addPost">
          <div>
            <label for="title">제목:</label>
            <input type="text" id="title" v-model="newPost.title" required>
          </div>
          <div>
            <label for="content">내용:</label>
            <textarea id="content" v-model="newPost.content" required></textarea>
          </div>
          <button type="submit">추가</button>
        </form>
      </div>
      <div v-for="post in posts" :key="post.id" class="post">
        <div class="post-title">{{ post.title }}</div>
        <div class="post-content">{{ post.content }}</div>
        <div v-if="post.reply" class="post-reply">댓글: {{ post.reply }}</div>
        <div v-else class="add-reply-container">
          <input type="text" v-model="post.newReply" placeholder="댓글 작성">
          <button @click="addReply(post)">댓글 작성</button>
        </div>
        <button class="delete-button" @click="deletePost(post.id)">삭제</button>
      </div>
    </div>
</template>
  
  <script>
  export default {
    data() {
      return {
        posts: [
          { id: 1, title: '첫 번째 게시물', content: '안녕하세요. 첫 번째 게시물입니다.', reply: '' },
          { id: 2, title: '두 번째 게시물', content: '안녕하세요. 두 번째 게시물입니다.', reply: '' },
          { id: 3, title: '세 번째 게시물', content: '안녕하세요. 세 번째 게시물입니다.', reply: '' }
        ],
        newPost: {
          title: '',
          content: ''
        }
      };
    },
    methods: {
      addPost() {
        const newId = this.posts.length + 1;
        const newPost = {
          id: newId,
          title: this.newPost.title,
          content: this.newPost.content,
          reply: ''
        };
        this.posts.push(newPost);
        this.newPost.title = '';
        this.newPost.content = '';
      },
      deletePost(id) {
        this.posts = this.posts.filter(post => post.id !== id);
      },
      addReply(post) {
        if (post.newReply.trim() !== '') {
          post.reply = post.newReply;
          post.newReply = '';
        }
      },
      goLogin() {
        this.$router.push('/LoginPage')
        },
        goSignUp() {
        this.$router.push('/SignupPage')
        }
    }
  };
  </script>
  
  <style scoped>
  .admin {
    margin: 20px;
  }
  
  .post {
    border: 1px solid #ccc;
    padding: 10px;
    margin-bottom: 10px;
  }
  
  .post-title {
    font-weight: bold;
  }
  
  .post-content {
    margin-top: 5px;
  }
  
  .post-reply {
    margin-top: 5px;
    font-style: italic;
  }
  
  .add-reply-container {
    margin-top: 5px;
  }
  
  .add-reply-container input[type="text"] {
    width: 70%;
    padding: 5px;
    margin-bottom: 5px;
  }
  
  .add-reply-container button {
    background-color: #4caf50;
    color: #fff;
    padding: 3px 5px;
    border: none;
    cursor: pointer;
  }
  
  .add-reply-container button:hover {
    background-color: #45a049;
  }
  
  .form-container {
    margin-top: 20px;
    padding: 20px;
    border: 1px solid #ccc;
    background-color: #f5f5f5;
  }
  
  .form-container label {
    display: block;
    margin-bottom: 5px;
  }
  
  .form-container input[type="text"],
  .form-container textarea {
    width: 100%;
    padding: 5px;
    margin-bottom: 10px;
  }
  
  .form-container button {
    background-color: #4caf50;
    color: #fff;
    padding: 5px 10px;
    border: none;
    cursor: pointer;
  }
  
  .form-container button:hover {
    background-color: #45a049;
  }
  
  .delete-button {
    background-color: #f44336;
    color: #fff;
    padding: 5px 10px;
    border: none;
    cursor: pointer;
  }
  
  .delete-button:hover {
    background-color: #d32f2f;
  }

  .loginSignup {
    float:right;
  }
  
  </style>
  
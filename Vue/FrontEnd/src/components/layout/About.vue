<template>
  <div class="contact-us">
    <h2 style="margin-top:20px; margin-bottom:20px;">1:1 문의하기</h2>
    <form @submit.prevent="enrollBoard">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" v-model="board.ask_title" required>
      </div>
      <div class="form-group">
        <label for="message">내용</label>
        <textarea id="message" v-model="board.ask_content" required></textarea>
      </div>
      <button type="submit">전송</button>
    </form>
  </div>
</template>

<script>
import axiosApi from '../../services/axios'
import { mapState } from 'pinia';
import { userStore } from '../../stores/Member'


export default {

    data() {
        return {
            board: {
                ask_title: '',
                ask_content: '',
                member_no:-1
            }
        };
    },
    computed:{
      ...mapState(userStore,['getMemberNo'])
    },
    methods: {
        async enrollBoard() {
          console.log('a')  
          try {
            console.log('b')  
                this.board.member_no = this.getMemberNo;
                const response = await axiosApi.post('/inquiry/enroll', this.board);
                console.log('c')  
                if (response.data === 'success') {
                  console.log('d')    
                  console.log('게시물 등록 성공');
                } else {
                  console.log('e')  
                    console.error('게시물 등록 실패');
                }
            } catch (error) {
              console.log('f')  
                console.error('게시물 등록 중 오류 발생:', error);
            }
            this.$router.push('/Board')
        }
    }
}
</script>
<style scoped>
.form-group {
  margin-bottom: 20px;
}
label {
  display: block;
  margin-bottom: 5px;
}
input,
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
button {
  padding: 10px 20px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width:120px;
  height:50px;
}
button:hover {
  background-color: #0056b3;
}

#message {
  height:300px;
}
</style>

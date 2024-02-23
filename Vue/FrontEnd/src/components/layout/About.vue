<template>
  <div class="contact-us">
<<<<<<< HEAD
    <h2 style="margin-top: 20px; margin-bottom: 20px">1:1 문의하기</h2>
    <form @submit.prevent="submitForm">
=======
    <h2 style="margin-top:20px; margin-bottom:20px;">1:1 문의하기</h2>
    <form @submit.prevent="enrollBoard">
>>>>>>> branch 'master' of https://github.com/smdyuq/ReturnProject.git
      <div class="form-group">
        <label for="title">제목</label>
<<<<<<< HEAD
        <input type="text" id="title" v-model="formData.title" required />
=======
        <input type="text" id="title" v-model="board.ask_title" required>
>>>>>>> branch 'master' of https://github.com/smdyuq/ReturnProject.git
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
<<<<<<< HEAD
  data() {
    return {
      formData: {
        title: "",
        content: "",
      },
    };
  },
  methods: {
    submitForm() {
      // 여기에 폼 데이터를 서버로 전송하는 로직을 추가할 수 있습니다.
      console.log("Form submitted!", this.formData);
      // 전송 후에 폼을 초기화하거나 다음 단계로 넘어갈 수 있습니다.
      this.formData = {
        title: "",
        content: "",
      };
=======

    data() {
        return {
            board: {
                ask_title: '',
                ask_content: '',
                member_no:-1
            }
        };
>>>>>>> branch 'master' of https://github.com/smdyuq/ReturnProject.git
    },
<<<<<<< HEAD
    navigateToHome() {
      this.$router.push("/Board");
    },
  },
};
=======
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
>>>>>>> branch 'master' of https://github.com/smdyuq/ReturnProject.git
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
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 120px;
  height: 50px;
}
button:hover {
  background-color: #0056b3;
}

#message {
  height: 300px;
}
</style>

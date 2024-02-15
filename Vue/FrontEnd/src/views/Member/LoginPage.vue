<template>
    <div class="loginWrapper">
      <div class="loginWrap">
        
              <router-link to="/">
                  <div class="headerLogo">리턴나라</div>
              </router-link>
      
        <!-- <div class="title">Login</div>
      -->
        <form @submit.prevent="login">
          <div class="input-box">
            <input v-model="MemberId" type="text" placeholder="아이디">
            <label for="MemberId" hidden>아이디</label>
          </div>
  
          <div class="input-box">
            <input v-model="MemberPwd" type="password" placeholder="비밀번호">
            <label for="MemberPwd" hidden>비밀번호</label>
          </div>
  
          <button type="submit" class="btn" @click="login()">로그인</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
import axios from 'axios'

  export default {
    data() {
      return {
        MemberId: '',
        MemberPwd: ''
      }
    },
    methods: {
      login() {
    const userData = {
      MemberId: this.MemberId,
      MemberPwd: this.MemberPwd
    };

    axios.post('/member/login.do', userData)
      .then(response => {
        // 로그인 성공 시 처리
        console.log(response.data); // 서버로부터 받은 데이터
        this.$router.push('/')
        // 성공적으로 로그인한 후에 다음 단계 수행
        alert("로그인이 완료되었습니다.")
      })
      .catch(error => {
        alert("로그인을 실패하였습니다.")
        console.error(error);
      });
  }
        
        // 로그인 로직을 작성예정
        // 서버로 아이디와 비밀번호를 전송하고 응답을 처리하는 코드 등을 추가예정
      }
    }
  
  </script>
  
  <style scoped>
  .loginWrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  
  .loginWrap {
    width: 420px;
    height: 350px;
    /* border: 1px solid gray; */
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  
  .title {
    width: 420px;
    height: 60px;
    font-size: xx-large;
    font-weight: bolder;
    text-align: center;
  }
  
  .input-box {
    margin-bottom: 10px;
  }
  
  input[type="text"],
  input[type="password"] {
    width: 100%;
    height: 40px;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  button.btn {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: dimgray;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  
  button.btn:hover {
    background-color: gray;
  }

  .btn {
    background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  }

  .headerLogo {
    font-size:xx-large;
            font-weight: bold;
            text-align: center;
            background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
            -webkit-background-clip: text; /* 웹킷 브라우저에 대한 설정 */
            background-clip: text;
            color: transparent;

  }
  
  </style>
  
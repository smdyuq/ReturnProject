<template>
  <div class="loginWrapper">
    <div class="loginWrap">
      <router-link to="/">
        <div class="headerLogo">리턴나라</div>
      </router-link>

      <form @submit.prevent="login">
        <div class="input-box">
          <input v-model="memberId" type="text" placeholder="아이디">
          <label for="memberId" hidden>아이디</label>
        </div>

        <div class="input-box">
          <input v-model="memberPwd" type="password" placeholder="비밀번호">
          <label for="memberPwd" hidden>비밀번호</label>
        </div>

        <button type="submit" class="btn">로그인</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from '../../services/axios';

export default {
  data() {
    return {
      memberId: '',
      memberPwd: ''
    };
  },
  methods: {
    login() {
      if (this.memberId.trim() === '' || this.memberPwd.trim() === '') {
        alert('아이디 또는 비밀번호를 입력해주세요.');
        return;
      }

      const userData = {
        memberId: this.memberId,
        memberPwd: this.memberPwd
      };

      axios.post('/member/login', userData)
        .then(response => {
          if (response.data === 'success') {
            this.$session.start();
            this.$session.set('user', this.memberId); // 로그인한 사용자 아이디를 세션에 저장
            this.$router.push('/');
            alert('로그인이 완료되었습니다.');
          } else {
            alert('로그인을 실패하였습니다.');
          }
        })
        .catch(error => {
          alert('서버에 문제가 있습니다. 관리자에게 문의하세요.');
          console.error(error);
        });
    }
  }
};
</script>

<!-- 생략: Style 부분 -->

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
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
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
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
}

.headerLogo {
  font-size: xx-large;
  font-weight: bold;
  text-align: center;
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
}
</style>

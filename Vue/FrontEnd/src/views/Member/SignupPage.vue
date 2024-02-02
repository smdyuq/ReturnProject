<template>
  <div class="signupWrapper">
    <div class="signupWrap">
      <div class="title">Sign Up</div>
      
      <form @submit.prevent="signup">
        <div class="input-box">
          <input v-model="username" type="text" name="username" placeholder="아이디">
          <label for="username" hidden>아이디</label>
        </div>

        <div class="input-box">
          <input v-model="password" type="password" name="password" placeholder="비밀번호">
          <label for="password" hidden>비밀번호</label>
        </div>

        <div class="input-box">
          <input v-model="confirmPassword" type="password" name="confirmPassword" placeholder="비밀번호 확인">
          <label for="confirmPassword" hidden>비밀번호 확인</label>
        </div>

        <div class="input-box">
          <input v-model="phoneNumber" type="text" name="phoneNumber" placeholder="휴대폰 번호">
          <label for="phoneNumber" hidden>휴대폰 번호</label>
        </div>

        <div class="input-box">
          <input v-model="verificationCode" type="text" name="verificationCode" placeholder="인증 코드">
          <label for="verificationCode" hidden>인증 코드</label>
          <button type="button" class="btn-verification" @click="sendVerificationCode" :disabled="isVerificationCodeSent">인증 코드 전송</button>
        </div>

        <button type="submit" class="btn" click="signup()">회원 가입</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      confirmPassword: '',
      phoneNumber: '',
      verificationCode: '',
      isVerificationCodeSent: false
    }
  },
  methods: {
    signup() {
      this.$router.push("/");
      if (this.password !== this.confirmPassword) {
        alert("패스워드가 다릅니다.");
        return;
      }
      
      // 회원가입 로직을 작성하세요
      // 서버로 아이디, 비밀번호, 휴대폰 번호, 인증 코드 등을 전송하고 응답을 처리하는 코드 등을 추가해야 합니다
    },
    sendVerificationCode() {
      // 인증 코드 전송 로직을 작성하세요
      // 서버로 휴대폰 번호를 전송하고 인증 코드를 받아오는 코드 등을 추가해야 합니다
      // 이 예시에서는 간단히 인증 코드를 생성하여 화면에 출력하는 예시를 보여드리겠습니다
      const verificationCode = Math.floor(1000 + Math.random() * 9000); // 랜덤한 4자리 인증 코드 생성
      console.log('인증 코드:', verificationCode);
      
      // 실제로는 서버로 인증 코드를 전송하고, 휴대폰 번호에 해당하는 사용자에게 인증 코드를 전송해야 합니다
      // 이 예시에서는 콘솔에 인증 코드를 출력하는 것으로 대체합니다
      
      this.isVerificationCodeSent = true; // 인증 코드 전송 여부를 표시
    }
  }
}
</script>

<style scoped>
.signupWrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.signupWrap {
  width: 420px;
  height: 500px;
  border: 1px solid gray;
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

button.btn-verification {
  display: inline-block;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 8px;
  cursor: pointer;
}

button.btn-verification:disabled {
  background: linear-gradient(125deg, #FFA500, #FF6347, #FFA500);

  cursor: not-allowed;
}

.btn{
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
}


</style>

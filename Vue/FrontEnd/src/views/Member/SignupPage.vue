<template>
  <div class="signupWrapper">
    <div class="signupWrap">
      <router-link to="/">
                  <div class="headerLogo">리턴나라</div>
      </router-link>
      <!-- <div class="title">Sign Up</div> -->
      
      <form @submit.prevent="signup">
    <div class="input-box">
      <input v-model="post.memberId" type="text" name="memberId" placeholder="아이디">
      <label for="memberId" hidden>아이디</label>
    </div>
    
    <div class="input-box">
      <input v-model="post.memberName" type="text" name="memberName" placeholder="이름">
      <label for="memberName" hidden>이름</label>
    </div>

    <div class="input-box">
      <input v-model="post.memberPwd" type="password" name="memberPwd" placeholder="비밀번호">
      <label for="memberPwd" hidden>비밀번호</label>
    </div>

    <div class="input-box">
      <input v-model="post.confirmPassword" type="password" name="confirmPassword" placeholder="비밀번호 확인">
      <label for="confirmPassword" hidden>비밀번호 확인</label>
    </div>

    <div class="input-box">
      <input v-model="post.memberPhone" type="text" name="memberPhone" placeholder="휴대폰 번호">
      <label for="memberPhone" hidden>휴대폰 번호</label>
      <button type="button" class="btn-verification" @click="sendVerificationCode" :disabled="isVerificationCodeSent">인증 코드 전송</button>
    </div>

    <div class="input-box">
      <input v-model="post.verificationCode" type="text" name="authenticationCode" placeholder="인증 코드">
      <label for="authenticationCode" hidden>인증 코드</label>
      <button type="button" class="btn-verification" @click="verificationCodeCheck">인증 코드 확인</button>
    </div>

    <button type="submit" class="btn" @click="joinForm">회원 가입</button>
  </form>
    </div>
  </div>

</template>

<script>
import axiosApi from '../../services/axios';

export default {
  data() {
    return {
      post: {
        memberId: '',
        memberPwd: '',
        memberName:'',
        memberPhone: '',
        confirmPassword: '',
        verificationCode: '',
        isVerificationCodeSent: false,
        authenticationCode: 0
      },
      checkCode: 'TEST'
    };
  },
  methods: {
    joinForm() {
      console.log("a: "  + this.post.memberPwd)
      axiosApi.post("/member/register", this.post)
      .then((result) => {
          console.log(result);
          // if (result.status === 200 && this.isVerificationCodeSent ) {
          if (result.status === 200) {
            alert("회원 가입 성공");
            this.$router.push("/loginPage");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    sendVerificationCode() {
      axiosApi.get("/send-one?checkCode="+this.checkCode+"&memberPhone="+this.post.memberPhone)
      .then((result) => {
        if(result.status === 200) {
          this.post.authenticationCode = result.data, // 수정: result.data를 저장하도록 수정
          this.isVerificationCodeSent = true; // 수정: isVerificationCodeSent를 true로 설정하여 버튼 활성화
          console.log()
        }
      })
      .catch((err) => {
        console.log(err)
      })
    },
    verificationCodeCheck() {
  if(Number(this.post.verificationCode) === this.post.authenticationCode) {
    this.isVerificationCodeSent = true; // 인증 코드가 맞으면 isVerificationCodeSent를 true로 설정하여 버튼 활성화
  } else {
    alert("인증코드가 다릅니다");
  }
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

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
      <input v-model="post.verificationCode" type="text" name="verificationCode" placeholder="인증 코드">
      <label for="verificationCode" hidden>인증 코드</label>
    
      
      <label for="verificationCodeCheck" hidden>인증 코드 확인</label>
      <button type="button" class="btn-verification" @click="verificationCodeCheck" :disabled="verificationCodeCheck">인증 코드 확인</button>
    </div>
    


    <button type="submit" class="btn" @click="joinForm()">회원 가입</button>
  </form>
    </div>
  </div>

</template>

<script>
import axiosApi from '../../services/axios'



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
        authenticationCode: ''
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
        console.log(result)
        if(result.status === 200) {
          this.authenticationCode = result,
          this.authenticationCode = true;

        }
      })
      .catch((err) => {
        console.log(err)
      })
    },
    verificationCodeCheck() {
      if(this.verificationCode === this.authenticationCode) {
        this.isVerificationCodeSent = true
      } else {
        alert("인증코드가 다릅니다");
      }
    }

  }
}
  // signup() {
  //   if (this.password !== this.confirmPassword) {
  //     alert("패스워드가 다릅니다.");
  //     return;
  //   }

    // const userData = {
    //   username: this.username,
    //   password: this.password,
    //   phoneNumber: this.phoneNumber,
    //   verificationCode: this.verificationCode
//     };
// // 회원 가입 요청을 서버에 보내는 코드
// axios.post('/api/signup', userData)
//         .then(response => {
//           // 회원 가입 성공 시 처리할 로직
//           console.log(response.data);
//           // 예를 들어, 회원 가입이 성공적으로 완료되었다는 메시지를 사용자에게 표시할 수 있습니다.
//           alert('회원 가입이 완료되었습니다.');
//         })
//         .catch(error => {
//           // 회원 가입 실패 시 처리할 로직
//           console.error(error);
//           // 예를 들어, 회원 가입 중에 오류가 발생했다는 메시지를 사용자에게 표시할 수 있습니다.
//           alert('회원 가입 중 오류가 발생했습니다.');
//         });
//     },
//     sendVerificationCode() {
//       // 인증 코드 전송 로직을 작성하세요
//       // 서버로 휴대폰 번호를 전송하고 인증 코드를 받아오는 코드 등을 추가해야 합니다
//       // 이 예시에서는 간단히 인증 코드를 생성하여 화면에 출력하는 예시를 보여드리겠습니다
//       const verificationCode = Math.floor(1000 + Math.random() * 9000); // 랜덤한 4자리 인증 코드 생성
//       console.log('인증 코드:', verificationCode);

//       // 실제로는 서버로 인증 코드를 전송하고, 휴대폰 번호에 해당하는 사용자에게 인증 코드를 전송해야 합니다
//       // 이 예시에서는 콘솔에 인증 코드를 출력하는 것으로 대체합니다

//       this.isVerificationCodeSent = true; // 인증 코드 전송 여부를 표시
//     }
//   }

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

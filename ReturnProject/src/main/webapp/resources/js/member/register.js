let pwdFlag = false;
let pwdCheckFlag = false;
let emailFlag = false;

function flagCheck() {
   let submitBtn = document.getElementById('submit-btn');
    if (pwdFlag && emailFlag && pwdCheckFlag) {
        submitBtn.removeAttribute("disabled");
    } else {
        submitBtn.setAttribute("disabled", "true");
    }
}

// 비밀번호 유효성 검사
function validatePassword() {
   const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[@$!%*?&\#])[A-Za-z\d@$!%*?&\#]{6,20}$/;
   const password = document.getElementById("password").value;
   const msg = document.getElementById("pwdMsg");
   
   const passwordChk = document.getElementById("passwordChk").value;
   const pwdChkMsg = document.getElementById("pwdChkMsg");
   
   if(passwordRegex.test(password)) {
      msg.innerHTML = "사용 가능한 비밀번호입니다.";
      msg.style.color = "green";
      pwdFlag = true;
   } else {
      msg.innerHTML = "패스워드 정책에 맞지 않습니다.";
      msg.style.color = "red";
      pwdFlag = false;
   }
   
   if(password === passwordChk) {
      pwdChkMsg.innerHTML = "패스워드가 동일합니다.";
      pwdChkMsg.style.color = "green";
      pwdCheckFlag = true;
   } else {
      pwdChkMsg.innerHTML = "패스워드가 동일하지 않습니다.";
      pwdChkMsg.style.color = "red";
      pwdCheckFlag = false;
   }
   
   flagCheck();
}

// 이메일 중복 확인 Ajax
function checkEmail() {
   const email = $("#email").val();
   const emailMsg = $("#emailMsg");
   const emailRegex = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
   
   if(emailRegex.test(email)) {
      $.ajax({
         type: "POST",
         url: "/member/checkEmail.do",
         data: { email : email },
         success : function(response) { 
            if(response == "available") {
               emailMsg.html("사용 가능한 이메일입니다.").css("color", "green");
               emailFlag = true;
            } else {
               console.log(response);
               emailMsg.html("이미 사용중인 이메일입니다.").css("color", "red");
               emailFlag = false;
            }
         },
         error : function() { }
      });
   } else {
      emailMsg.html("이메일 형식이 맞지 않습니다.").css("color", "red");
      emailFlag = false;
   }
   
   flagCheck();
}
<template>
  <div class="contact-us">
    <h2 style="margin-top: 20px; margin-bottom: 20px">1:1 문의하기</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" id="title" v-model="formData.title" required />
      </div>
      <div class="form-group">
        <label for="message">내용</label>
        <textarea id="message" v-model="formData.content" required></textarea>
      </div>
      <button type="submit" @click="navigateToHome">전송</button>
    </form>
  </div>
</template>

<script>
export default {
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
    },
    navigateToHome() {
      this.$router.push("/Board");
    },
  },
};
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

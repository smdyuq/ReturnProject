<template>
  <div class="contact-us">
    <h1>1:1 문의하기</h1>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="name">이름</label>
        <input type="text" id="name" v-model="formData.name" required>
      </div>
      <div class="form-group">
        <label for="email">이메일</label>
        <input type="email" id="email" v-model="formData.email" required>
      </div>
      <div class="form-group">
        <label for="message">메시지</label>
        <textarea id="message" v-model="formData.message" required></textarea>
      </div>
      <button type="submit">전송</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      formData: {
        name: '',
        email: '',
        message: ''
      }
    };
  },
  methods: {
    submitForm() {
      // 여기에 폼 데이터를 서버로 전송하는 로직을 추가할 수 있습니다.
      console.log('Form submitted!', this.formData);
      // 전송 후에 폼을 초기화하거나 다음 단계로 넘어갈 수 있습니다.
      this.formData = {
        name: '',
        email: '',
        message: ''
      };
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
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
</style>

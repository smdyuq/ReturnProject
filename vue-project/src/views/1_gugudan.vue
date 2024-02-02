<template>
    <div id="quiz-9">
        <!-- first와 second는 Math.ceil(Math.random()*9) 를 사용해서 랜덤으로 숫자 출력 -->
        <p>{{first}} * {{second}}</p>
        <input type="text" v-model="inputNumber"/>
        <button @click="quizCheck">제출</button>
        <p> {{ result }}</p>
    </div>
</template>
<script>
export default {
    data() {
        return {
            first: Math.ceil(Math.random()*9),
            second: Math.ceil(Math.random()*9),
            inputNumber: null,
            result: null
        }
    },
    methods: {
        quizCheck: function() {
            // 정답인지 아닌지 확인
            if(this.first * this.second === parseInt(this.inputNumber)) {
                this.result = '정답입니다.';
                // 정답일 경우 숫자 다시 생성
                this.first = Math.ceil(Math.random()*9);
                this.second = Math.ceil(Math.random()*9);
            } else {
                this.result = '틀렸습니다.';
            }
        }
    }
}
</script>
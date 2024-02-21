<template>
    <div id="quiz-8">
        <p v-if="flag">텍스트</p>
        <button @click="reverseFlag">클릭</button>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                flag: true,
                kor: '보임'
            }
        },
        methods: {
            reverseFlag: function() {
                this.flag = !this.flag;

                if(this.flag) {
                    this.kor = '보임';
                } else {
                    this.kor = '안보임';
                }

                this.$emit('kor', this.kor);
                this.$emit('reverseFlag', this.flag);
            }
        }
    }
</script>

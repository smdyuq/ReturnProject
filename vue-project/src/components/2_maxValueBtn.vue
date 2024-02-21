<template>
    <div id="quiz-7">
        <p v-if="count<20">{{ count }}</p>
        <p v-else-if="count>=20">20</p>
        <button @click="addCount">버튼을 눌러주세요.</button>

        <p>maxValueBtn 입니다. {{ kor }}</p>
    </div>
</template>
<script>
    export default {
        props: ['kor'],
        data() {
            return {
                count: 0
            }
        },
        methods: {
            addCount() {
                this.count++;
                this.$emit('addCount', this.count);
            }
        }
    }
</script>






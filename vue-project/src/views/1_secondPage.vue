<template>
    <div id="btn">
        <button @click="count++">
            second : {{ count }}번 클릭되었습니다.
        </button>
        <br>
        <!-- <button @click="goHome()"> -->
        <button @click="this.$router.push('/')">
            홈으로 돌아가기
        </button>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                count: 0
            }
        },
        methods: {
            goHome() {
                this.$router.push('/');
            }
        }
    }
</script>
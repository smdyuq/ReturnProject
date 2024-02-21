<template>
    <div>
        <hide-btn @reverseFlag="flagMethods" @kor="inputKor"></hide-btn>

        <maxValueBtn :kor="kor" @addCount="countMethods"></maxValueBtn>

        <p>flag : {{ flag }}</p>
        <p>count : {{ count }}</p>
    </div>
</template>


<script>
import hideBtn from '../components/2_hideBtn.vue'
import maxValueBtn from '../components/2_maxValueBtn.vue'

export default {
    components: {
        hideBtn,
        maxValueBtn
    },
    data() {
        return {
            flag: true,
            count: 0,
            kor: '보임'
        }
    },
    methods: {
        countMethods(count) {
            this.count = count;
        },
        flagMethods(flag) {
            this.flag = flag;
        },
        inputKor(kor) {
            this.kor = kor;
        }
    }
}
</script>
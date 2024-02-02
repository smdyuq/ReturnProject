<template>
    <div>
        <hide-btn></hide-btn>
        <maxValueBtn></maxValueBtn>

        <p>flag : {{ combinedGetFlag }}</p>
        <p>count : {{ combinedGetCount }}</p>
    </div>
</template>


<script>
import { mapState } from 'pinia';
import { combinedStore } from '../stores/combinedStore'
import hideBtn from '../components/3_hideBtn.vue'
import maxValueBtn from '../components/3_maxValueBtn.vue'

export default {
    components: {
        hideBtn,
        maxValueBtn
    },
    computed: {
        ...mapState(combinedStore, ['combinedGetCount', 'combinedGetFlag'])
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
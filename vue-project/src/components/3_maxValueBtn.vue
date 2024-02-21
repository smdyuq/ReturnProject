<template>
    <div id="quiz-7">
        <p v-if="combinedGetCount<20">{{ combinedGetCount }}</p>
        <p v-else-if="combinedGetCount>=20">20</p>
        <button @click="addCount">버튼을 눌러주세요.</button>

        <p>maxValueBtn 입니다. {{ combinedGetKor }}</p>
    </div>
</template>
<script>
import { mapActions, mapState } from 'pinia';
import { combinedStore } from '../stores/combinedStore'

    export default {
        computed: {
            ...mapState(combinedStore, ['combinedGetCount', 'combinedGetKor'])
        },
        methods: {
            ...mapActions(combinedStore, ['combinedAddCount']),
            addCount() {
                this.combinedAddCount();
            }
        }
    }
</script>






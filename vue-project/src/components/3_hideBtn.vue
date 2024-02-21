<template>
    <div id="quiz-8">
        <p v-if="combinedGetFlag">텍스트</p>
        <button @click="reverseFlag">클릭</button>
    </div>
</template>
<script>
import { mapActions, mapState } from 'pinia'
import { combinedStore } from '../stores/combinedStore'

    export default {
        computed: {
            ...mapState(combinedStore, ['combinedGetFlag'])
        },
        methods: {
            ...mapActions(combinedStore, ['combinedReverseFlag']),
            reverseFlag: function() {
                this.combinedReverseFlag();
            }
        }
    }
</script>

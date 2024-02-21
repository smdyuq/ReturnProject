<template>
    <div>
        <button @click="clickCount">클릭</button>
        <p> 자식 컴퍼넌트 이름 : {{ getName }} </p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { parentStore } from '../stores/parent';

export default {
    data() {
        return {
            count: 0
        }
    },
    computed: {
        // ...mapState(parentStore, ['getName', 'getCount'])
        ...mapState(parentStore, ['getName'])
    },
    methods: {
        ...mapActions(parentStore, ['addCount']),
        clickCount() {
            this.addCount();

            // let count = this.getCount;
            // count++;
            // this.addCount(count);

            // this.count++;
            // this.addCount(this.count);
        }
    }
}
</script>
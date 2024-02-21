<template>
    <div>
        <h1>부모 컴포넌트</h1>
        <child-component-1/>
        <p>클릭 횟수: {{ getCount }}</p>
    </div>
</template>
<script>
import childComponent1 from '../components/3_child1.vue'
import { mapState } from 'pinia'
import {parentStore} from '../stores/parent'

export default {
    components: {
        childComponent1
    },
    computed: {
        ...mapState(parentStore, ['getCount'])
    }
}
</script>
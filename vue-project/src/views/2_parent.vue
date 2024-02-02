<template>
    <div>
        <h1>부모 컴포넌트</h1>
        <child-component-1 :name222="name" @childCount="addCount"/>
        <p>클릭 횟수: {{ count }}</p>
    </div>
</template>
<script>
import childComponent1 from '../components/2_child1.vue'

export default {
    components: {
        childComponent1
    },
    data() {
        return {
            count: 0,
            name: 'Hello, Vue.js'
        }
    },
    methods: {
        addCount(count) {
            this.count = count;
        }
    }
}
</script>
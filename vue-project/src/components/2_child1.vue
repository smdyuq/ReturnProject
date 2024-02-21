<template>
    <div>
        <button @click="clickCount">클릭</button>
        <p> 자식 컴퍼넌트 이름 : {{ name222 }} </p>
    </div>
</template>
<script>
export default {
    props: ['name222'],
    data() {
        return {
            count: 0
        }
    },
    methods: {
        clickCount() {
            this.count++;
            this.$emit('childCount', this.count);
        }
    }
}
</script>
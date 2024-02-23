<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <StoreLike></StoreLike>
    <card-wrapper></card-wrapper>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue'
import SidebarVue from '../components/layout/Sidebar.vue'
import FooterVue from '../components/layout/Footer.vue'
import StoreLike from '../components/layout/StoreLike.vue'
import CardWrapper from '..//components/layout/CardWrapper.vue'

export default {
    components: {
        HeaderVue,
        SidebarVue,
        FooterVue,
        StoreLike,
        CardWrapper

    }
}
</script>
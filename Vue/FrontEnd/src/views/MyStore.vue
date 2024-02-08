<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <StoreVue></StoreVue>
    <card-wrapper></card-wrapper>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue'
import SidebarVue from '../components/layout/Sidebar.vue'
import FooterVue from '../components/layout/Footer.vue'
import StoreVue from '../components/layout/Store.vue'
import CardWrapper from '..//components/layout/CardWrapper.vue'

export default {
    components: {
        HeaderVue,
        SidebarVue,
        FooterVue,
        StoreVue,
        CardWrapper

    }
}
</script>
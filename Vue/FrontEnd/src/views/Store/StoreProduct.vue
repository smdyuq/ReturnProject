<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <StoreProduct></StoreProduct>
    <card-wrapper></card-wrapper>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../../components/layout/Header.vue'
import SidebarVue from '../../components/layout/Sidebar.vue'
import FooterVue from '../../components/layout/Footer.vue'
import CardWrapper from '../../components/layout/CardWrapper.vue'
import StoreProduct from '../../components/Store/StoreProduct.vue'

export default {
    components: {
    HeaderVue,
    SidebarVue,
    FooterVue,
    CardWrapper,
    StoreProduct
}
}
</script>
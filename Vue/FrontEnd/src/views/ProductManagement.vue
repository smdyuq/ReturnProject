<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <NavVue></NavVue>
    <product-manager/>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue'
import SidebarVue from '../components/layout/Sidebar.vue'
import FooterVue from '../components/layout/Footer.vue'
import NavVue from '../components/layout/Nav.vue'
import ProductManager from '../components/product/ProductManager.vue'

export default {
    components: {
        HeaderVue,
        SidebarVue,
        FooterVue,
        NavVue,
        ProductManager

    }
}
</script>
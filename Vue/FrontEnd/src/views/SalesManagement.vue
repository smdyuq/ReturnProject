<template>

    <div style="height:310vh;">

        <HeaderVue></HeaderVue>
        <SidebarVue></SidebarVue>
        <NavVue></NavVue>
        <ProductRegistrationVue></ProductRegistrationVue>

    </div>
    <FooterVue id="footer"></FooterVue>

</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import FooterVue from '../components/layout/Footer.vue';
import ProductRegistrationVue from '../components/product/ProductRegistration.vue';
import NavVue from '../components/layout/Nav.vue';

export default {
    components: {
    HeaderVue,
    FooterVue,
    SidebarVue,
    ProductRegistrationVue,
    NavVue
}
}
</script>

<style>
div {
    position:relative;
    
}

#footer {
    position:absolute;
    bottom:0;
}
</style>
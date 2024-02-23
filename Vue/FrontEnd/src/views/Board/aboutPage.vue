<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <AboutVue></AboutVue>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../../components/layout/Header.vue'
import SidebarVue from '../../components/layout/Sidebar.vue'
import FooterVue from '../../components/layout/Footer.vue'
import AboutVue from '../../components/layout/About.vue'


export default {
    components: {
        HeaderVue,
        SidebarVue,
        AboutVue,
        FooterVue
    }
}
</script>


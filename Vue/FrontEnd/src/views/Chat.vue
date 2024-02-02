<template>
    <HeaderVue></HeaderVue>
    <SidebarVue></SidebarVue>
    <ChatVue></ChatVue>
    <FooterVue></FooterVue>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue'
import SidebarVue from '../components/layout/Sidebar.vue'
import FooterVue from '../components/layout/Footer.vue'
import ChatVue from '../components/layout/Chat.vue'

export default {
    components: {
        HeaderVue,
        SidebarVue,
        ChatVue,
        FooterVue

    }
}
</script>


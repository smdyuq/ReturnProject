<template>
    <Header-vue/>
    <Sidebar-vue/>
    <CategoryAll-Vue/>
    <CardWrapper-Vue/>
    <Footer-Vue/>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryAllVue from '../components/Category/CategoryAll.vue';



export default {
    components: {   
        HeaderVue,
        SlideVue,
        FooterVue,
        CardWrapperVue,
        SidebarVue,
        CategoryAllVue
    }
}
</script>
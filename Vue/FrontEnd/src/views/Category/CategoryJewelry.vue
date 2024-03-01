<template>
    <Header-vue/>
    <Sidebar-vue/>
    <CategoryJewelryVue/>
    <CardWrapper-Vue/>
    <Footer-Vue/>
</template>

<script>
import HeaderVue from '../../components/layout/Header.vue';
import FooterVue from '../../components/layout/Footer.vue';
import SlideVue from '../../components/layout/Slide.vue';
import CardWrapperVue from '../../components/layout/CardWrapper.vue';
import SidebarVue from '../../components/layout/Sidebar.vue';
import CategoryJewelryVue from '../../components/Category/CategoryJewelry.vue';



export default {
    components: {   
        HeaderVue,
        SlideVue,
        FooterVue,
        CardWrapperVue,
        SidebarVue,
        CategoryJewelryVue
    }
}
</script>
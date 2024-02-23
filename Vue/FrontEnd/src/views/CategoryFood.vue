<template>
    <Header-vue/>
    <Sidebar-vue/>
    <CategoryFood-Vue/>
    <CardWrapper-Vue/>
    <Footer-Vue/>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryFoodVue from '../components/layout/CategoryFood.vue';

export default {
    components: {   
        HeaderVue,
        SlideVue,
        FooterVue,
        CardWrapperVue,
        SidebarVue,
        CategoryFoodVue
    }

}
</script>
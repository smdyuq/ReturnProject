    <template>
    
            <HeaderVue></HeaderVue>
            <SidebarVue></SidebarVue>
                <SlideVue/>
                <p style="font-size: x-large; display:flex; width:1024px; margin-top:1rem; font-weight:bold;">오늘의 상품추천</p>
                <CardWrapperVue/>
            <FooterVue/>
    
    </template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';

export default {
    components: {   
        HeaderVue,
        SlideVue,
        FooterVue,
        CardWrapperVue,
        SidebarVue
    }
}
</script>

<style scoped>

</style>


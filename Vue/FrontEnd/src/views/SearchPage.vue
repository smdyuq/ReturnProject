<template>
    <Header-vue/>
    <Sidebar-vue />
    <!-- {{ queryData }} -->
    <CategoryAll-Vue />
    <CardWrapper-Vue />
    <!-- <div class="품목들">
        <div class="품목" v-for=" data of datas2">
            <div class="상품 no"> {{ data.salesNo }} </div>
            <div class="name"> {{ data.salesName }} </div>
            <div class="cate"> {{ data.salesCategory }} </div>
        </div>
    </div> -->
    <div class="wrap"></div>
    <Footer-Vue />
</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryAllVue from '../components/Category/CategoryAll.vue';
import axios from '../services/axios';
import { mapActions } from 'pinia';
import { recentSearchesStore } from '@/stores/Search/Search';

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

<style>
.wrap {
    height: 50vh;
}
</style>
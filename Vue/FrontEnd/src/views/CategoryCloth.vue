<template>
    <Header-vue/>
    <Sidebar-vue/>
    <CategoryCloth-Vue/>
    <CardWrapper-Vue/>
    <Footer-Vue/>
</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryClothVue from '../components/layout/CategoryCloth.vue';

import axiosApi from '../services/axios';
import { mapActions, mapState } from 'pinia';
import { usersStore } from '../stores/Home';

export default {
    components: {   
        HeaderVue,
        SlideVue,
        FooterVue,
        CardWrapperVue,
        SidebarVue,
        CategoryClothVue
    },
    mounted() {
        this.getCloth();
    },
    computed: {
        ...mapState(usersStore, ['getStatus'])
    },
    methods: {
        ...mapActions(usersStore, ['addCloth','addStatus']),
        getCloth() {
            this.addStatus('의류');
            axiosApi.get('/main/categorySales?salesCategory='+this.getStatus)
                .then(response => {
                    this.addCloth(response.data.list);
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }
}
</script>
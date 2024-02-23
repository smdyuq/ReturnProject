<template>
  <div>
    <Header-vue />
    <Sidebar-vue />
    <CategoryAll-Vue />
    <CardWrapper-Vue />
    <Footer-Vue />
  </div>
</template>

<script>

import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryAllVue from '../components/layout/CategoryAll.vue';

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
        CategoryAllVue
    },
    mounted() {
        this.getAll1();
    },

    computed: {
        ...mapState(usersStore, ['getStatus','getAll'])
    },
    methods: {
        ...mapActions(usersStore, ['addAll','addStatus']),
        getAll1() {
            this.addStatus('전체');
            axiosApi.get('/main/categorySales?salesCategory='+this.getStatus)
    
            .then(response => {
                this.addAll(response.data.list);
            })
            .catch(error => {
                console.error(error);
            });
        }
    }

}

</script>
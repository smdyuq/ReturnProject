import { createRouter, createWebHistory } from 'vue-router'
import home from '../views/home.vue'
import firstPage from '../views/1_firstPage.vue'
import secondPage from '../views/1_secondPage.vue'
import notFound from '../views/common/404.vue'
import gugudanPage from '../views/1_gugudan.vue'
import componentView from '../views/2_componentView.vue'
import combinedBtn from '../views/2_combinedBtn.vue'
import parentComponenmt from '../views/2_parent.vue'
import addUser from '../views/3_addUser.vue'
import piniaParent from '../views/3_parent.vue'
import piniaCombined from '../views/3_combinedBtn.vue'
import testAxios from '../views/4_testAxios.vue'
import boardList from '../views/4_boardList.vue'
import infoList from '../views/infoList.vue'
import freeEnroll from '../views/4_freeEnroll.vue'
import infoEnroll from '../views/4_infoEnroll.vue'
import freeDetail from '../views/4_freeDetail.vue'
import freeEditForm from '../views/4_freeEditForm.vue'

const routes = [
    { path: '/', name: "home", component: home },
    { path: '/freeEditForm', name: "freeEditForm", component: freeEditForm },
    { path: '/freeDetail', name: "freeDetail", component: freeDetail },
    { path: '/infoEnroll', name: "infoEnroll", component: infoEnroll },
    { path: '/freeEnroll', name: "freeEnroll", component: freeEnroll },
    { path: '/boardList', name: "boardList", component: boardList },
    { path: '/infoList', name: "infoList", component: infoList },
    { path: '/first', name: "first", component: firstPage },
    { path: '/second', name: "second", component: secondPage },
    { path: '/notFound', name: 'notFound', component: notFound },
    { path: '/gugudan', name: 'gugudan', component: gugudanPage },
    { path: '/combinedBtn', name: 'combinedBtn', component: combinedBtn },
    { path: '/componentView', name: 'componentView', component: componentView },
    { path: '/parent', name: 'parent', component: parentComponenmt },
    { path: '/addUser', name: 'addUser', component: addUser },
    { path: '/piniaParent', name: 'piniaParent', component: piniaParent },
    { path: '/piniaCombined', name: 'piniaCombined', component: piniaCombined },
    { path: '/testAxios', name: 'testAxios', component: testAxios },
    { path: '/:pathMatch(.*)*', redirect: '/notFound' }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;




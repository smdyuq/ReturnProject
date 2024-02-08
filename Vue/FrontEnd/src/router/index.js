import { createRouter, createWebHistory } from 'vue-router'
import home from '../views/Home.vue'
import login from '../views/Member/LoginPage.vue'
import Signup from '../views/Member/SignupPage.vue'
import SalesManagement from '../views/SalesManagement.vue'
import MyStore from '../views/MyStore.vue'
import Chat from '../views/Chat.vue'
import ProductManagement from '../views/Product/ProductManagement.vue'
import Category from '../views/Category.vue'
import Admin from '../views/Admin/Admin.vue'
import ProductDetail from '../views/Product/ProductDetail.vue'
import Event1 from '../views/Event/Event1.vue'
import Event2 from '../views/Event/Event2.vue'
import Event3 from '../views/Event/Event3.vue'
import Payment from '../views/Payment.vue'


const routes = [
    { path: '/', name: "home", component: home },
    { path: '/LoginPage', name:"login", component: login},
    { path: '/SignupPage', name:'Signup', component: Signup},
    { path: '/SalesManagement', name:'SalesManagement', component:SalesManagement},
    { path: '/MyStore', name:'MyStore', component:MyStore},
    { path: '/Chat', name:'Chat', component:Chat},
    { path: '/ProductManagement', name:'ProductManagement', component:ProductManagement},
    { path: '/Category', name:'Category', component:Category},
    { path: '/Admin', name:'Admin', component:Admin},
    { path: '/ProductDetail', name:'ProductDetail', component:ProductDetail},
    { path: '/Event1', name:'Event1', component:Event1},
    { path: '/Event2', name:'Event2', component:Event2},
    { path: '/Event3', name:'Event3', component:Event3},
    { path: '/Payment', name:'Payment', component:Payment}
    

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;




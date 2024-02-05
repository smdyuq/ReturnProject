import { createRouter, createWebHistory } from 'vue-router'
import home from '../views/Home.vue'
import login from '../views/Member/LoginPage.vue'
import Signup from '../views/Member/SignupPage.vue'
import SalesManagement from '../views/SalesManagement.vue'
import MyStore from '../views/MyStore.vue'
import Chat from '../views/Chat.vue'
import ProductManagement from '../views/ProductManagement.vue'
import Category from '../views/Category.vue'
import Admin from '../views/Admin/Admin.vue'


const routes = [
    { path: '/', name: "home", component: home },
    { path: '/LoginPage', name:"login", component: login},
    { path: '/SignupPage', name:'Signup', component: Signup},
    { path: '/SalesManagement', name:'SalesManagement', component:SalesManagement},
    { path: '/MyStore', name:'MyStore', component:MyStore},
    { path: '/Chat', name:'Chat', component:Chat},
    { path: '/ProductManagement', name:'ProductManagement', component:ProductManagement},
    { path: '/Category', name:'Category', component:Category},
    { path: '/Admin', name:'Admin', component:Admin}
    

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;




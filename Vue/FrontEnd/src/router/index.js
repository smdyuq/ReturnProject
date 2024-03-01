import { createRouter, createWebHistory } from 'vue-router'
import home from '../views/Home.vue'
import login from '../views/Member/LoginPage.vue'
import Signup from '../views/Member/SignupPage.vue'
import SalesManagement from '../views/SalesManagement.vue'
import StoreProduct from '../views/Store/StoreProduct.vue'
import StoreLike from '../views/Store/StoreLike.vue'
import aboutPage from '../views/Board/aboutPage.vue'
import ProductManagement from '../views/Product/ProductManagement.vue'
import CategoryAll from '../views/Category/CategoryAll.vue'
import CategoryFood from '../views/Category/CategoryFood.vue'
import CategoryCloth from '../views/Category/CategoryCloth.vue'
import CategoryHomeAppliances from '../views/Category/CategoryHomeAppliances.vue'
import CategoryJewelry from '../views/Category/CategoryJewelry.vue'
import Admin from '../views/Admin/Admin.vue'
import AdminLogin from '../views/Admin/AdminLogin.vue'
import AdminSignup from '../views/Admin/AdminSignup.vue'
import AdminAnswer from '../views/Admin/AdminAnswer.vue'
import ProductDetail from '../views/Product/ProductDetail.vue'
import Event1 from '../views/Event/Event1.vue'
import Event2 from '../views/Event/Event2.vue'
import Event3 from '../views/Event/Event3.vue'
import Payment from '../views/Payment/Payment.vue'
import PaymentCompleted from '../views/Payment/PaymentCompleted.vue'
import Board from '../views/Board/Board.vue'
import searchPage from '../views/searchPage.vue'


const routes = [
    { path: '/', name: "home", component: home },
    { path: '/LoginPage', name:"login", component: login},
    { path: '/SignupPage', name:'Signup', component: Signup},
    { path: '/SalesManagement', name:'SalesManagement', component:SalesManagement},
    { path: '/StoreProduct', name:'StoreProduct', component:StoreProduct},
    { path: '/StoreLike', name:'StoreLike', component:StoreLike},
    { path: '/aboutPage', name:'aboutPage', component:aboutPage},
    { path: '/ProductManagement', name:'ProductManagement', component:ProductManagement},
    { path: '/CategoryAll', name:'CategoryAll', component:CategoryAll},
    { path: '/CategoryFood', name:'CategoryFood', component:CategoryFood},
    { path: '/CategoryCloth', name:'CategoryCloth', component:CategoryCloth},
    { path: '/CategoryHomeAppliances', name:'CategoryHomeAppliances', component:CategoryHomeAppliances},
    { path: '/CategoryJewelry', name:'CategoryJewelry', component:CategoryJewelry},
    { path: '/Admin', name:'Admin', component:Admin},
    { path: '/AdminLogin', name:'AdminLogin', component:AdminLogin},
    { path: '/AdminSignup', name:'AdminSignup', component:AdminSignup},
    { path: '/AdminAnswer', name:'AdminAnswer', component:AdminAnswer},
    { path: '/ProductDetail', name:'ProductDetail', component:ProductDetail},
    { path: '/Event1', name:'Event1', component:Event1},
    { path: '/Event2', name:'Event2', component:Event2},
    { path: '/Event3', name:'Event3', component:Event3},
    { path: '/Payment', name:'Payment', component:Payment},
    { path: '/PaymentCompleted', name:'PaymentCompleted', component:PaymentCompleted},
    { path: '/Board', name:'Board', component:Board},
    { path: '/searchPage', name:'searchPage', component:searchPage},
    
    
    

];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;




import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import { createPinia } from 'pinia'
import VueSession from 'vue-session'


const pinia = createPinia()
createApp(App)
.use(router)
.use(pinia)
.mount('#app')


Vue.use(VueSession);
// var sessionOptions = {
//     persist: true
// }
// VueSession.use(VueSession, sessionOptions)

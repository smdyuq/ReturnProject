import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index.js'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate' //피니아

const application = createApp(App)

const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)
application.use(pinia)

createApp(App)
.use(router)
.use(pinia)
.mount('#app')


// Vue.use(VueSession);
// VueSession.use(VueSession, sessionOptions)

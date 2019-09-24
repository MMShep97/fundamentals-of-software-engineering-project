import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'

import Welcome from './components/Welcome.vue'
import Login from './components/Login.vue'

Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    { path: '/', component: Welcome},
    { path: '/login', component: Login},
    { path: '*', redirect: '/'}
  ],

  mode: 'history'
})

Vue.config.productionTip = false

var bus = new Vue({})

new Vue({
  router,
  data: {
    bus: bus,
  },
  render: h => h(App),
}).$mount('#app')

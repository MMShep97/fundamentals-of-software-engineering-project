import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import Welcome from './components/Welcome.vue'
import Login from './components/LoginContainer/Login.vue'
import Signup from './components/LoginContainer/Signup.vue'

Vue.use(VueRouter);
Vue.use(BootstrapVue);

const router = new VueRouter({
  routes: [
    { path: '/', component: Welcome},
    { path: '/login', component: Login},
    { path: '/signup', component: Signup},
    { path: '*', redirect: '/'}
  ],

  mode: 'history'
})

// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');

// if (authRequired && !loggedIn) {
//   return next('/login');
// })

// next();

Vue.config.productionTip = false

export const bus = new Vue()

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

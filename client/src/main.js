import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import * as VeeValidate from 'vee-validate'

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.use(VeeValidate);

import { configureFakeBackend } from './_helpers';
import { store } from './_store'
import { router } from './_helpers/router'
configureFakeBackend();

Vue.config.productionTip = false

export const bus = new Vue()

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')

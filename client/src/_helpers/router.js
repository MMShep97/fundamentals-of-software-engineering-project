import Vue from 'vue';
import Router from 'vue-router';

import BaseWelcomePage from '../components/welcome/BaseWelcomePage'
import LoginPage from '../components/login/LoginPage'
import RegisterPage from '../components/register/RegisterPage'

import BaseUserProfile from '../components/user/BaseUserProfile'

Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    { path: '/', component: BaseWelcomePage },
    { path: '/login', component: LoginPage },
    { path: '/register', component: RegisterPage },
    { path: '/user-profile', component: BaseUserProfile, },

    // otherwise redirect to home
    { path: '*', redirect: '/' }
  ]
});

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/', '/login', '/register'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  if (authRequired && !loggedIn) {
    return next('/login');
  }

  next();
})
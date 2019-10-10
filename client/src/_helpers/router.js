import Vue from 'vue';
import Router from 'vue-router';

import WelcomePage from '../components/WelcomePage'
import LoginPage from '../components/login/LoginPage'
import RegisterPage from '../components/register/RegisterPage'
import UserProfile from '../components/user/UserProfile'

Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    { path: '/', component: WelcomePage },
    { path: '/login', component: LoginPage },
    { path: '/register', component: RegisterPage },
    { path: '/user-profile', component: UserProfile },

    // otherwise redirect to home
    { path: '*', redirect: '/' }
  ]
});

router.beforeEach((to, from, next) => {
  // redirect to login page if not logged in and trying to access a restricted page
  const publicPages = ['/login', '/register'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  if (authRequired && !loggedIn) {
    return next('/login');
  }

  next();
})
import { userService } from '../_services/user.service';
import { router } from '../_helpers';

const user = JSON.parse(localStorage.getItem('user'));
const state = user
    ? { status: { loggedIn: true }, user }
    : { status: {}, user: null };

const actions = {
    async login({ dispatch, commit }, { username, password }) {
        commit('loginRequest', { username });
    
        let outcome = await userService.login(username, password)
            
                    if (outcome == true) {
                    commit('loginSuccess', user);
                    router.push('/');
                    }

                    else {
                        commit('loginFailure', error);
                        dispatch('alert/error', error, { root: true });
                    }
    },
    logout({ commit }) {
        userService.logout();
        commit('logout');
    },
    register({ dispatch, commit }, user) {
        commit('registerRequest', user);
    
        userService.register(user)
            .then(
                user => {
                    commit('registerSuccess', user);
                    setTimeout(() => {
                        // display success message after route change completes
                        dispatch('alert/success', 'Registration successful', { root: true });
                    })
                },
                error => {
                    commit('registerFailure', error);
                    dispatch('alert/error', error, { root: true });
                }
            );
    },

    adminAddsUser({dispatch, commit }, user) {
        commit('registerRequest', user);
        commit('regist')
    }
};

const mutations = {
    loginRequest(state, user) {
        state.status = { loggingIn: true };
        state.user = user;
    },
    loginSuccess(state, user) {
        state.status = { loggedIn: true };
        state.user = user;
    },
    loginFailure(state) {
        state.status = {};
        state.user = null;
    },
    logout(state) {
        state.status = {};
        state.user = null;
    },
    registerRequest(state, user) {
        state.status = { registering: true };
    },
    registerSuccess(state, user) {
        state.status = { registerSucess: true };
    },
    registerFailure(state, error) {
        state.status = { registerSuccess: false };
    }
};

export const account = {
    namespaced: true,
    state,
    actions,
    mutations
};
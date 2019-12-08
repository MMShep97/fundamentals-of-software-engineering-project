import {
    userService
} from '../_services/user.service';
import {
    router
} from '../_helpers';
import {
    api
} from '../_services/api.service';
import {
    sendEmail
} from '../_services/utility.service'

const FROM_EMAIL = 'MMShep97@gmail.com'
const SUBJECT = 'Welcome to Educadia!';
const BODY = "Why don't you stay awhile?"

const user = JSON.parse(localStorage.getItem('user'));
const state = user ? {
    status: {
        loggedIn: true
    },
    user
} : {
    status: {},
    user: null
};

const actions = {
    async login({ dispatch, commit }, { username, password }) {
        commit('loginRequest', { username });
    
        let {user, valid } = await userService.login(username, password)

            if (valid == true) {
                commit('loginSuccess', user);
                router.push('/')
                }

                else {
                    commit('loginFailure', 'Username or Password is incorrect');
                    dispatch('alert/error', 'Username or Password is incorrect', { root: true });
                }
    },
    logout({
        commit
    }) {
        userService.logout();
        commit('logout');
    },

    async register({
        dispatch,
        commit
    }, user) {
        commit('registerRequest', user);

        userService.register(user).then(resolve => {
                commit('registerSuccess', user);
                // display success message after route change completes
                dispatch('alert/success', 'Registration successful', {
                    root: true
                });
                //router.push('/login');
            },

            reject => {
                commit('registerFailure', reject);
                dispatch('alert/error', reject, {
                    root: true
                });
            }
        );
    }

    // sendEmail(user.studentId, user.firstName, FROM_EMAIL, SUBJECT, BODY)
};

const mutations = {
    loginRequest(state, user) {
        state.status = {
            loggingIn: true
        };
        state.user = user;
    },
    loginSuccess(state, user) {
        state.status = {
            loggedIn: true
        };
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
        state.status = {
            registering: true
        };
    },
    registerSuccess(state, user) {
        state.status = {
            registerSucess: true
        };
    },
    registerFailure(state, error) {
        state.status = {
            registerSuccess: false
        };
    }
};

export const account = {
    namespaced: true,
    state,
    actions,
    mutations
};
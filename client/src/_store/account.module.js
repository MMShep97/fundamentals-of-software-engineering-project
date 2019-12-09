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


const user = JSON.parse(localStorage.getItem('user'));
console.log('in account module')
const state = user ? { status: {loggedIn: true }, user } : { status: {}, user: null };
state.status.addedCourse = false;

const actions = {
    async login({ dispatch, commit }, { username, password }) {
        commit('loginRequest', { username });
    
        let {user, valid } = await userService.login(username, password)

            if (valid == true) {
                commit('loginSuccess', user);
                dispatch('alert/success', 'Successfully Logged In. Sending you to the Home Screen!', { root: true } )
                setTimeout(function() { router.push('/') }, 1000)
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
    }, user ) {
        commit('registerRequest', user);
        console.log('username' + user.username)
        console.log('testing: ' + user)
        // console.log('testing: ' + userId)
        await userService.register(user).then(resolve => {
            console.log(resolve)
                commit('registerSuccess', user);
                // display success message after route change completes
                dispatch('alert/success', 'Registration successful', {
                    root: true
                });
                // console.log("USER ID: " + userId)
                // api.sendEmail(userId)
                setTimeout(function() {router.push('/login')}, 1000) 
            },

            reject => {
                commit('registerFailure', reject);
                dispatch('alert/error', reject, {
                    root: true
                });
            }
        );
    },

    //student
    addStudentCourse( {commit, dispatch}, { course, id } ) {
        commit('addStudentCourseRequest', course)
        userService.addStudentCourse(course, id).then(response => {
            commit('addStudentCourseSuccess', course)
            console.log(response)
            console.log('in add student course success')
            dispatch('alert/success', 'Successfully added a new course to your pool!', { root: true })
        },
        
        reject => {
            console.log(reject);
            dispatch('alert/error', 'Failed to add a new course to your pool.', { root: true })
        })
    },

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
    },

    addStudentCourseRequest(state, course) {
        state.status.addingCourse = true;
        state.user.courses.push(course)
    },
    addStudentCourseSuccess(state, course) {
        state.status.addedCourse = true;
        state.user.courses.push(course)
    },
    addStudentCourseFailure(state) {
        state.status = {};
    },
};

export const account = {
    namespaced: true,
    state,
    actions,
    mutations
};
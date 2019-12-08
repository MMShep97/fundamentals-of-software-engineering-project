import { courseService } from '../_services/course.service';
import { router } from '../_helpers';
import { api } from '../_services/api.service';
import { sendEmail } from '../_services/utility.service'

const state = {

};

const actions = {
    createCourse({dispatch}, course) {
        courseService.createCourse(course).then(response => {
            console.log(response)
            console.log('in create course module success');
            dispatch('alert/success', 'Successfully created a new course!', { root: true })
        },
        
        reject => {
            console.log(reject);
            dispatch('alert/error', 'Failed to create a new course.', { root: true })
        })
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

export const courses = {
    namespaced: true,
    state,
    actions,
    mutations
};
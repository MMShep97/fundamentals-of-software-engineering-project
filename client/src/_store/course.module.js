import { courseService } from '../_services/course.service';
import { router } from '../_helpers';
import { api } from '../_services/api.service';
import { sendEmail } from '../_services/utility.service'

const state = {

};

const actions = {
    

    //instructor
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
    },

    deleteCourse({dispatch}, courseId) {
        courseService.deleteCourse(courseId).then(resolve => {
            console.log('in delete course success');
            dispatch('alert/success', `Successfully deleted the course: ${courseId}`)
        },
        reject => {
            console.log(reject);
            dispatch('alert/error', `Failed to delete course: ${courseId}`, { root: true })
        })
    }
};

const mutations = {
    
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
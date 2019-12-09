import { courseService } from '../_services/course.service';
import { router } from '../_helpers';
import { api } from '../_services/api.service';
import { sendEmail } from '../_services/utility.service'

api.course.getCourses().then(response => { localStorage.setItem('courses', JSON.stringify(response.data)) })

const allCourses = JSON.parse(localStorage.getItem('courses'));

const state = allCourses.length > 0 ? { status: {coursesAvailable: true }, allCourses } : { status: {coursesAvailable: false}, allCourses: [] }

console.log('all courses: ' + allCourses)

const actions = {
    //instructor
    createCourse({commit, dispatch}, course) {
        courseService.createCourse(course).then(response => {
            commit('addInstructorCourseSuccess', course)
            console.log(response)
            console.log('in create course module success');
            dispatch('alert/success', 'Successfully created a new course!', { root: true })
        },
        
        reject => {
            console.log(reject);
            dispatch('alert/error', 'Failed to create a new course.', { root: true })
        })
    },

    deleteCourse({commit, dispatch}, { course, courseId } ) {
        courseService.deleteCourse(courseId).then(resolve => {
            commit('deleteInstructorCourseSuccess', course)
            console.log(resolve)
            console.log('in delete course success');
            dispatch('alert/success', `Successfully deleted the course: ${courseId}`, { root: true})
        },
        reject => {
            console.log(reject);
            dispatch('alert/error', `Failed to delete course: ${courseId}`, { root: true })
        })
    }
};

const mutations = {
    addInstructorCourseSuccess(state, course) {
        state.allCourses.push(course)
        // let allCourses = state.allCourses;
        // localStorage.setItem('courses', JSON.stringify(allCourses))
    },

    deleteInstructorCourseSuccess(state, course) {
        state.allCourses.pop(course);
        // let allCourses = state.allCourses
        // localStorage.setItem('courses', JSON.stringify(allCourses))
        if (state.allCourses.length == 0) {
            state.status = {
                coursesAvailable: false,
            }
        }
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
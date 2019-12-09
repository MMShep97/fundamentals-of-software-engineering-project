import { courseService } from '../_services/course.service';
import { router } from '../_helpers';
import { api } from '../_services/api.service';
import { sendEmail } from '../_services/utility.service'


const state = { status: {coursesAvailable: false}, allCourses: [] }


const actions = {
    async getCourses({commit}) {
        let response = await api.course.getCourses();
        commit('getCoursesSuccess', response.data)
    },
    //instructor
    async createCourse({commit, dispatch}, course) {
        let response = await courseService.createCourse(course)

        if (response.status == 200) {
        const newCourse = await JSON.parse(JSON.stringify(course))
        commit('addInstructorCourseSuccess', newCourse)
        dispatch('alert/success', 'Successfully created a new course!', { root: true })
        }
        else {
            dispatch('alert/error', 'Failed to create a new course.', { root: true })
        }
    },

    async deleteCourse({commit, dispatch}, { course, courseId } ) {
        let response = await courseService.deleteCourse(courseId);
        if (response.status == 200) {
            const newCourse = await JSON.parse(JSON.stringify(course))
            commit('deleteInstructorCourseSuccess', newCourse)
            dispatch('alert/success', `Successfully deleted the course: ${courseId}`, { root: true})
        }
        else {
            dispatch('alert/error', `Failed to delete course: ${courseId}`, { root: true })
        }
    }
};

const mutations = {
    getCoursesSuccess(state, courses) {
        state.allCourses = courses;
        state.status.coursesAvailable = true;
        localStorage.setItem('courses', JSON.stringify(courses)) 
    },

    addInstructorCourseSuccess(state, newCourse) {
        state.allCourses.push(newCourse)
        // let allCourses = state.allCourses;
        // localStorage.setItem('courses', JSON.stringify(allCourses))
    },

    async deleteInstructorCourseSuccess(state, newCourse) {
        const courses = state.allCourses;
        const deleteIndex = await courses.findIndex(x => x.courseId == newCourse.courseId)
        console.log('delete index' + deleteIndex)
        console.log(JSON.parse(JSON.stringify(courses)))
        state.allCourses = courses.filter(function(course) { return course.courseId != newCourse.courseId})
        console.log(JSON.parse(JSON.stringify(state.allCourses)))

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
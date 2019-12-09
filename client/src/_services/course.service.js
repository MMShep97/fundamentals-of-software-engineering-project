import config from '../../vue.config';
import {
    authHeader
} from '../_helpers';
import {
    api
} from '../_services/api.service'

export const courseService = {
    createCourse,
    deleteCourse,
}



function createCourse(course) {
    return api.course.createCourse(course)
}

function deleteCourse(courseId) {
    return api.course.deleteCourse(courseId)
}
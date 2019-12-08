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



async function createCourse(course) {
    return await api.course.createCourse(course)
}

async function deleteCourse(courseId) {
    return await api.course.deleteCourse(courseId)
}
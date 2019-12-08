import config from '../../vue.config';
import {
    authHeader
} from '../_helpers';
import {
    api
} from '../_services/api.service'

export const courseService = {
    createCourse,
}

async function createCourse(course) {
    return await api.course.createCourse(course)
}
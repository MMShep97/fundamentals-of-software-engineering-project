import axios from 'axios'

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

const api = {
    user: { //(C)reate - POST
        createNewStudent: (user) =>
            instance.post('student/save', {
                user
            }),

        createNewInstructor: (user) =>
            instance.post('instructor/save', {
                user
            }),

        //(R)ead - GET
        getStudents: () => {
            return instance.get('student/getAll')
        },

        getStudentById: (id) => {
            return instance.get(`student/${id}`)
        },

        getInstructors: () => {
            return instance.get('instructor/getAll')
        },

        getInstructorById: (id) => {
            return instance.get(`instructor/${id}`)
        },

        // (U)pdate - PUT
        updateCourse: (id, text, completed) => instance.put('courses' + id, {
            title: text,
            completed: completed
        }),

        // (D)elete - DELETE
        deleteStudent: (user) => {
            instance.delete('student/delete/', {
                user
            })
        },

        deleteInstructor: (user) => {
            instance.delete('instructor/delete/', {
                user
            })
        }
    }
}

export {
    api
};
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
            return instance.get(`student/get/${id}`)
        },

        getInstructors: () => {
            return instance.get('instructor/getAll')
        },

        getInstructorById: (id) => {
            return instance.get(`instructor/get/${id}`)
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
    },

    course: {
        createCourse: (course) => {
            instance.post('course/save', { course })
        },
        
        getCourses: () => {
            instance.get('course/getcourse')
        },

        getCourseById: (id) => {
            instance.get(`course/get/${id}`)
        },

        updateCourseById: (course, id) => {
            instance.put(`course/course/${id}`, { course })
        },

        deleteCourseById: (id) => {
            instance.delete(`course/delete/${id}`)
        },

        // grades
        getGrades: () => {
            instance.get('grade/getAll')
        },

        getGradesById: (id) => {
            instance.get(`grade/get/${id}`)
        }, 

        createGrade: (grade) => {
            instance.post('grade/save', { grade })
        },

        deleteCourse: (id) => {
            instance.delete(`grade/delete/${id}`)
        },

        // quiz
        getQuizzes: () => {
            instance.get('quiz/getAll')
        },

        getQuizById: (id) => {
            instance.get(`quiz/get/${id}`)
        },

        createQuiz: (quiz) => {
            instance.post('quiz/save', { quiz })
        },

        deleteQuiz: (quiz) => {
            instance.delete('quiz/delete', { quiz })
        },



    }
}

export {
    api
};
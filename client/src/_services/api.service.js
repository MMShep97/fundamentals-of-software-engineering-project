import axios from 'axios'

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

//user
//{user}id
//username
//password
//firstName
//lastName
const api = {
    user: { //(C)reate - POST
        createNewStudent: (user) =>
            instance.post('/student/save', {
                studentId: user.email,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
            })
            .then(function (response) {
                console.log(response)
            })
            .catch(function (error) {
                console.log(error)
            }),

        createNewInstructor: (user) =>
        instance.post('/instructor/save', {
            instructorId: user.id,
            username: user.username,
            password: user.password,
            firstName: user.firstName,
            lastName: user.lastName
        })
        .then(function (response) {
            console.log(response)
        })
        .catch(function (error) {
            console.log(error)
        }),

        createNewAdministrator: (user) =>
        instance.post('/administrator/save', {
            administratorId: user.id,
            username: user.username,
            password: user.password,
            firstName: user.firstName,
            lastName: user.lastName
        })
        .then(function (response) {
            console.log(response)
        })
        .catch(function (error) {
            console.log(error)
        }),

        //(R)ead - GET
        getStudents: () => {
            return instance.get('student/getAll')
        },

        getStudentById: (id) => {
            return instance.get(`student/get/${id}`)
        },

        getStudentByUsername: (username) => {
            return instance.get(`student/get/${username}`)
        },

        getInstructors: () => {
            return instance.get('instructor/getAll')
        },

        getInstructorById: (id) => {
            return instance.get(`instructor/get/${id}`)
        },

        getInstructorByUsername: (username) => {
            return instance.get(`instructor/get/${username}`)
        },

        getAdministrators: () => {
            return instance.get('administrator/getAll')
        },

        getAdministratorById: (id) => {
            return instance.get(`administrator/get/${id}`)
        },

        getAdministratorByUsername: (username) => {
            return instance.get(`administrator/get/${username}`)
        },

        // (U)pdate - PUT
        updateCourse: (id, text, completed) => instance.put('courses' + id, {
            title: text,
            completed: completed
        }),

        updateStudent: (user) => {
            instance.put('student/update', {

            
            }
            )
        },

        updateInstructor: (user) => {
            instance.put('instructor/update', {

            }
            )
        },

        updateAdministrator: (user) => {
            instance.put('administrator/update', {

            }
            )
        },

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
        },

        deleteAdministrator: (user) => {
            instance.delete('administrator/delete', {
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
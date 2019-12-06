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
            return instance.get(`student/id/${id}`)
        },

        getStudentByUsername: async (username) => {
            return instance.get(`student/username/${username}`)
        },

        getInstructors: () => {
            return instance.get('instructor/getAll')
        },

        getInstructorById: (id) => {
            return instance.get(`instructor/id/${id}`)
        },

        getInstructorByUsername: (username) => {
            return instance.get(`instructor/username/${username}`)
        },

        getAdministrators: () => {
            return instance.get('administrator/getAll')
        },

        getAdministratorById: (id) => {
            return instance.get(`administrator/id/${id}`)
        },

        getAdministratorByUsername: (username) => {
            return instance.get(`administrator/username/${username}`)
        },

        // (U)pdate - PUT
        updateCourse: (id, text, completed) => instance.put('courses' + id, {
            courseId: course.id,
            courseName: course.name,
            instructor_id: course.instructorId,
            students: course.students,
            quiz: course.quizzes,
            grades: course.grades,
        }),

        updateStudent: (user) => {
            instance.put('student/update', {
                studentId: user.email,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
            })
        },

        updateInstructor: (user) => {
            instance.put('instructor/update', {
                instructorId: user.id,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
            })
        },

        updateAdministrator: (user) => {
            instance.put('administrator/update', {
                administratorId: user.id,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
            })
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
            instance.post('course/save', {
                courseId: course.id,
                courseName: course.name,
                instructor_id: course.instructorId,
                students: course.students,
                quiz: course.quizzes,
                grades: course.grades,
            })
        },

        getCourses: () => {
            instance.get('course/getcourse')
        },

        getCourseById: (id) => {
            instance.get(`course/get/${id}`)
        },

        updateCourseById: (course, id) => {
            instance.put(`course/course/${id}`, {
                courseId: course.id,
                courseName: course.name,
                instructor_id: course.instructorId,
                students: course.students,
                quiz: course.quizzes,
                grades: course.grades,
            })
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
            instance.post('grade/save', {
                quiz_id: grade.quizId,
                course_id: grade.courseId,
                instructor_id: grade.instructorId,
                student_id: grade.studentId,
                grade_points: grade.gradePoints,
            })
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
            instance.post('quiz/save', {
                quizId: quiz.id,
                quiz_name: quiz.name,
                quiz_point: quiz.points,
                quiz_date: quiz.date,
                course_id: quiz.courseId,
                
            })
        },

        deleteQuiz: (quiz) => {
            instance.delete('quiz/delete', {
                quiz
            })
        },



    }
}

export {
    api
};
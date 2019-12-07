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
        createNewStudent: async (user) =>
            instance.post('/student/save', {
                studentId: user.studentId,
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

        createNewInstructor: async (user) =>
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

        createNewAdministrator: async (user) =>
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
        getStudents: async () => {
            return instance.get('student/getAll').then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                    return error

                })
        },

        getStudentById: async (id) => {
            try {
                const response = await instance.get(`student/id/${id}`);
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getStudentByUsername: async (username) => {
            return instance.get(`student/username/${username}`)
                .then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        getInstructors: async () => {
            try {
                const response = await instance.get('instructor/getAll');
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getInstructorById: async (id) => {
            try {
                const response = await instance.get(`instructor/id/${id}`);
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getInstructorByUsername: async (username) => {
            try {
                const response = await instance.get(`instructor/username/${username}`);
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getAdministrators: async () => {
            try {
                const response = await instance.get('administrator/getAll');
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getAdministratorById: async (id) => {
            try {
                const response = await instance.get(`administrator/id/${id}`);
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        getAdministratorByUsername: async (username) => {
            try {
                const response = await instance.get(`administrator/username/${username}`);
                console.log(response);
                return response;
            }
            catch (error) {
                console.log(error);
            }
        },

        // (U)pdate - PUT
        updateCourse: async (id, text, completed) => instance.put('courses' + id, {
                courseId: course.id,
                courseName: course.name,
                instructor_id: course.instructorId,
                students: course.students,
                quiz: course.quizzes,
                grades: course.grades,
            }).then(function (response) {
                console.log(response)
                return response;

            })
            .catch(function (error) {
                console.log(error)
            }),

        updateStudent: async (user) => {
            instance.put('student/update', {
                    studentId: user.studentId,
                    username: user.username,
                    password: user.password,
                    firstName: user.firstName,
                    lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        updateInstructor: async (user) => {
            instance.put('instructor/update', {
                    instructorId: user.id,
                    username: user.username,
                    password: user.password,
                    firstName: user.firstName,
                    lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        updateAdministrator: async (user) => {
            instance.put('administrator/update', {
                    administratorId: user.id,
                    username: user.username,
                    password: user.password,
                    firstName: user.firstName,
                    lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        // (D)elete - DELETE
        deleteStudent: async (user) => {
            instance.delete('student/delete/', {
                studentId: user.studentId,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        deleteInstructor: async (user) => {
            instance.delete('instructor/delete/', {
                studentId: user.instructorId,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        deleteAdministrator: async (user) => {
            instance.delete('administrator/delete', {
                studentId: user.administratorId,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        }
    },

    course: {
        createCourse: async (course) => {
            instance.post('course/save', {
                    courseId: course.id,
                    courseName: course.name,
                    instructor_id: course.instructorId,
                    students: course.students,
                    quiz: course.quizzes,
                    grades: course.grades,
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        getCourses: async () => {
            instance.get('course/getcourse').then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        getCourseById: async (id) => {
            instance.get(`course/get/${id}`).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        updateCourseById: async (course, id) => {
            instance.put(`course/course/${id}`, {
                    courseId: id,
                    courseName: course.name,
                    instructor_id: course.instructorId,
                    students: course.students,
                    quiz: course.quizzes,
                    grades: course.grades,
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        deleteCourseById: async (id) => {
            instance.delete(`course/delete/${id}`).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        // grades
        getGrades: async () => {
            instance.get('grade/getAll').then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        getGradesById: async (id) => {
            instance.get(`grade/get/${id}`).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        createGrade: async (grade) => {
            instance.post('grade/save', {
                    quiz_id: grade.quizId,
                    course_id: grade.courseId,
                    instructor_id: grade.instructorId,
                    student_id: grade.studentId,
                    grade_points: grade.gradePoints,
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        deleteCourse: async (id) => {
            instance.delete(`grade/delete/${id}`).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        // quiz
        getQuizzes: async () => {
            instance.get('quiz/getAll').then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        getQuizById: async (id) => {
            instance.get(`quiz/get/${id}`).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        createQuiz: async (quiz) => {
            instance.post('quiz/save', {
                    quizId: quiz.id,
                    quiz_name: quiz.name,
                    quiz_point: quiz.points,
                    quiz_date: quiz.date,
                    course_id: quiz.courseId,

                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },

        deleteQuiz: async (quiz) => {
            instance.delete('quiz/delete', {
                    quiz
                }).then(function (response) {
                    console.log(response)
                    return response;

                })
                .catch(function (error) {
                    console.log(error)
                })
        },



    }
}

export {
    api
};
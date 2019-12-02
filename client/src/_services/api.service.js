import axios from 'axios'

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

const accountCalls = {
    //(C)reate - POST
    createNewAccount: (user) =>
        instance.post('account/save', {
            AccountID: user.accountId,
            Category: user.category,
            Username: user.username,
            Password: user.password
        }),
    createNewInstructor: (instructorId, firstName, lastName, accountId) =>
        instance.post('instructors', {
            InstructorID: instructorId,
            FirstName: firstName,
            LastName: lastName,
            AccountID: accountId
        }),
    createNewStudent: (studentId, firstName, lastName, accountId, courseId, quizId, certificateId) =>
        instance.post('students', {
            StudentID: studentId,
            FirstName: firstName,
            LastName: lastName,
            AccountID: accountId,
            CourseID: courseId,
            QuizID: quizId,
            CertificateID: certificateId
        }),
    createNewAdministrator: (adminId, firstName, lastName, accountId) =>
        instance.post('administrators', {
            AdminID: adminId,
            FirstName: firstName,
            LastName: lastName,
            AccountID: accountId
        }),

    //(R)ead - GET
    getUsers: () => instance.get('getAll', {
        transformResponse: [function (data) {
            return data ? JSON.parse(data)._embedded.todos : data;
        }]
    }),

    getAccounts: () => {
        return instance.get('account/getAll')
    },

    // (U)pdate - PUT
    updateCourse: (id, text, completed) => instance.put('courses' + id, {
        title: text,
        completed: completed
    }),

    // (D)elete - DELETE
    deleteCourse: (id) => instance.delete('courses/' + id),
    deleteQuiz: (id) => instance.delete('quizzes/' + id),
}

export {accountCalls};
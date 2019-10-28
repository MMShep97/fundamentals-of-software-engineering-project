import axios from 'axios'
import {
    account
} from '../_store/account.module';

const SERVER_URL = 'http://localhost:9000';

const instance = axios.create({
    baseURL: SERVER_URL,
    timeout: 1000
});

export default {
    //(C)reate - POST
    createNewAccount: (accountId, category, username, password) =>
        instance.post('accounts', {
            AccountID: accountId,
            Category: category,
            Username: username,
            Password: password
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

    // (U)pdate - PUT
    updateCourse: (id, text, completed) => instance.put('courses' + id, {
        title: text,
        completed: completed
    }),

    // (D)elete - DELETE
    deleteCourse: (id) => instance.delete('courses/' + id),
    deleteQuiz: (id) => instance.delete('quizzes/' + id),
}
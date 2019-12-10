import config from '../../vue.config';
import {
    authHeader
} from '../_helpers';
import {
    api
} from '../_services/api.service'

export const userService = {
    login,
    logout,
    register,
    addStudentCourse,
    deleteStudentCourse,
    viewAllUsers,
    getById,
    update,
    delete: _delete
};

async function login(username, password) {

    let user;
    let foundUser = false;
    let valid = false;

    await api.user.getStudentByUsername(username).then(resolve => {
            user = resolve.data;

            if (resolve.data == null) {
                return
            }
            user.category = 'Student'
            foundUser = true;
            console.log('nice')

        },
        reject => {
            valid = false;
        }).catch(error => console.log('caught error'))

    if (foundUser == false) {
        await api.user.getInstructorByUsername(username).then(resolve => {
                user = resolve.data;

                if (resolve.data == null) {
                    return
                }
                user.category = 'Instructor'
                foundUser = true;
                console.log('nice')

            },
            reject => {
                valid = false;
            }).catch(error => console.log('caught error'))
    }

    if (foundUser == false) {
        await api.user.getAdministratorByUsername(username).then(resolve => {
                user = resolve.data;

                if (resolve.data == null) {
                    return
                }
                user.category = 'Administrator'
                foundUser = true;
                console.log('nice')

            },
            reject => {
                valid = false;
            }).catch(error => console.log('caught error'))
    }

    if (foundUser == false) return {
        user: null,
        valid
    }
    else {
        user.password == password ? valid = true : valid = false
        if (valid == true) localStorage.setItem('user', JSON.stringify(user));
        return {
            user,
            valid
        };
    }
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

async function register(user) {
    console.log(user)
    let userType = user.category;
    console.log("userType: " + userType)
    if (userType == 'Student') {
        console.log("in register service student")
        return await api.user.createNewStudent(user)
    } else if (userType == 'Instructor') {
        console.log("in register service instructor")
        return await api.user.createNewInstructor(user)
    }
    else if (userType == 'Administrator') {
        console.log("in register service admin")
        return await api.user.createNewAdministrator(user)
    }
}

async function addStudentCourse(course, id) {
    let response = await api.user.getStudentById(id)
    if (response.status == 200) {
        const student = response.data
        student.courses.push(course);
        console.log(JSON.parse(JSON.stringify(student)))
        return api.user.updateStudent(student)
    } else {
        return Promise.reject();
    }

}

async function deleteStudentCourse(id, courseToDelete) {
    let response = await api.user.getStudentById(id)
    if (response.status == 200) {
        const student = response.data
        student.courses = student.courses.filter(function(course) { return course.courseId != courseToDelete.courseId})
        console.log(JSON.parse(JSON.stringify(student)))
        return api.user.updateStudent(student)
    } else {
        return Promise.reject();
    }
}

async function viewAllUsers() {
    const studentResponse = await api.user.getStudents();
    const students = studentResponse.data
    for (let i = 0; i < students.length; i++) {
        students[i].category = 'Student'
    }
    console.log(students)
    const instructorResponse = await api.user.getInstructors();
    const instructors = instructorResponse.data;
    for (let i = 0; i < instructors.length; i++) {
        instructors[i].category = 'Instructor'
    }
    console.log(instructors)

    const adminResponse = await api.user.getAdministrators();
    const administrators = adminResponse.data
    for (let i = 0; i < administrators.length; i++) {
        administrators[i].category = 'Administrator'
    }
    console.log(administrators)

    const users = await students.concat(instructors, administrators)
    return users
}

function getById(id) {
    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };

    return fetch(`${config.apiUrl}/users/${id}`, requestOptions).then(handleResponse);
}

function update(user) {
    const requestOptions = {
        method: 'PUT',
        headers: {
            ...authHeader(),
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    };

    return fetch(`${config.apiUrl}/users/${user.id}`, requestOptions).then(handleResponse);
}

// prefixed function name with underscore because delete is a reserved word in javascript
function _delete(id) {
    const requestOptions = {
        method: 'DELETE',
        headers: authHeader()
    };

    return fetch(`${config.apiUrl}/users/${id}`, requestOptions).then(handleResponse);
}

function handleResponse(response) {
    return response.data.then(text => {
        const data = text && JSON.parse(text);
        if (response.status == 401 || response.status == 500) {
            // auto logout if 401 response returned from api
            logout();
            location.reload(true);

            const error = response.status
            return Promise.reject(error);
        }
        return data;
    });
}

// function handleResponse(response) {
//     let responseStatus = response.status; 


//             if (responseStatus === 401) {
//                 // auto logout if 401 response returned from api
//                 logout();
//                 location.reload(true);
//                 return Promise.reject(error);
//             }
//             return data;
// }
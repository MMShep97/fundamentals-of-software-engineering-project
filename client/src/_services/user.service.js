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
    //let administrator = await api.user.getAdministratorByUsername(username)

    // else if (administrator != null) user = administrator.data;
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
    // else if (userType == 'Administrator') { api.user.createNewAdministrator(user) }
    // return fetch(`${config.apiUrl}/users/register`, requestOptions).then(handleResponse);
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
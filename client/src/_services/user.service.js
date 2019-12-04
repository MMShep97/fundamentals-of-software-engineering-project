import config from '../../vue.config';
import { authHeader } from '../_helpers';
import { api } from '../_services/api.service'

export const userService = {
    login,
    logout,
    register,
    getById,
    update,
    delete: _delete
};

async function login(username, password) {
        //get user object by the supplied username
        //check to see if the password supplied matches the user objects password

        let user;
        let outcome = false;
        
        let student = api.user.getStudentByUsername(username)
        let instructor = api.user.getInstructorByUsername(username)
        //let administrator = api.user.getAdministratorByUsername(username)

        if (student != null) user = student;
        if (instructor != null) user = instructor;
        // if (administrator != null) user = administrator;
        if (user == null) return outcome;

        user.password == password ? outcome = true: outcome = false
        if (outcome == true) {
            localStorage.setItem('user', JSON.stringify(user));
        }

        return outcome;
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

function register(user) {
    
    console.log(user)
    let userType = user.category;
    console.log("userType: " + userType)
    if (userType == 'Student') { return api.user.createNewStudent(user) }
    else if (userType == 'Instructor') { return api.user.createNewInstructor(user)}
    // else if (userType == 'Administrator') { api.user.createNewAdministrator(user) }
    // return fetch(`${config.apiUrl}/users/register`, requestOptions).then(handleResponse);
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
        headers: { ...authHeader(), 'Content-Type': 'application/json' },
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
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            if (response.status === 401) {
                // auto logout if 401 response returned from api
                logout();
                location.reload(true);
            }

            const error = (data && data.message) || response.statusText;
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
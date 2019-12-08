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
    getById,
    update,
    delete: _delete
};

async function login(username, password) {

        let user;
        let foundUser = false;
        let valid = false;

        await api.user.getStudentByUsername(username).then(resolve => {
            foundUser = true;
            console.log('nice')
            console.log(resolve)
            user = resolve.data;
            user.category = 'Student'
            
        }, 
        reject => {
            valid = false;
        })

        if (foundUser == false) {
        await api.user.getInstructorByUsername(username).then(resolve => {
            foundUser = true;
            console.log('nice')
            user = resolve.data;
            user.category = 'Instructor'
        },
        reject => {
            valid = false;
        })
    }
        //let administrator = await api.user.getAdministratorByUsername(username)

        // else if (administrator != null) user = administrator.data;
        if (foundUser == false) return { user: null, valid}
        else {
            user.password == password ? valid = true: valid = false
            if (valid == true) localStorage.setItem('user', JSON.stringify(user));
            return {user, valid};
    }
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

async function register(user) {
    let outcome = false;
    let userType = user.category;

    console.log(user)
    console.log("userType: " + userType)

    if (userType == 'Student') {
        await api.user.createNewStudent(user).then(
            resolve => {
                outcome = true;
            },

            reject => {
                console.log('failed to create new student')
            }
        )
    } else if (userType == 'Instructor') {
        await api.user.createNewInstructor(user).then( 
            resolve => {
                outcome = true;
            },

            reject => {
                console.log('failed to create new instructor')
            }
        )
    }
    // else if (userType == 'Administrator') { api.user.createNewAdministrator(user) }
    // return fetch(`${config.apiUrl}/users/register`, requestOptions).then(handleResponse);
    return outcome;
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
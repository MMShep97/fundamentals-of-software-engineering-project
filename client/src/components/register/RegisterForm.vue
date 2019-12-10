<template>
    <form @submit.prevent="handleSubmit">
        <b-form-group>
            <label htmlFor="category">Select from Student, Instructor, Administrator</label>
            <select v-model="user.category" v-validate="'required'" name="category" class="form-control"
                :class="{ 'is-invalid': submitted && errors.has('category') }">
                <option>Student</option>
                <option>Instructor</option>
                <option>Administrator</option>
            </select>
            <div v-if="submitted && errors.has('category')" class="invalid-feedback">
                {{ errors.first('category') }}</div>
        </b-form-group>
        <b-form-group>
            <label for="firstName">First Name</label>
            <input type="text" v-model="user.firstName" v-validate="'required'" name="firstName" class="form-control"
                :class="{ 'is-invalid': submitted && errors.has('firstName') }" />
            <div v-if="submitted && errors.has('firstName')" class="invalid-feedback">
                {{ errors.first('firstName') }}</div>
        </b-form-group>
        <b-form-group>
            <label for="lastName">Last Name</label>
            <input type="text" v-model="user.lastName" v-validate="'required'" name="lastName" class="form-control"
                :class="{ 'is-invalid': submitted && errors.has('lastName') }" />
            <div v-if="submitted && errors.has('lastName')" class="invalid-feedback">
                {{ errors.first('lastName') }}
            </div>
        </b-form-group>

        <b-form-group>
            <label for="email">Email (e.g. John.Smoth@gmail.com)</label>
            <input type="email" v-model="user.id" v-validate="'required|email'" name="email" class="form-control"
                :class="{ 'is-invalid': submitted && errors.has('email') }" />
            <div v-if="submitted && errors.has('email')" class="invalid-feedback">
                {{ errors.first('email') }}
            </div>
        </b-form-group>

        <b-form-group>
            <label for="username">Username</label>
            <input type="text" v-model="user.username" v-validate="'required'" name="username" class="form-control"
                :class="{ 'is-invalid': submitted && errors.has('username') }" />
            <div v-if="submitted && errors.has('username')" class="invalid-feedback">
                {{ errors.first('username') }}
            </div>
        </b-form-group>
        <b-form-group>
            <label htmlFor="password">Password</label>
            <input type="password" v-model="user.password" v-validate="{ required: true, min: 6 }" name="password"
                class="form-control" :class="{ 'is-invalid': submitted && errors.has('password') }" />
            <div v-if="submitted && errors.has('password')" class="invalid-feedback">
                {{ errors.first('password') }}
            </div>
        </b-form-group>
        <b-form-group>
            <button class="btn btn-primary" :disabled="status.registering">Register</button>
            <img v-show="status.registering" class="loading-icon"
                src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
            <router-link to="/login" class="btn btn-link">Cancel</router-link>
        </b-form-group>
    </form>
</template>

<script>
    import Validator from 'vee-validate'
    import {
        api
    } from '../../_services/api.service'
    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {

        data() {
            return {

                user: {
                    category: '',
                    id: '',
                    username: '',
                    password: '',
                    firstName: '',
                    lastName: '',
                    courses: [],
                    grades: [],
                    cost: 0,
                    currentCourseSelected: null,
                },
                submitted: false
            }
        },

        computed: {
            ...mapState('account', ['status']),
        },
        methods: {
            handleEmail() {
                
            },

            ...mapActions('account', ['register']),
            handleSubmit(e) {
                this.submitted = true;
                this.$validator.validate().then(valid => {
                    if (valid) {
                        let user = this.user;
                        let userId = this.user.id;
                        this.register( { user, userId} );
                    }
                });
            }
        }
    }
</script>

<style scoped>
    .loading-icon {
        padding-left: 15px;
    }

    .bootstrap-select .btn:focus {
        outline: blue !important;
        z-index: 1000 !important;
    }
</style>
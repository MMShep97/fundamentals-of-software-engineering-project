<template>
    <div>
        <b-container fluid>
            <b-row align-v="center" align-h="center">
                <b-col cols="4">
                    <h2>Register</h2>
                    <form @submit.prevent="handleSubmit">
                        <b-form-group>
                            <label htmlFor="userType">Select from Student, Instructor, Administrator</label>
                            <select v-model="user.userType" v-validate="'required'" name="userType" class="form-control"
                                :class="{ 'is-invalid': submitted && errors.has('userType') }">
                                <option>Student</option>
                                <option>Instructor</option>
                                <option>Administrator</option>
                            </select>
                            <div v-if="submitted && errors.has('userType')" class="invalid-feedback">
                                {{ errors.first('userType') }}</div>
                        </b-form-group>
                        <b-form-group>
                            <label for="firstName">First Name</label>
                            <input type="text" v-model="user.firstName" v-validate="'required'" name="firstName"
                                class="form-control" :class="{ 'is-invalid': submitted && errors.has('firstName') }" />
                            <div v-if="submitted && errors.has('firstName')" class="invalid-feedback">
                                {{ errors.first('firstName') }}</div>
                        </b-form-group>
                        <b-form-group>
                            <label for="lastName">Last Name</label>
                            <input type="text" v-model="user.lastName" v-validate="'required'" name="lastName"
                                class="form-control" :class="{ 'is-invalid': submitted && errors.has('lastName') }" />
                            <div v-if="submitted && errors.has('lastName')" class="invalid-feedback">
                                {{ errors.first('lastName') }}
                            </div>
                        </b-form-group>

                        <b-form-group>
                            <label for="username">Username</label>
                            <input type="text" v-model="user.username" v-validate="'required'" name="username"
                                class="form-control" :class="{ 'is-invalid': submitted && errors.has('username') }" />
                            <div v-if="submitted && errors.has('username')" class="invalid-feedback">
                                {{ errors.first('username') }}
                            </div>
                        </b-form-group>
                        <b-form-group>
                            <label htmlFor="password">Password</label>
                            <input type="password" v-model="user.password" v-validate="{ required: true, min: 6 }"
                                name="password" class="form-control"
                                :class="{ 'is-invalid': submitted && errors.has('password') }" />
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
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        data() {
            return {
                user: {
                    userType: '',
                    firstName: '',
                    lastName: '',
                    username: '',
                    password: '',
                    activeClasses: ['Math', 'Science', 'Chemistry', 'English'],
                },
                submitted: false
            }
        },
        computed: {
            ...mapState('account', ['status']),
        },
        methods: {
            ...mapActions('account', ['register']),
            handleSubmit(e) {
                this.submitted = true;
                this.$validator.validate().then(valid => {
                    if (valid) {
                        this.register(this.user);
                    }
                });
            }
        }
    };
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
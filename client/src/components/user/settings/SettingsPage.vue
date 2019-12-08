<template>
    <div class="base-container">
        <b-container>
            <b-row align-h="center">
                <b-col cols="12" sm="12" md="12" lg="12">
                    <h1 class="task-header">Settings</h1>
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <!-- Name change -->
                            <b-tab no-body>
                                <template v-slot:title>
                                    Name Change
                                </template>
                                <b-container>
                                    <b-row align-h="center">
                                        <b-col md="6">
                                            <form @submit.prevent="handleUpdateSubmit('firstName')">
                                                <b-form-group>
                                                    <label for="firstName">First Name</label>
                                                    <input type="text" v-model="account.user.firstName"
                                                        v-validate="''" name="firstName" class="form-control"
                                                        :class="{ 'is-invalid': submitted.firstName && errors.has('firstName'), 'is-valid': submitted.firstName && !errors.has('firstName') }" />
                                                    <div v-if="submitted.firstName && errors.has('firstName')"
                                                        class="invalid-feedback">
                                                        {{ errors.first('firstName') }}</div>
                                                </b-form-group>
                                                <b-form-group>
                                                    <button class="btn btn-primary">Submit</button>
                                                </b-form-group>
                                            </form>
                                        </b-col>
                                    </b-row>
                                    <b-row align-h="center">
                                        <b-col md="6">
                                            <b-form @submit.prevent="handleUpdateSubmit('lastName')">
                                                <b-form-group>
                                                    <label for="lastName">Last Name</label>
                                                    <input type="text" v-model="account.user.lastName"
                                                        v-validate="''" name="lastName" class="form-control"
                                                        :class="{ 'is-invalid': submitted.lastName && errors.has('lastName'), 'is-valid': submitted.lastName && !errors.has('lastName') }" />
                                                    <div v-if="submitted.lastName && errors.has('lastName')"
                                                        class="invalid-feedback">
                                                        {{ errors.first('lastName') }}</div>
                                                </b-form-group>
                                                <b-form-group>
                                                    <button class="btn btn-primary">Submit</button>
                                                </b-form-group>
                                            </b-form>
                                        </b-col>
                                    </b-row>
                                </b-container>

                            </b-tab>

                            <!-- Update Username -->
                            <b-tab no-body>
                                <template v-slot:title>
                                    Update Username
                                </template>
                                <b-container>
                                    <b-row align-h="center">
                                        <b-col md="6">
                                            <b-form @submit.prevent="handleUpdateSubmit('username')">
                                            <b-form-group>
                                                <label for="username">Update Username</label>
                                                <input type="text" v-model="account.user.username"
                                                    v-validate="''" name="firstName" class="form-control"
                                                    :class="{ 'is-invalid': submitted.username && errors.has('username'), 'is-valid': submitted.username && !errors.has('username') }" />
                                                <div v-if="submitted.username && errors.has('username')"
                                                    class="invalid-feedback">
                                                    {{ errors.first('username') }}</div>
                                            </b-form-group>
                                            <b-form-group>
                                                <button class="btn btn-primary">Submit</button>
                                            </b-form-group>
                                            </b-form>
                                        </b-col>
                                    </b-row>
                                </b-container>
                            </b-tab>

                            <!-- Update Password -->
                            <b-tab no-body>
                                <template v-slot:title>
                                    Update Password
                                </template>
                                <b-container>
                                    <b-row align-h="center">
                                        <b-col md="6">
                                            <b-form @submit.prevent="handleUpdateSubmit('password')">
                                                <b-form-group>
                                                    <label htmlFor="password">Password</label>
                                                    <input type="password" v-model="account.user.password"
                                                        v-validate="" name="password"
                                                        class="form-control"
                                                        :class="{ 'is-invalid': submitted.password && errors.has('password'), 'is-valid': submitted.password && !errors.has('password') }" />
                                                    <div v-if="submitted.password && errors.has('password')"
                                                        class="invalid-feedback">
                                                        {{ errors.first('password') }}
                                                    </div>
                                                </b-form-group>
                                                <b-form-group>
                                                    <button class="btn btn-primary">Submit</button>

                                                </b-form-group>
                                            </b-form>
                                        </b-col>
                                    </b-row>
                                </b-container>
                            </b-tab>

                            <!--Delete account -->
                            <b-tab no-body>
                                <template v-slot:title>
                                    Delete Your Account
                                </template>
                                <b-container>
                                    <b-row align-h="center">
                                        <b-col md="6">
                                            <b-form>

                                                <b-form-group>
                                                    <div><label for=""> This is a big decision.</label></div>
                                                    <div><label for=""> Are you sure you want to delete you
                                                            account?</label></div>
                                                </b-form-group>
                                                <b-form-group>
                                                    <button @click="handleDeleteAccountSubmit()" class="btn btn-danger">Delete Account</button>
                                                </b-form-group>
                                            </b-form>
                                        </b-col>
                                    </b-row>
                                </b-container>
                            </b-tab>
                        </b-tabs>
                    </b-card>
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
    import {
        api
    } from '../../../_services/api.service'
    export default {
        data() {
            return {

                submitted: {
                    firstName: false,
                    lastName: false,
                    username: false,
                    password: false,
                    deleteAccount: false,
                }
            }
        },
        computed: {
            ...mapState({
                account: state => state.account,
            }),

            created() {

            }


        },
        methods: {
            ...mapActions('account', ['logout']),
            handleUpdateSubmit(variableToUpdate) {
                this.submitted[variableToUpdate] = true
                this.$validator.validate().then(valid => {
                    if (valid) {
                        if (this.account.user.category == 'Student') {
                            api.user.updateStudent(this.account.user)
                            console.log('success')
                        } else if (this.account.user.category == 'Instructor') {
                            api.user.updateInstructor(this.account.user)
                            console.log('success')
                        } else if (this.account.user.category == 'Administrator') {
                            api.user.updateAdministrator(this.account.user)
                            console.log('success')
                        }
                        let user = JSON.parse(localStorage.getItem('user'));
                        user[variableToUpdate] = this.account.user[variableToUpdate]
                        localStorage.setItem('user', JSON.stringify(user));
                    }
                });
            },

            // handleUpdateLastnameSubmit(e) {
            //     this.submitted = true;
            //     this.$validator.validate().then(valid => {
            //         if (valid) {
            //             if (this.account.user.category == 'Student') {
            //                 api.user.updateStudent(this.account.user)
            //                 console.log('success')
            //             } else if (this.account.user.category == 'Instructor') {
            //                 api.user.updateInstructor(this.account.user)
            //             } else if (this.account.user.category == 'Administrator') {
            //                 api.user.updateAdministrator(this.account.user)
            //             }
            //         }
            //     });
            // },

            // handleUpdateUsernameSubmit(e) {
            //     this.submitted = true;
            //     this.$validator.validate().then(valid => {
            //         if (valid) {
            //             if (this.account.user.category == 'Student') {
            //                 api.user.updateStudent(this.account.user)
            //                 console.log('success')
            //             } else if (this.account.user.category == 'Instructor') {
            //                 api.user.updateInstructor(this.account.user)
            //             } else if (this.account.user.category == 'Administrator') {
            //                 api.user.updateAdministrator(this.account.user)
            //             }
            //         }
            //     });
            // },

            // handleUpdatePasswordSubmit(e) {
            //     this.submitted = true;
            //     this.$validator.validate().then(valid => {
            //         if (valid) {
            //             if (this.account.user.category == 'Student') {
            //                 api.user.updateStudent(this.account.user)
            //                 console.log('success')
            //             } else if (this.account.user.category == 'Instructor') {
            //                 api.user.updateInstructor(this.account.user)
            //             } else if (this.account.user.category == 'Administrator') {
            //                 api.user.updateAdministrator(this.account.user)
            //             }
            //         }
            //     });
            // },

            async handleDeleteAccountSubmit() {
                this.submitted.deleteAccount = true;
                        if (this.account.user.category == 'Student') {
                            await api.user.deleteStudent(this.account.user)
                        } else if (this.account.user.category == 'Instructor') {
                            await api.user.deleteInstructor(this.account.user)
                        } else if (this.account.user.category == 'Administrator') {
                            await api.user.deleteAdministrator(this.account.user)
                        }
                        // this.logout()
            },


        }
    }
</script>

<style scoped>
    .base-container {
        text-align: center;
    }
</style>
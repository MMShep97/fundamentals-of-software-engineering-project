<template>
    <div>
        <div v-if="!account.status.loggedIn">
            <b-container fluid>
                <b-row align-v="center">
                    <b-col>col 1</b-col>
                    <b-col cols="6">
                        <b-jumbotron header="Educadia"
                            lead="Paving the way for a transcendent customer-first focused approach to educational tutoring">
                            <b-button to="/register" variant="primary" href="#">Create your account today!</b-button>
                        </b-jumbotron>
                    </b-col>
                    <b-col>col 3</b-col>
                </b-row>
                <b-row align-v="center">
                    <b-col>col 4</b-col>
                    <b-col>col 5</b-col>
                    <b-col>col 6</b-col>
                </b-row>
            </b-container>
        </div>
        <div v-else-if="account.status.loggedIn">
            <div v-if="account.user.userType == 'Student'">
                <StudentWelcomePage></StudentWelcomePage>
            </div>
            <div v-else-if="account.user.userType == 'Instructor'">
                <InstructorWelcomePage></InstructorWelcomePage>
            </div>
            <div v-else-if="account.user.userType == 'Administrator'">
                <AdministratorWelcomePage></AdministratorWelcomePage>
            </div>
        </div>
    </div>
</template>

<script>
    import StudentWelcomePage from './student/StudentWelcomePage'
    import InstructorWelcomePage from './instructor/InstructorWelcomePage'
    import AdministratorWelcomePage from './administrator/AdministratorWelcomePage'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            StudentWelcomePage,
            InstructorWelcomePage,
            AdministratorWelcomePage,
        },

        computed: {
            ...mapState({
                account: state => state.account,
                users: state => state.users.all
            })
        },
        created() {
            this.getAllUsers();
        },
        methods: {
            ...mapActions('users', {
                getAllUsers: 'getAll',
                deleteUser: 'delete'
            })
        }
    };
</script>

<style scoped>
</style>
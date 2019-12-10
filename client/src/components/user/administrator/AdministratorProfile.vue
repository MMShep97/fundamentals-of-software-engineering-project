<template>
    <div class="admin-profile-container">
        <h1>Hi {{account.user.category}} {{account.user.firstName}}!</h1>
        <b-container fluid class="admin-profile-container">
            <b-row>
                <!-- Delete / View Users -->
                <b-col lg="7" md="12" sm="12">
                    <ViewAllUsers></ViewAllUsers>
                </b-col>
                <!-- Add Instructors -->
                <b-col lg="5" md="12" sm="12">
                    <h5 class="task-header">&plus; Add Users</h5>
                    <b-card class="card-style add-instructor-card">
                        <RegisterFormAdminAddsUser></RegisterFormAdminAddsUser>
                    </b-card>
                </b-col>
            </b-row>
        </b-container>
        <p>
            <router-link to="/login">Logout</router-link>
        </p>
    </div>
</template>

<script>
    import ViewAllUsers from './ViewAllUsers'
    import RegisterFormAdminAddsUser from '../../register/RegisterFormAdminAddsUser'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            ViewAllUsers,
            RegisterFormAdminAddsUser,
        },

        computed: {
            ...mapState({
                account: state => state.account,
            })
        },
        created() {
        },
        methods: {
        }
    };
</script>

<style scoped>
.admin-profile-container {
        text-align: center;
    }

    .card-style {
        background-color: ghostwhite;
    }

    .row {
    margin: 50px 0;
}

</style>
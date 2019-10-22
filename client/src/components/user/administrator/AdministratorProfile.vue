<template>
    <div class="admin-profile-container">
        <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
        <b-container class="admin-profile-container">
            <b-row>
                <!-- Delete / View Users -->
                <b-col sm="12" md="7">
                    <ViewAllUsers></ViewAllUsers>
                </b-col>
                <!-- Add Instructors -->
                <b-col sm="12" md="5">
                    <h5 class="task-header">Add Instructors</h5>
                    <b-card class="card-style add-instructor-card">
                        
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
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            ViewAllUsers,
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
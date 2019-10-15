<template>
    <div>
        <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
        <div v-if="account.user.userType == 'Student'">
            <StudentProfile></StudentProfile>
        </div>
        <div v-else-if="account.user.userType == 'Instructor'">
            <InstructorProfile></InstructorProfile>
        </div>
        <div v-else-if="account.user.userType == 'Administrator'">
            <AdministratorProfile></AdministratorProfile>
        </div>
    </div>
</template>

<script>
    import StudentProfile from './student/StudentProfile'
    import InstructorProfile from './instructor/InstructorProfile'
    import AdministratorProfile from './administrator/AdministratorProfile'

    import {
        mapState,
        mapActions
    } from 'vuex'


    export default {
        components: {
            StudentProfile,
            InstructorProfile,
            AdministratorProfile,
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
    }
</script>

<style scoped>

</style>
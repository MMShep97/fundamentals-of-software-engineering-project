<template>
    <div>
        <div v-if="account.user.category == 'Student'">
            <StudentProfile></StudentProfile>
        </div>
        <div v-else-if="account.user.category == 'Instructor'">
            <InstructorProfile></InstructorProfile>
        </div>
        <div v-else-if="account.user.category == 'Administrator'">
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
            })
        },
        created() {
        },
        methods: {
        }
    }
</script>

<style scoped>

</style>
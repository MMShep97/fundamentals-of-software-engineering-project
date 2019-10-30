<template>
    <div class="student-profile-container">
        <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
        <b-container fluid>
            <b-row align-h="center" class="row-margin">
                <b-col md="4" class="select-course-col">
                    <h4>Select from your current classes:</h4>
                    <b-form-select v-model="currentCourseSelected.title" :options="courseList.activeCourses"
                        class="mb-3" value-field="title" text-field="title" disabled-field="notEnabled"></b-form-select>
                </b-col>
            </b-row>
            <b-row v-show="currentCourseSelected.title">
                <b-col sm="12" md="4" class="my-courses-col">
                    <h5 class="task-header">My Courses</h5>
                    <BaseMyCoursesCard />
                </b-col>
                <b-col sm="12" md="8" class="current-course-col">
                    <h5 class="task-header">Currently Selected Course</h5>
                    <BaseCurrentCourseCard />
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import BaseCurrentCourseCard from './current-course/BaseCurrentCourseCard'
    import BaseMyCoursesCard from './my-courses/BaseMyCoursesCard'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            BaseCurrentCourseCard,
            BaseMyCoursesCard,
        },
        data() {
            return {
                currentCourseSelected: {
                    title: '',
                },
                courseList: {
                    activeCourses: [{
                            id: 1,
                            title: 'English',
                            text: 'Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry  richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.'
                        },
                        {
                            id: 2,
                            title: 'Math',
                            text: 'Animdfpariatur cliche reprehenderit, enim eiusmod high life accusamus terry  richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.'
                        }
                    ],
                    pastCourses: {
                        math: {
                            title: 'Math',
                            text: 'noice.'
                        }
                    },
                }
            }
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
        },
    }
</script>

<style scoped>
    .student-profile-container {
        text-align: center;
    }

    .my-courses-col,
    .current-course-col,
    .select-course-col {
        margin: 20px 0;
    }

    
</style>
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
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="View Courses">
                                <b-card-text>
                                    <b-col v-for="course in courseList.activeCourses" :key="course.id">
                                        {{course.title}}
                                    </b-col>
                                    <router-link to="/user-profile/add-student-course"> Add Courses</router-link>
                                    <router-view></router-view>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body>
                                <template v-slot:title>
                                    &plus; Add Course
                                </template>
                            </b-tab>
                            <b-tab no-body>
                                <template v-slot:title>
                                    &minus; Delete Course
                                </template>
                                <b-row v-for="course in courseList.activeCourses" :key="course.id" align-v="center"
                                        align-h="center">

                                        <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href='#' variant="dark">
                                                    {{course.title}}
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                        <b-col xl="4" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href="#" class="text-danger" variant="danger">
                                                    Delete
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                    </b-row>
                            </b-tab>
                        </b-tabs>
                    </b-card>
                </b-col>
                <b-col sm="12" md="8" class="current-course-col">
                    <h5 class="task-header">Currently Selected Course</h5>
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="Home">
                                <b-card-text>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                    Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry
                                    richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor
                                    brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt
                                    aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Announcements">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="Assignments">
                                <b-card-text>
                                    <TakeExam></TakeExam>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Grades">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="People">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="Modules">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="Feedback">
                                <b-card-text></b-card-text>
                            </b-tab>
                        </b-tabs>

                    </b-card>
                </b-col>
            </b-row>
            <!-- <b-row>
                <b-col sm="12" md="6">
                    <b-card>

                    </b-card>
                </b-col>

                <b-col sm="12" md="6">
                    <b-card>

                    </b-card>
                </b-col>
            </b-row> -->
        </b-container>
        <!-- <Accordian>
        <template v-slot:title>{{courseList.activeCourses.english.title}}</template>
        <template v-slot:text>{{courseList.activeCourses.english.text}}</template>
    </Accordian>
    <Accordian>
        <template v-slot:title>{{courseList.pastCourses.math.title}}</template>
        <template v-slot:text>{{courseList.pastCourses.math.text}}</template>
    </Accordian> -->
    </div>
</template>

<script>
    import Accordian from '../../utility/Accordian'
    import TakeExam from './TakeExam'
    import AddStudentCourse from './AddStudentCourse'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            Accordian,
            TakeExam,
            AddStudentCourse,
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

    .my-courses-col, .current-course-col, .select-course-col {
        margin: 20px 0;
    }

    .tab-content > .active {
    display: block;
    padding: 10px 10px;
}

.row {
    padding: 5px 0;
}
</style>
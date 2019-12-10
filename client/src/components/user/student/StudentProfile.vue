<template>
    <div class="student-profile-container">
        <h1>Hi {{account.user.category}} {{account.user.firstName}}!</h1>
        <b-container fluid>
            <b-row align-h="center" class="row-margin">
                <b-col md="4" class="select-course-col">
                    <h4>Select from your current classes:</h4>
                    <b-form-select v-model="account.user.courses.currentCourseSelected" :options="account.user.courses"
                        class="mb-3" text-field="courseName" disabled-field="notEnabled"></b-form-select>
                    <b-button :pressed.sync="addCourseButtonToggle" size="sm" variant="info" class="btn">
                        <div class="text-center mt-0">Or add courses...</div>
                    </b-button>
                    <div v-show="addCourseButtonToggle">
                        <b-form-group>
                            <b-form-select v-model="selectedCourseToAdd" :options="addCourseOptions" class="mt-3">
                            </b-form-select>
                            <div v-show="selectedCourseToAdd">
                                <b-button @click="updateStudentsCurrentCoursePool(selectedCourseToAdd)"
                                class="btn mt-3" size="sm" variant="primary">Add Course
                                </b-button>
                            </div>

                        </b-form-group>
                    </div>

                </b-col>
            </b-row>
            <b-row v-show="account.user.courses.curentCourseSelected">
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

    import {
        api
    } from '../../../_services/api.service'

    export default {
        components: {
            BaseCurrentCourseCard,
            BaseMyCoursesCard,
        },
        data() {
            return {
                addCourseButtonToggle: false,
                allAvailableCourses: [],
                selectedCourseToAdd: '',

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
                courses: state => state.courses
            }),

            addCourseOptions: function () {
                let options = [];
            console.log(this.courses.allCourses.length)
            for (let i = 0; i < this.courses.allCourses.length; i++) {
                options.push({
                    value: this.courses.allCourses[i],
                    text: this.courses.allCourses[i].courseName
                })
            }
            console.log(options)
            return options;
            }
        },

        created() {
        },

        mounted() {
            
    },

    methods: {
        ...mapActions('account', ['addStudentCourse']),
        
        
        updateStudentsCurrentCoursePool: function(course) {
            let id = this.account.user.studentId;
            this.addStudentCourse( {course, id } )
        }
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
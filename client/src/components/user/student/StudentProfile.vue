<template>
    <div class="student-profile-container">
        <h1>Hi {{account.user.category}} {{account.user.firstName}}!</h1>
        <b-container fluid>
            <b-row align-h="center" class="row-margin">
                <b-col md="4" class="select-course-col">
                    <h4>Select from your current classes:</h4>
                    <b-form-select v-model="account.user.currentCourseSelected" :options="currentCourseOptions"
                        class="mb-3" placeholder="Add courses below"></b-form-select>
                    <div>
                    <b-button :pressed.sync="addCourseButtonToggle" size="sm" variant="info" class="btn">
                        <div class="text-center mt-0">Or add courses...</div>
                    </b-button>
                    <div v-show="addCourseButtonToggle">
                        <b-form-group>
                            <b-form-select v-model="selectedCourseToAdd" :options="addCourseOptions" class="mt-3"
                                disabled-field="disabled">
                            </b-form-select>
                            <div v-show="selectedCourseToAdd">
                                <b-button @click="updateStudentsCurrentCoursePool(selectedCourseToAdd)" class="btn mt-3"
                                    size="sm" variant="primary">Add Course
                                </b-button>
                            </div>

                        </b-form-group>
                    </div>
                    </div>

                </b-col>
            </b-row>
            <b-row v-show="account.user.curentCourseSelected =! null">
                <b-col sm="12" md="4" class="my-courses-col">
                    <h5 class="task-header">My Courses</h5>
                    <BaseMyCoursesCard />
                </b-col>
                <b-col sm="12" md="8" class="current-course-col">
                    <h5 class="task-header">Currently Selected Course | {{currentCourseName}}</h5>
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
            }
        },

        computed: {
            ...mapState({
                account: state => state.account,
                courses: state => state.courses
            }),
            
            currentCourseName: function() {
                if (this.account.user.currentCourseSelected != null) {
                    return this.account.user.currentCourseSelected.courseName
                }
            },

            currentCourseOptions: function () {
                let options = []
                for (let i = 0; i < this.account.user.courses.length; i++) {
                    options.push({
                        value: this.account.user.courses[i],
                        text: this.account.user.courses[i].courseName,
                    })

                    }
                    console.log('current course options')
                    JSON.parse(JSON.stringify(options))
                    return options;
                },

                addCourseOptions: function () {
                    let options = [];
                    let disabled = false;
                    console.log(this.courses.allCourses.length)
                    for (let i = 0; i < this.courses.allCourses.length; i++) {
                        disabled = false;
                        for (let j = 0; j < this.account.user.courses.length; j++) {
                            if (this.courses.allCourses[i].courseId == this.account.user.courses[j].courseId) {
                                disabled = true;
                            }

                        }
                        options.push({
                            value: this.courses.allCourses[i],
                            text: this.courses.allCourses[i].courseName,
                            disabled: disabled,
                        })
                    }
                    console.log('add course options')
                    console.log(options)
                    return options;
                }
            },

            created() {},

            mounted() {

            },

            methods: {
                ...mapActions('account', ['addStudentCourse']),


                updateStudentsCurrentCoursePool: function (course) {
                    let id = this.account.user.studentId;
                    this.addStudentCourse({
                        course,
                        id
                    })
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
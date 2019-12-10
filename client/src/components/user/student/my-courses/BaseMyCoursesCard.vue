<template>
    <b-card no-body>
        <b-tabs content-class="mt-1" card pills justified align="center">
            <b-tab no-body title="View Courses">
                <b-card-text>
                    <b-col v-for="course in account.user.courses" :key="course.studentId">
                        {{course.courseName}}
                    </b-col>
                </b-card-text>
            </b-tab>
            <b-tab disabled no-body>
                <template v-slot:title>
                    &plus; Add Course
                </template>
                <AddStudentCourse />
            </b-tab>
            <b-tab no-body>
                <template v-slot:title>
                    &minus; Delete Course
                </template>
                <b-row v-for="course in account.user.courses" :key="course.courseId" align-v="center" align-h="center">

                    <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                        <b-list-group>
                            <b-list-group-item disabled href='#' variant="dark">
                                {{course.courseId}} - {{course.courseName}}
                            </b-list-group-item>
                        </b-list-group>
                    </b-col>
                    <b-col xl="4" lg="6" md="6" sm="6" cols="6">
                        <b-list-group>
                            <b-list-group-item @click="deleteStudentSubject(course)" href="#" class="text-danger" variant="danger">
                                Delete
                            </b-list-group-item>
                        </b-list-group>
                    </b-col>
                </b-row>
            </b-tab>
        </b-tabs>
    </b-card>
</template>

<script>
    import AddStudentCourse from './AddStudentCourse'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            AddStudentCourse
        },

        data () {
            return {
                currentCourseSelected: {
                    title: '',
                },
            }
        },
computed: {
            ...mapState({
                account: state => state.account,
            }),

            
        },

        methods: {
            ...mapActions('account', ['deleteStudentCourse']),
            deleteStudentSubject( course ) {
                const studentId = this.account.user.studentId
                console.log('student id in my courses' + studentId)
                this.deleteStudentCourse( {course, studentId } )
            },
        }

        

    }
</script>

<style scoped>

</style>
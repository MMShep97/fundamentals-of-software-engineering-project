<template>
    <b-card no-body>
        <b-tabs content-class="mt-1" card pills justified align="center">
            <b-tab no-body title="View Courses">
                <b-card-text>
                    <b-col v-for="course in courseList.activeCourses" :key="course.id">
                        {{course.title}}
                    </b-col>
                </b-card-text>
            </b-tab>
            <b-tab no-body>
                <template v-slot:title>
                    &plus; Add Course
                </template>
                <AddStudentCourse />
            </b-tab>
            <b-tab no-body>
                <template v-slot:title>
                    &minus; Delete Course
                </template>
                <b-row v-for="course in courseList.activeCourses" :key="course.id" align-v="center" align-h="center">

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


    }
</script>

<style scoped>

</style>
<template>
                    <b-card no-body>
                        <b-tabs
                             content-class="" card pills justified align="center">
                            <b-tab no-body title="Home">
                                <div>
                                    {{currentCourseSelectedDescription}}
                                </div>
                            </b-tab>
                            <b-tab disabled no-body title="Announcements">
                                <b-card-text>
                                    <div v-for="announcement in announcements" :key="announcement.id">
                                        <p>{{announcement}}</p>
                                    </div>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Assignments">
                                <b-card-text>
                                    No assignments available...
                                    <TakeExam />
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Grades">
                                <b-card-text>No grades available...</b-card-text>
                            </b-tab>
                            <b-tab no-body title="People">
                                <b-card-text>
                                    <div class="text-center">People Enlisted</div>
                                    <hr />
                                    <ul>
                                        <li class="text-left" v-for="student in currentCourseSelectedStudents" :key="student.studentId">
                                            {{student.firstName}} {{student.lastName}}
                                        </li>
                                    </ul>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Modules">
                                <b-card-text>No modules available...</b-card-text>
                            </b-tab>
                            <b-tab disabled no-body title="Feedback">
                                <b-card-text></b-card-text>
                            </b-tab>
                        </b-tabs>

                    </b-card>
</template>

<script>
import TakeExam from './TakeExam'
 import {
        mapState,
        mapActions
    } from 'vuex'
export default {
    components: {
        TakeExam,
    },

    data () {
        return {
            course: ['boop'],
            announcements: ['boop']
        }
    },

    computed: {
        ...mapState({
            account: state => state.account,
        }),

         currentCourseSelectedDescription: function() {
                if (this.account.currentCourseSelected != null) {
                    return this.account.currentCourseSelected.courseDescription
                }
            },

            currentCourseSelectedStudents: function() {
                if (this.account.currentCourseSelected != null) {
                    return this.account.currentCourseSelected.students
                }
                else return []
            }
    }
}
</script>

<style scoped>

</style>
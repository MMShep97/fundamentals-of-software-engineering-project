<template>
    <div class="student-profile-container">



        <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
        <b-container>
            <b-row>
                <b-col sm="12" md="4">
                    <b-card title="My Courses">
                        <b-col>Science</b-col>
                        <b-col>English</b-col>
                        <b-col>Math</b-col>
                        <router-link to="/">&#43; Add Courses</router-link>
                    </b-card>
                </b-col>
                <b-col sm="12" md="8">
                    <b-card title="Currently Selected Course">
                        <b-tabs pills vertical end>
                            <b-tab title="View Grades">1</b-tab>
                            <b-tab title="Take Exams">2</b-tab>
                            <b-tab title="3">
                            </b-tab>
                        </b-tabs>
                    </b-card>
                </b-col>
            </b-row>
            <b-row>
                <b-col sm="12" md="6">
                    <b-card>

                    </b-card>
                </b-col>

                <b-col sm="12" md="6">
                    <b-card>

                    </b-card>
                </b-col>
            </b-row>
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
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            Accordian,
        },
        data() {
            return {
                courseList: {
                    activeCourses: {
                        english: {
                            title: 'English',
                            text: 'Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry  richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.'
                        }
                    },
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

    .row {
        margin: 50px 0;
    }
</style>
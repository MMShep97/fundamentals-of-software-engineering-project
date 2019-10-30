<template>
    <div class="instructor-profile-container">
        <b-container fluid>
            <b-row align-h="center" align-v="start" class="row-margin">
                <b-col>
                    <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
                </b-col>
            </b-row>
            <b-row align-h="center" align-v="start" class="row-margin">
                <b-col md="4">
                    <h4>Select from your current classes:</h4>
                    <b-form-select v-model="currentCourseSelected.name" :options="currentCourseOptions" class="mb-3"
                        value-field="class" text-field="name" disabled-field="notEnabled"></b-form-select>
                </b-col>
            </b-row>
            <b-row v-show="currentCourseSelected.name">
                <b-col lg="5" md="12" sm="12">
                    <h5 class="task-header">Subjects</h5>
                    <BaseSubjectsCard />
                </b-col>
                <b-col lg="7" md="12" sm="12">
                    <h5 class="task-header">
                        Current Course |  
                        <span v-show="currentCourseSelected.name">{{currentCourseSelected.name}}</span>
                    </h5>
                    <BaseCurrentCourseCard />
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import BaseSubjectsCard from './subject/BaseSubjectsCard'
    import BaseCurrentCourseCard from './current-course/BaseCurrentCourseCard'
    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {
        components: {
            BaseSubjectsCard,
            BaseCurrentCourseCard,
        },

        data() {
            return {
                submitted: false,

                createCourse: {
                    courseName: '',
                    courseDescription: '',
                    courseFiles: [

                    ],
                },

                currentCourseSelected: {
                    id: 1,
                    class: '',
                    name: '',

                },
                currentCourseOptions: [{
                        id: 1,
                        class: 'math',
                        name: 'Math'
                    },
                    {
                        id: 2,
                        class: 'science',
                        name: 'Science'
                    },
                    {
                        id: 3,
                        class: 'english',
                        name: 'English'
                    },

                    {
                        id: 4,
                        class: 'calculus',
                        name: 'Calculus'
                    },

                    {
                        id: 5,
                        class: 'physics',
                        name: 'Physics'
                    },
                ],

                
                }
            },

            computed: {
                    ...mapState({
                        account: state => state.account,
                        users: state => state.users.all,
                    })
                },

                created() {
                    this.getAllUsers();
                },

                methods: {
                    ...mapActions('users', {
                        getAllUsers: 'getAll',
                        deleteUser: 'delete'
                    }),

                    formatNames(files) {
                        if (files.length === 1) {
                            return files[0].name
                        } else {
                            return `${files.length} files selected`
                        }
                    }
                }

        }
</script>

<style scoped>
    .instructor-profile-container {
        text-align: center;
    }


    .header {
        font-weight: bold;
    }

    .card-style {
        background-color: ghostwhite;
    }

    .row {
        margin: 50px 0;
    }

    .row-margin {
        margin-top: -30px !important;
    }
</style>
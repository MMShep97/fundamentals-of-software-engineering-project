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
            <b-row v-if="currentCourseSelected.name">
                <b-col lg="4" md="12" sm="12">
                    <h5 class="task-header">Subjects</h5>
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body>
                                <template v-slot:title>
                                    &plus; Add Subject
                                </template>
                                <b-row>
                                    <b-col>
                                        <form>
                                            <b-form-group>
                                                <label htmlFor="createCourse.courseName">Course Name:</label>
                                                <input type="text" v-model="createCourse.courseName"
                                                    name="createCourse.courseName" class="form-control"
                                                    :class="{ 'is-invalid': submitted && errors.has('lastName') }" />
                                                <div v-if="submitted && errors.has('createCourse.courseName')"
                                                    class="invalid-feedback">
                                                    {{ errors.first('createCourse.courseName') }}</div>
                                            </b-form-group>
                                            <b-form-group>
                                                <label htmlFor="createCourse.courseDescription">Course
                                                    Description:</label>
                                                <input type="text" v-model="createCourse.courseDescription"
                                                    name="createCourse.courseDescription" class="form-control"
                                                    :class="{ 'is-invalid': errors.has('createCourse.courseDescription') }" />
                                                <div v-if="submitted && errors.has('createCourse.courseDescription')"
                                                    class="invalid-feedback">
                                                    {{ errors.first('createCourse.courseDescription') }}</div>
                                            </b-form-group>
                                            <b-form-group>
                                                <label>Course Files:</label>
                                                <b-form-file multiple v-model="createCourse.courseFiles"
                                                    :file-name-formatter="formatNames" drop-placeholder="Drop file here"
                                                    class="form-control"
                                                    :class="{ 'is-invalid': errors.has('createdCourseDescription') }">
                                                </b-form-file>
                                                <div v-if="submitted && errors.has('createdCourseDescription')"
                                                    class="invalid-feedback">
                                                    {{ errors.first('createdCourseDescription') }}</div>
                                            </b-form-group>
                                            <b-button>Submit</b-button>
                                        </form>
                                    </b-col>
                                </b-row>
                            </b-tab>
                            <b-tab no-body>
                                <template v-slot:title>
                                    &minus; Delete Subject
                                </template>
                                <b-card-text>
                                    <b-row v-for="course in currentCourseOptions" :key="course.id" align-v="center"
                                        align-h="center">

                                        <b-col xl="9" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href='#' variant="dark">
                                                    {{course.name}}
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                        <b-col xl="3" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href="#" class="text-danger" variant="danger">
                                                    Delete
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                    </b-row>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Deprecate Subject">
                                <b-card-text>
                                    <b-row v-for="course in currentCourseOptions" :key="course.id" align-v="center">

                                        <b-col xl="9" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href='#' variant="dark">
                                                    {{course.name}}
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                        <b-col xl="3" lg="6" md="6" sm="6" cols="6">
                                            <b-list-group>
                                                <b-list-group-item href="#" class="text-warning" variant="warning">
                                                    Deprecate
                                                </b-list-group-item>
                                            </b-list-group>
                                        </b-col>
                                    </b-row>
                                </b-card-text>
                            </b-tab>
                        </b-tabs>

                    </b-card>

                </b-col>
                <b-col lg="8" md="12" sm="12">
                    <h5 class="task-header">Current Course</h5>
                    <b-card no-body class="card-style grades-card">
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="Assign Grades">
                                <b-card-text>
                                    <div class="">Viewing Content for <strong>{{ currentCourseSelected.name }}</strong>
                                    </div>

                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Update Grades">2</b-tab>
                            <b-tab no-body title="Publish Grades">
                            </b-tab>
                            <b-tab no-body>
                                <template v-slot:title>
                                    &plus; Create Exam
                                </template>
                                <b-row>
                                    <b-col>
                                        <b-card-text>
                                            <b-form>
                                                <b-form-group>
                                                    <h2>Questions</h2>
                                                    <div>{{question}}</div>
                                                    <label for="option1"><input name="answers" type="radio"
                                                            :val="option1">
                                                        {{option1}}</label>
                                                    <label for="option2"><input name="answers" type="radio"
                                                            :val="option2">
                                                        {{option2}}</label>
                                                    <hr>
                                                    <h2>Create your multiple-choice question here</h2>
                                                    <label for="question">Type your question</label>
                                                    <b-form-textarea v-model="question" id="question" cols="30"
                                                        rows="3"></b-form-textarea>
                                                    <label for="option1">Option 1</label>
                                                    <input type="text" v-model="option1">
                                                    <label for="option2">Option 2</label>
                                                    <input type="text" v-model="option2">
                                                </b-form-group>
                                            </b-form>
                                        </b-card-text>
                                    </b-col>
                                </b-row>
                            </b-tab>
                        </b-tabs>
                    </b-card>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {
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

    ul {
        padding: 0;
        list-style-type: none;
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
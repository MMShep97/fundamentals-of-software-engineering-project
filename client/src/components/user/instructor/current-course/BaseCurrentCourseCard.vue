<template>
    <b-card no-body class="card-style grades-card">
        <b-tabs content-class="mt-1" card pills justified align="center">
            <b-tab no-body title="Assign Grades">
                <b-card-text>
                    <div class="">
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
                                    <!-- <div>{{question}}</div>
                                    <label for="option1"><input name="answers" type="radio" :val="option1">
                                        {{option1}}</label>
                                    <label for="option2"><input name="answers" type="radio" :val="option2">
                                        {{option2}}</label>
                                    <hr>
                                    <h2>Create your multiple-choice question here</h2>
                                    <label for="question">Type your question</label>
                                    <b-form-textarea v-model="question" id="question" cols="30" rows="3">
                                    </b-form-textarea>
                                    <label for="option1">Option 1</label>
                                    <input type="text" v-model="option1">
                                    <label for="option2">Option 2</label>
                                    <input type="text" v-model="option2"> -->
                                </b-form-group>
                            </b-form>
                        </b-card-text>
                    </b-col>
                </b-row>
            </b-tab>
        </b-tabs>
    </b-card>
</template>

<script>
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
    }
</script>

<style scoped>

</style>
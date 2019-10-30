<template>
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
                                <input type="text" v-model="createCourse.courseName" name="createCourse.courseName"
                                    class="form-control"
                                    :class="{ 'is-invalid': submitted && errors.has('lastName') }" />
                                <div v-if="submitted && errors.has('createCourse.courseName')" class="invalid-feedback">
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
                    <b-row v-for="course in currentCourseOptions" :key="course.id" align-v="center" align-h="center">

                        <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                            <b-list-group>
                                <b-list-group-item href='#' variant="dark">
                                    {{course.name}}
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
                </b-card-text>
            </b-tab>
            <b-tab no-body title="Deprecate Subject">
                <b-card-text>
                    <b-row v-for="course in currentCourseOptions" :key="course.id" align-v="center">

                        <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                            <b-list-group>
                                <b-list-group-item href='#' variant="dark">
                                    {{course.name}}
                                </b-list-group-item>
                            </b-list-group>
                        </b-col>
                        <b-col xl="4" lg="6" md="6" sm="6" cols="6">
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
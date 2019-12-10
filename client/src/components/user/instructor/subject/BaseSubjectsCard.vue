<template>
    <b-card no-body>
        <b-tabs content-class="mt-1" card pills justified align="center">
            <b-tab no-body>
                <template v-slot:title>
                    &plus; Add Subject
                </template>
                <b-row>
                    <b-col>
                        <b-form @submit.prevent="handleAddInstructorSubject">
                            <b-form-group>
                                <label htmlFor="courseId">Course ID:</label>
                                <input v-validate="'required'" type="text" v-model="newCourse.courseId" name="courseId"
                                    placeholder="e.g. CS:1200" class="form-control"
                                    :class="{ 'is-invalid': errors.has('courseId') }" />
                                <div v-if="submitted && errors.has('courseId')" class="invalid-feedback">
                                    {{ errors.first('courseId') }}</div>
                            </b-form-group>
                            <b-form-group>
                                <label htmlFor="newCourse.courseName">Course Name:</label>
                                <input v-validate="'required'" type="text" v-model="newCourse.courseName" name="newCourse.courseName"
                                    class="form-control"
                                    :class="{ 'is-invalid': submitted && errors.has('lastName') }" />
                                <div v-if="submitted && errors.has('newCourse.courseName')" class="invalid-feedback">
                                    {{ errors.first('newCourse.courseName') }}</div>
                            </b-form-group>
                            <b-form-group>
                                <label htmlFor="newCourse.courseDescription">Course
                                    Description:</label>
                                <input type="text" v-model="newCourse.courseDescription"
                                    name="newCourse.courseDescription" class="form-control"
                                    :class="{ 'is-invalid': errors.has('newCourse.courseDescription') }" />
                                <div v-if="submitted && errors.has('newCourse.courseDescription')"
                                    class="invalid-feedback">
                                    {{ errors.first('newCourse.courseDescription') }}</div>
                            </b-form-group>
                            <b-form-group>
                                <label htmlFor="newCourse.courseId">Cost to Enroll:</label>
                                <input v-validate="'required'" type="number" v-model.number="newCourse.cost" name="newCourse.cost"
                                     class="form-control"
                                    :class="{ 'is-invalid': submitted.addInstructorCourseButton && errors.has('lastName') }" />
                                <div v-if="submitted && errors.has(``)" class="invalid-feedback">
                                    {{ errors.first('newCourse.courseId') }}</div>
                            </b-form-group>
                            <b-form-group>
                                <label>Course Files:</label>
                                <b-form-file multiple v-model="newCourse.courseFiles" :file-name-formatter="formatNames"
                                    drop-placeholder="Drop file here" class="form-control"
                                    :class="{ 'is-invalid': errors.has('createdCourseDescription') }">
                                </b-form-file>
                                <div v-if="submitted && errors.has('createdCourseDescription')"
                                    class="invalid-feedback">
                                    {{ errors.first('createdCourseDescription') }}</div>
                            </b-form-group>
                            <b-form-group>
                            <button>Submit</button>
                            </b-form-group>
                        </b-form>
                    </b-col>
                </b-row>
            </b-tab>
            <b-tab no-body>
                <template v-slot:title>
                    &minus; Delete Subject
                </template>
                <b-card-text>
                    <b-row v-for="course in courses.allCourses" :key="course.courseId" align-v="center"
                        align-h="center">

                        <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                            <b-list-group>
                                <b-list-group-item disabled href='#' variant="dark">
                                    {{course.courseName}}
                                </b-list-group-item>
                            </b-list-group>
                        </b-col>
                        <b-col xl="4" lg="6" md="6" sm="6" cols="6">
                            <b-list-group>
                                <b-list-group-item @click="deleteSubject(course, course.courseId)" href="#" class="text-danger" variant="danger">
                                    Delete
                                </b-list-group-item>
                            </b-list-group>
                        </b-col>
                    </b-row>
                </b-card-text>
            </b-tab>
            <b-tab no-body title="Deprecate Subject">
                <b-card-text>
                    <b-row v-for="course in courses.allCourses" :key="course.courseId" align-v="center">

                        <b-col xl="8" lg="6" md="6" sm="6" cols="6">
                            <b-list-group>
                                <b-list-group-item disabled href='#' variant="dark">
                                    {{course.courseName}}
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
    import {
        api
    } from '../../../../_services/api.service'
    import {
        mapState,
        mapActions
    } from 'vuex'
    export default {
        data() {
            return {
                submitted: false,

                newCourse: {
                    courseId: 'CS:5800',
                    courseName: 'Fundamentals of Software Engineering',
                    students: null,
                    quiz: [],
                    grades: [],
                    instructorId: '',
                    courseDescription: 'Default Course Description...',
                    courseFiles: [],
                    cost: 0,
                },

                submitted: {
                    addInstructorCourseButton: false,
                },
            }
        },

        created() {
        },

        computed: {
                    ...mapState({
                        account: state => state.account,
                        courses: state => state.courses
                    }),
                },

        methods: {
            ...mapActions('courses', ['createCourse', 'deleteCourse']),

            formatNames(files) {
                if (files.length === 1) {
                    return files[0].name
                } else {
                    return `${files.length} files selected`
                }
            },

            handleAddInstructorSubject() {
                this.submitted.addInstructorCourseButton = true;
                console.log('handling')
                this.$validator.validate().then(valid => {
                    if (valid) {
                        console.log('valid')
                        this.newCourse.instructorId = this.account.user.instructorId;
                        console.log(this.newCourse)
                        this.createCourse(this.newCourse)
                    }
                }
                );
            },

            deleteSubject( course, courseId ) {
                this.deleteCourse( {course, courseId} )
            },
        }
    }
</script>

<style scoped>

</style>
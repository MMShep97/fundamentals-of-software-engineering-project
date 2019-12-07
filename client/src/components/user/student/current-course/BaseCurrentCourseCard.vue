<template>
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="Home">
                                <div v-for="content in course" :key="content.id">
                                    <p>{{content}}</p>
                                </div>
                            </b-tab>
                            <b-tab no-body title="Announcements">
                                <b-card-text>
                                    <div v-for="announcement in announcements" :key="announcement.id">
                                        <p>{{announcement}}</p>
                                    </div>
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Assignments">
                                <b-card-text>
                                    <TakeExam />
                                </b-card-text>
                            </b-tab>
                            <b-tab no-body title="Grades">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="People">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="Modules">
                                <b-card-text></b-card-text>
                            </b-tab>
                            <b-tab no-body title="Feedback">
                                <b-card-text></b-card-text>
                            </b-tab>
                        </b-tabs>

                    </b-card>
</template>

<script>
import TakeExam from './TakeExam'
export default {
    components: {
        TakeExam,
    },

    data () {
        return {
            course: ['boop'],
            announcements: ['boop']
        }
    }
}
</script>

<style scoped>

</style>
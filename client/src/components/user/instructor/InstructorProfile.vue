<template>
    <div class="instructor-profile-container">

        <b-container>
            <b-row align-h="center" align-v="start" class="row-margin">
                <b-col>
                    <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>

                </b-col>
            </b-row>
            <b-row align-h="center" align-v="start" class="row-margin">
                <b-col md="4">
                    <h4>Select from your current classes:</h4>
                    <b-form-select v-model="selected" :options="options" class="mb-3" value-field="class"
                        text-field="name" disabled-field="notEnabled"></b-form-select>
                    <div class="">Current Course: <strong>{{ selected }}</strong></div>
                </b-col>
            </b-row>
            <b-row v-if="selected">
                <b-col md="6" sm="12">
                    <h5 class="task-header">Subjects</h5>
                    <b-card no-body>
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="Add Subject">
                                <b-card-text>Test 1</b-card-text>
                            </b-tab>
                            <b-tab no-body title="Delete Subject">2</b-tab>
                            <b-tab no-body title="Deprecate Subject">
                            </b-tab>
                        </b-tabs>

                    </b-card>

                </b-col>
                <b-col md="6" sm="12">
                    <h5 class="task-header">Grades</h5>
                    <b-card no-body class="card-style grades-card">
                        <b-tabs content-class="mt-1" card pills justified align="center">
                            <b-tab no-body title="Assign Grades">
                                <b-card-text>Test 1</b-card-text>
                            </b-tab>
                            <b-tab no-body title="Update Grades">2</b-tab>
                            <b-tab no-body title="Publish Grades">
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
                selected: '',
                options: [{
                        class: 'math',
                        name: 'Math'
                    },
                    {
                        class: 'science',
                        name: 'science'
                    }
                ]
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
            })
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
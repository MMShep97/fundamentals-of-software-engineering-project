<template>
    <div class="instructor-profile-container">
        <h1>Hi {{account.user.userType}} {{account.user.firstName}}!</h1>
        <h4>Select from your current classes:</h4>
        <form action="">
            <b-form-group>
                <label htmlFor="className"></label>
                <!-- <select v-model="user.userType" v-validate='required' name="className" class="form-control"> -->
                    <!-- <option v-for="class in instructor" v-bind:key="class.id"> -->
                        
                    <!-- </option> -->
                <!-- </select> -->
                </b-form-group>
        </form>
        <b-container>
            <b-row>
                <b-col>
                    <b-card title="Subjects" class="card-style subjects-card">
                        <ul>
                            <li>
                                <router-link to='/'>Add Subject</router-link>
                            </li>
                            <li>
                                <router-link to='/'>
                                    Delete Subject
                                </router-link>
                            </li>
                            <li>
                                <router-link to='/'>
                                    Deprecate Subject
                                </router-link>
                            </li>
                        </ul>
                    </b-card>

                </b-col>
                <b-col>
                    <b-card title="Grades" class="card-style grades-card">
                        <ul>
                            <li>
                                <router-link to='/'>
                                    Assign Grades
                                </router-link>
                            </li>
                            <li>
                                <router-link to='/'>
                                    Update Grades
                                </router-link>
                            </li>
                            <li>
                                <router-link to='/'>
                                    Publish Grades
                                </router-link>
                            </li>
                        </ul>
                    </b-card>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
    import { mapState, mapActions } from 'vuex'
    export default {
        data () {
            return {

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
</style>
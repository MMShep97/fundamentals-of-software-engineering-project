<template>
    <div class="component-container">
        <b-container>
            <b-row>
                <!-- Delete users -->
                <b-col>
                    <h3>Users from secure api end point:</h3>
                    <em v-if="users.loading">Loading users...</em>
                    <span v-if="users.error" class="text-danger">ERROR: {{users.error}}</span>

                    <ul v-if="users.items">
                        <li v-for="user in users.items" :key="user.id">
                            {{user.firstName + ' ' + user.lastName}} ({{user.userType}})
                            <span v-if="user.deleting"><em> - Deleting...</em></span>
                            <span v-else-if="user.deleteError" class="text-danger"> - ERROR: {{user.deleteError}}</span>
                            <span v-else> - <a @click="deleteUser(user.id)" class="text-danger">Delete</a></span>
                        </li>
                    </ul>
                </b-col>
                <!-- Add Instructors -->
                <b-col>
                    <h3>Add Instructors . . .</h3>
                </b-col>
            </b-row>
        </b-container>
        <p>
            <router-link to="/login">Logout</router-link>
        </p>
    </div>
</template>

<script>
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
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
        }
    };
</script>

<style scoped>
    ul {
        list-style: none;
    }

    .component-container {
        margin-top: 50px;
    }
</style>
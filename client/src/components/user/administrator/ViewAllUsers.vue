<template>
    <div class="view-users-container">
        <h5 class="task-header"><span>Showing current registered users...</span></h5>
        <b-card class="card-style delete-users-card">
            <em v-if="users.loading">Loading users...</em>
            <span v-if="users.error" class="text-danger">ERROR: {{users.error}}</span>
            <b-container>
                <div v-if="users.items">
                    <b-row>
                        <b-col><em>Name</em></b-col>
                        <b-col><em>User Type</em></b-col>
                        <b-col><em>Action</em></b-col>
                    </b-row>
                    <b-row v-for="user in users.items" :key="user.id">
                        <b-col>{{user.firstName + ' ' + user.lastName}}</b-col>
                        <b-col>{{user.userType}}</b-col>
                        <b-col>
                            <span v-if="user.deleting"><em> Deleting...</em></span>
                            <span v-else-if="user.deleteError" class="text-danger"> - ERROR: {{user.deleteError}}</span>
                            <b-col v-else-if="user.id != account.user.id"><a @click="deleteUser(user.id)"
                                    class="text-danger">Delete</a></b-col>
                            <b-col v-else class="text-info"><em>You - no action</em></b-col>
                        </b-col>
                    </b-row>
                </div>
            </b-container>
        </b-card>

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

    .card-style {
        background-color: ghostwhite;
    }
</style>
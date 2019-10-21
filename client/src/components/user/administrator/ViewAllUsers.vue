<template>
    <div class="view-users-container">
        <b-card class="card-style delete-users-card">
            <h3>Showing current registered users...</h3>
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
                                <b-col v-else-if="user.id != account.user.id"><a @click="deleteUser(user.id)" class="text-danger">Delete</a></b-col>
                                <b-col v-else><em>You - no action</em></b-col>
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
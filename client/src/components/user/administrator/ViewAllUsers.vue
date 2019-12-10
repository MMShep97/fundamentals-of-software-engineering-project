<template>
    <div class="view-users-container">
        <h5 class="task-header"><span>Showing current registered users...</span></h5>
        <b-card class="card-style delete-users-card">
            <span v-if="account.status.fetchingUsers"><em>Loading users...</em></span>
            <!-- <span v-if="users.error" class="text-danger">ERROR: {{users.error}}</span> -->
            <b-container v-if="account.status.fetchedUsers">
                <div>
                    <b-row>
                        <b-col><em>Name</em></b-col>
                        <b-col><em>User Type</em></b-col>
                        <b-col><em>Action</em></b-col>
                    </b-row>
                    <b-row>
                        <b-col><div class="line-separator"></div></b-col></b-row>
                    <b-row v-for="user in account.allUsers" :key="user.username">
                        <b-col>{{user.firstName + ' ' + user.lastName}}</b-col>
                        <b-col>{{user.category}}</b-col>
                        <b-col>
                            <!-- <span v-if="user.deleting"><em> Deleting...</em></span> -->
                            <!-- <span v-else-if="user.deleteError" class="text-danger"> - ERROR: {{user.deleteError}}</span> -->
                            <b-col v-if="user.username != account.user.username"><a @click="deleteRegisteredUser(user.username)"
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
            })
        },
        created() {
            this.viewAllUsers()
        },
        methods: {
          ...mapActions('account', ['viewAllUsers']),

          deleteRegisteredUser(username) {
              this.deleteUser(username)
          }
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
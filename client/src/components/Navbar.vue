<template>
    <div>
        <b-navbar class="navbar-styling" toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand to="/">
                <img src='../assets/graduation_cap.png' class="d-inline-block" alt="" width="auto" height="35px">
                Educadia
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse is-nav id="nav-collapse">
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-nav-item v-if="!account.status.loggedIn">
                        <b-button v-b-tooltip.hover title="Login!" to='/login' size="sm" variant='outline-light'>
                            Login
                        </b-button>
                    </b-nav-item>
                    <b-nav-item v-if="!account.status.loggedIn">
                        <b-button v-b-tooltip.hover title="Register!" to='/register' size="sm" variant='outline-light'>
                            Register
                        </b-button>
                    </b-nav-item>

                    <b-nav-item-dropdown v-if="account.status.loggedIn" right>
                        <!-- Using 'button-content' slot -->
                        <template v-slot:button-content>
                            <span style="color: white;" v-if="account.user.cost">Debt: ${{account.user.cost}} | </span>
                            <em>{{account.user.firstName}} {{account.user.lastName}}</em>
                        </template>
                        <b-dropdown-item to='/user-profile'>Profile</b-dropdown-item>
                        <b-dropdown-item to='/settings'>Settings</b-dropdown-item>
                        <b-dropdown-item to='/logout' v-on:click="logout()">Sign Out</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
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

            }
        },

        computed: {
            ...mapState({
                account: state => state.account,
            }, 'account', ['status']),
        },
        methods: {
            ...mapActions('account', ['login', 'logout']),
        }
    }
</script>

<style scoped>
    .navbar-styling {
        border-bottom: 2px solid black;
        box-shadow: 0 10px 6px 0 rgba(0, 0, 0, .16);
    }

    .navbar-brand {
        letter-spacing: 5px;
        font-size: 25px;
        font-family: 'Lobster';
        animation: glow 6s ease-in-out infinite alternate;
    }

    @keyframes glow {
        from {
        }

        to {
            text-shadow: 0 0 5px #fff, 0 0 5px rgb(228, 219, 219), 0 0 10px #a88b8b, 0 0 15px #644d4d, 0 0 20px #1a1950, 0 0 22px #3a2e2e, 0 0 24px #050404;
        }
    }

    em {
        font-size: 20px;
        display: inline-block;
        margin-right: 5px;
    }
</style>
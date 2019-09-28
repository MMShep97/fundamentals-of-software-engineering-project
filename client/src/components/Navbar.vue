<template>
    <div>
        <b-navbar class="navbar-styling" toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand to="/" >
            <img src="" class="d-inline-block align-top" alt="">
            Educadia
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <!-- <b-navbar-nav>
                    <b-nav-item href="#">Link</b-nav-item>
                    <b-nav-item href="#" disabled>Disabled</b-nav-item>
                </b-navbar-nav> -->

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-button>
                        <b-nav-item to="/login">LOGIN</b-nav-item>
                    </b-button>
                    <b-button>
                        <b-nav-item to="/signup">SIGN UP</b-nav-item>
                    </b-button>
                    <b-nav-item-dropdown text="Lang" right>
                        <b-dropdown-item href="#">EN</b-dropdown-item>
                        <b-dropdown-item href="#">ES</b-dropdown-item>
                        <b-dropdown-item href="#">RU</b-dropdown-item>
                        <b-dropdown-item href="#">FA</b-dropdown-item>
                    </b-nav-item-dropdown>

                    <b-nav-item-dropdown right>
                        <!-- Using 'button-content' slot -->
                        <template v-slot:button-content>
                            <em>User</em>
                        </template>
                        <b-dropdown-item href="#">Profile</b-dropdown-item>
                        <b-dropdown-item href="#">Sign Out</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>
.navbar-styling {
    background-color: darkslateblue !important;
    border-bottom: 2px solid black;
    box-shadow: 0 2px 5px 0 rgba(0,0,0,.16);
}
</style>
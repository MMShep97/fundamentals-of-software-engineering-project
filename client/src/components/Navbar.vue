<template>
    <div>
        <b-navbar class="navbar-styling" toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand to="/" >
            <img src="" class="d-inline-block align-top" alt="">
            Educadia
            </b-navbar-brand>

            <b-collapse id="nav-collapse" is-nav>
                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-nav-item to='/login'>
                        <b-button size="sm" variant='outline-light'>
                        Login
                        </b-button>
                    </b-nav-item>
                    <b-nav-item to='/register'>
                        <b-button size="sm" variant='outline-light'>
                        Register
                        </b-button>
                    </b-nav-item>

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
    border-bottom: 2px solid black;
    box-shadow: 0 10px 6px 0 rgba(0,0,0,.16);
}
</style>
<template>
    <div>
        <div v-if="loggedIn">
            Display stuff if logged in
        </div>
        <div v-else>
            <Login></Login>
        </div>
    </div>
</template>

<script>
import Login from './Login.vue'
import Signup from './Signup.vue'

export default {
    data() {
        return {
            
        }
    }
}
</script>

<style scoped>

</style>
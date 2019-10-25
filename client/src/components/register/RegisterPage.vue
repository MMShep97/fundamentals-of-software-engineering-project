<template>
    <div>
        <b-container fluid>
            <b-row align-v="center" align-h="center">
                <b-col cols="4">
                    <h2>Register</h2>
                    <RegisterForm></RegisterForm>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
import RegisterForm from './RegisterForm'

    export default {
        components: {
            RegisterForm
        }
    };
</script>

<style scoped>
    
</style>
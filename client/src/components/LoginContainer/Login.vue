<template>
    <div class="login-component">
        <div class="input-container">
            Username: <input placeholder="Enter username here..."/>
            Password: <input placeholder="Enter password here..."/>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            
        }
    }
}
</script>

<style scoped>
.login-component {
    text-align: center;
    height: 400px;
    width: 200px;
}

.input-container {
    padding: 50% 0;
}
</style>
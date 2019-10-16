<template>
  <div id="app">
    <Navbar></Navbar>
    <b-jumbotron class='overlay'>
      <b-container>
        <b-row align-h="center">
          <b-col cols="6">
            <div v-if="alert.message" :class="`alert ${alert.type}`">{{alert.message}}</div>
          </b-col>
        </b-row>
      </b-container>
      <router-view></router-view>
    </b-jumbotron>
  </div>
</template>

<script>
  /*eslint-disable*/
  import {
    mapState,
    mapActions
  } from 'vuex'
  import Navbar from './components/Navbar.vue'

  export default {
    name: 'app',
    computed: {
      ...mapState({
        alert: state => state.alert
      })
    },
    methods: {
      ...mapActions({
        clearAlert: 'alert/clear'
      })
    },
    watch: {
      $route(to, from) {
        // clear alert on location change
        this.clearAlert();
      }
    },
    components: {
      Navbar,
    }
  }
</script>

<style>
  #app {
    font-family: 'Cabin', 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  html {
    background-color: #e9ecef;
  }

  .overlay {
    height: 100vh;
    width: 100vw;
    max-width: 100%;
    text-align: center;
  }

  .b-row {
    display: inline-block;
  }

  .b-col {}
</style>
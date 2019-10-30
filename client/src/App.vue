<template>
  <div id="app">
    <Navbar></Navbar>
    <b-jumbotron class='welcome-overlay'>
      <b-container>
        <b-row align-h="center">
          <b-col cols="6" sm="6">
            <div v-if="alert.message" :class="`alert ${alert.type} center-alert`">{{alert.message}}</div>
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
 html {
    background-color: #e9ecef;
  }

#app {
    font-family: 'Cabin', 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  .center-alert {
    text-align: center;
  }

  .line-separator {
    margin-top: 1rem;
    margin-bottom: 1rem;
    border-top: 4px solid #b71540af;
    background-color: #b71540af;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}

  .task-header {
        padding-top: 3px;
        margin: 0 0;
        background-color: #b71540af;

        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }

    .tab-content>.active {
        display: block;
        padding: 5px 5px;
    }

    .row {
        padding: 5px 0;
    }
</style>
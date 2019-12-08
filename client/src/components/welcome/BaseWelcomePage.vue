<template>
    <div class="base-welcome-container">
        <div v-if="!account.status.loggedIn">
            <b-container fluid>
                <b-row align-v="center">
                    <b-col cols="12">
                        <img class="welcome-image" src='../../assets/graduation_cap.png'>
                        <b-jumbotron header="Educadia"
                            lead="Paving the way for a transcendent customer-first focused approach to educational tutoring">
                            <b-button to="/register" variant="primary" id="create-account-button">
                                Create your account today!
                            </b-button>
                            <b-tooltip target="create-account-button" placement="bottom">Already have an account? Login
                                <router-link to='/login'>here!</router-link>
                            </b-tooltip>
                        </b-jumbotron>
                    </b-col>
                </b-row>
                <b-row>
                    <b-col md="12">
                        <div class="line-separator"></div>
                    </b-col>
                </b-row>
                <b-row align-v="center" class="quote quotes quote-container">
                    <b-col lg="6" sm="12" cols="12">
                        <div class="box-container">
                            <div class="box"><i class="fas fa-quote-left fa2"></i>
                                <div class="text"><i class="fas fa-quote-right fa1"></i>
                                    <div>
                                        <h3>Quote from Actual Users</h3>
                                        <p>This is hands down one of, if not, the best, custom tutoring apps I've ever
                                            used!
                                            Simply outstanding!
                                            I wish this was around when I was in High School!</p>
                                        <p>-Ethan Degross</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </b-col>
                    <b-col lg="6" sm="12" cols="12">
                        <div class="box-container">
                            <div class="box"><i class="fas fa-quote-left fa2"></i>
                                <div class="text"><i class="fas fa-quote-right fa1"></i>
                                    <div>
                                        <h3>Quote of the Day</h3>
                                        <p> I did some extensive searching to find a truly great experience,
                                            and I really do think I've found it here at Educadia. The course pool here is amazing, 
                                            and there's a HUGE bang for your buck.
                                        </p>
                                        <p>-Tutoring Superfan</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </b-col>
                </b-row>
            </b-container>
        </div>
        <div v-else-if="account.status.loggedIn">
            <img class="welcome-image" src='../../assets/graduation_cap.png'>
            <b-jumbotron>
                <template v-slot:header class='jumbo-header'>Welcome, {{account.user.category}}
                    {{account.user.firstName}}!</template>
                <template v-slot:lead>Try checking out your <router-link to="/user-profile">profile</router-link> for
                    important information!</template>
            </b-jumbotron>
            <div v-if="account.user.category == 'Student'">
                <StudentWelcomePage></StudentWelcomePage>
            </div>
            <div v-else-if="account.user.category == 'Instructor'">
                <InstructorWelcomePage></InstructorWelcomePage>
            </div>
            <div v-else-if="account.user.category == 'Administrator'">
                <AdministratorWelcomePage></AdministratorWelcomePage>
            </div>
            <div class="line-separator"></div>
            <div class="external-links text-left">
            <p>Looking for some additional help? Try out some of our affiliated partner sites to get that extra classroom boost!</p>
            <ul style="list-style: none">
                <li>
                </li>
                <li><a href="https://tutor.com">Tutor.com</a> - Every session is one-to-one and personalized to your subject and question</li>
                <li><a href="https://chegg.com">Chegg</a> - Online tutors are available in a wide array of subjects and topics to help you wherever you need.</li>
                <li><a href="https://varsitytutors.com">Varsity Tutors</a> - Varsity Tutors facilitates online and in-home tutoring with highly-credentialed tutors and flexible scheduling.</li>
                <li><a href="https://www.sylvanlearning.com/personalized-tutoring/our-approach">Sylvan Learning</a> - Discover why students in our Personalized Tutoring programs typically see up to two to three times more growth in scores than other kids.</li>
                <li><a href="https://www.wyzant.com/">Wyzant</a> - Private, 1–on–1 lessons with the expert instructor of your choice. You decide when to meet, how much to pay, and who you want to work with.</li>
                    <a href="https://tutorthepeople.com">Tutor The People</a> - Tutoring for the people, by the people. Our tutors are doctors, executives, and scholars whose passion for tutoring gives our students a higher return on their investment.
                <li><a href=""></a></li>
                <li><a href=""></a></li>
            </ul>
            </div>

        </div>
    </div>
</template>

<script>
    import StudentWelcomePage from './student/StudentWelcomePage'
    import InstructorWelcomePage from './instructor/InstructorWelcomePage'
    import AdministratorWelcomePage from './administrator/AdministratorWelcomePage'
    import {
        api
    } from '../../_services/api.service'

    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        data() {
            return {
                allStudents: null,
            }
        },

        components: {
            StudentWelcomePage,
            InstructorWelcomePage,
            AdministratorWelcomePage,
        },

        computed: {
            ...mapState({
                account: state => state.account,
            })
        },
        created() {
            api.user.getStudents().then(response => (this.allStudents = response.data))
        },

        mounted() {

        },
        methods: {}
    };
</script>

<style scoped>
    .base-welcome-container {
        text-align: center;
    }

    .welcome-image {
        border-radius: 10px;
        height: 150px;
        width: auto;
        transition: transform .4s;
    }

    img:hover {
        transform: scale(1.1)
    }

    .jumbotron {
        padding: 2rem 2rem;
    }

    .quotes {
        margin-top: 200px;
        margin-bottom: 100px;
    }

    .box-container {
        width: auto;
        height: auto;
    }

    .box {
        background-color: transparent;
        border-radius: 3px;
        color: #fff;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 400px;
        height: 300px;
        transform-style: preserve-3d;
        perspective: 2000px;
        transition: 0.4s;
        text-align: center;
    }

    .box:before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: transparent;
        border-top: 15px solid rgb(31, 42, 53);
        border-left: 20px solid rgb(31, 42, 53);
        box-sizing: border-box;
    }

    .box:after {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        border-bottom: 10px solid rgb(31, 42, 53);
        border-right: 10px solid rgb(31, 42, 53);
        box-sizing: border-box;
    }

    .box .fas {
        font-size: 25px;
        height: 50px;
        width: 50px;
        line-height: 50px !important;
        background-color: #b71540;
        color: #2C3A47;
    }

    .box .fa2 {
        position: absolute;
        bottom: 0;
        right: 0;
        z-index: 1;
    }

    .box .text {
        position: absolute;
        top: 30px;
        left: -30px;
        width: calc(100% + 60px);
        height: calc(100% - 60px);
        background-color: #2C3A47;
        border-radius: 3px;
        transition: 0.4s;
    }

    .box .text .fa1 {
        position: absolute;
        top: 0;
        left: 0;
    }

    .box .text div {
        position: absolute;
        top: 50%;
        left: 0;
        transform: translateY(-50%);
        text-align: center;
        width: 100%;
        padding: 30px 60px;
        line-height: 1.5;
        box-sizing: border-box;
    }

    .box .text div h3 {
        font-size: 30px;
        margin-bottom: 5px;
    }

    .box .text div p {
        font-size: 15px;
    }

    .box:hover {
        transform: translate(-50%, -50%) rotateY(-20deg) skewY(3deg);
    }

    .box:hover .text {
        transform: rotateY(20deg) skewY(-3deg);
    }

    .external-links {
        font-size: 24px;
        color:rgba(117, 119, 121, 0.438);
    }

    .external-links a {
        color:rgba(61, 111, 161, 0.548);
    }

    .external-links p {
        color:rgba(40, 40, 41, 0.678)
    }
</style>
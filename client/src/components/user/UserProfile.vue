<template>
<div>
    <Accordian>
        <template v-slot:title>{{courseList.activeCourses.english.title}}</template>
        <template v-slot:text>{{courseList.activeCourses.english.text}}</template>
    </Accordian>
    <Accordian>
        <template v-slot:title>{{courseList.pastCourses.math.title}}</template>
        <template v-slot:text>{{courseList.pastCourses.math.text}}</template>
    </Accordian>
</div>
</template>

<script>
    import Accordian from '../utility/Accordian'
    import {
        mapState,
        mapActions
    } from 'vuex'

    export default {
        components: {
            Accordian,
        },
        data() {
            return {
                courseList: {
                    activeCourses: {
                        english: { 
                            title: 'English', 
                            text: 'Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry  richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.'
                            }
                    },
                    pastCourses: {
                        math: { 
                            title: 'Math',
                            text: 'noice.'
                            }
                    },
                }
            }
        }
    }
</script>

<style scoped>

</style>
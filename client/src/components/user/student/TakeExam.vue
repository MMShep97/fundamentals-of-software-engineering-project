<template>
    <div class="take-exam-container">
        <h2 class="text-center">Quiz</h2>
        <form>
            <Question v-for="question in questions" :question="question.text" :options="question.options">
            </Question>
        </form>
    </div>
</template>

<script>
import Question from '../instructor/Question'
    export default {
        components: {
            Question,
        },
        
        data() {
            return {
                question: '',
                options: [{
                    text: ''
                }, {
                    text: ''
                }],
                correctOption: 0,
                picked: '',

                questions: [{
                        text: 'Is Vue.js awesome?',
                        options: [{
                                text: 'Yes!',
                                correct: true
                            }, {
                                text: 'Yes sure!',
                                correct: true
                            },
                            {
                                text: 'Of course it is!',
                                correct: true
                            }
                        ]
                    },
                    {
                        text: 'Is it possible to use JSX within Vue.js single file components?',
                        options: [{
                            text: 'No, JSX is about React',
                            correct: false
                        }, {
                            text: 'Yes',
                            correct: true
                        }]
                    },
                    {
                        text: 'What should v-on directive used for?',
                        options: [{
                            text: 'It should be used to put something on something else',
                            correct: false
                        }, {
                            text: 'It should be used to bind events to methods',
                            correct: true
                        }]
                    },
                    {
                        text: 'What is the extension of Vue.js single file components?',
                        options: [{
                            text: '.js',
                            correct: false
                        }, {
                            text: '.jsx',
                            correct: false
                        }, {
                            text: '.vue',
                            correct: true
                        }]
                    },
                    {
                        text: 'What is the name of Vue.js creator?',
                        options: [{
                                text: 'Evan Me',
                                correct: false
                            },
                            {
                                text: 'Evan You',
                                correct: true
                            }, {
                                text: 'Evan Them',
                                correct: false
                            }, {
                                text: 'Evan Vue',
                                correct: false
                            }
                        ]
                    },
                ]
            }
        }
    }
</script>

<style scoped>

</style>
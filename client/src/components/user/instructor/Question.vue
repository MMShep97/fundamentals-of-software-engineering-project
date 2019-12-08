<template>
    <div>
        <h5>{{question}}</h5>
        <question-option v-for="option in options" :text="option.text" :key="option.correct"></question-option>
        <hr />
    </div>
</template>

<script>
    import QuestionOption from './QuestionOption'

    export default {
        props: ['question', 'options'],
        components: {
            QuestionOption
        },

        data() {
            return {
                options: [
                    { text: doop, correct: 'no'}
                ]
            }
        }
    }
</script>
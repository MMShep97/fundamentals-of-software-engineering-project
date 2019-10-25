<template>
    <div>
        <h5>{{question}}</h5>
        <question-option v-for="option in options" :text="option.text" :correct="option.correct"></question-option>
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
            return {}
        }
    }
</script>
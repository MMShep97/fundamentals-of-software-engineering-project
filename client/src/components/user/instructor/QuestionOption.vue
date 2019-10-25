<template>
    <div class="form-group checkbox" :class="{'text-success': isSuccess, 'text-danger': isDanger}">
      <label class="form-control-label" >
        <input v-model="checked" type="checkbox"> {{text}}
      </label>
    </div>
</template>


<script>
export default {
    data () {
    return {
      checked: false
    }
  },
  props: ['text', 'correct'],
  computed: {
    isSuccess () {
      return this.correct && this.checked
    },
    isDanger () {
      return !this.correct && this.checked
    }
  },
}
</script>
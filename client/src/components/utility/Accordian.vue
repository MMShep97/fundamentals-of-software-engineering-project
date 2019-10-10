<template>
    <div role="tablist">
    <b-card no-body class="mb-1">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button 
        :class="showCollapse ? 'collapsed' : null"
        :aria-expanded="showCollapse ? 'true' : 'false'"
        aria-controls="collapse-4"
        @click="showCollapse = !showCollapse"
        block href="#" variant="info"
        >
            <slot name='title'></slot>
        </b-button>
      </b-card-header>
      <b-collapse id="accordion-1" accordion="my-accordion" role="tabpanel">
        <b-card-body>
          <b-card-text><slot name='text'></slot></b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>
  </div>
</template>

<script>
export default {
    data() {
      return {
        showCollapse: true
      }
    }
}
</script>

<style scoped>

</style>
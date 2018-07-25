<template>
    <div class="card post-it w-25 mt-3 mr-3">
      <div class="card-body">
        <h5 class="card-title">{{ title }}</h5>
        <p class="card-text">{{ description }}</p>
      </div>
    </div>
</template>

<script>
export default {
     props: {
        title: {
            type: String
        },

        description: {
            type: String
        } 
    },
    data() {
        return {
        }
    }
}
</script>

<style scoped>
  .post-it {
    background:#ffc;
    box-shadow: 5px 5px 7px rgba(33,33,33,.7);
  }
</style>

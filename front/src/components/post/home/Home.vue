<template>
   <div class="row">
     <post-it v-for="post in posts" :title="post.title" :description="post.description"></post-it>
  </div>
</template>

<script>
import Postit from '../../shared/post-it/Postit.vue';
import PostService from '../../../services/PostService';

export default {
    components: {
      'post-it' : Postit
    },
    data() {
      return {
         posts: [],
         mensagem: ''
      }
  },
  created() {
    this.service = new PostService(this.$resource);

    this.service
      .listar()
      .then(posts => this.posts = posts, err => this.mensagem = err.message);
  }
}
</script>

<style>

</style>



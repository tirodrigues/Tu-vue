<template>
  <div class="mt-3">
    <b-form @submit.prevent="gravar()" novalidate>
      <b-form-group label="Título:"
                    label-for="title">
        <b-form-input id="title"
                      type="text"
                      v-model="post.title"
                      required
                      placeholder="Título aqui..."
                      data-vv-as="título" 
                      name="titulo" 
                      v-validate data-vv-rules="required|min:3|max:10"/>
        <div class="custom-invalid-feedback" v-show="errors.has('titulo')">{{ errors.first('titulo') }}</div>
      </b-form-group>
      <b-form-group label="Descrição:"
                    label-for="description">
        <b-form-textarea id="description"
                      type="text"
                      required
                      v-model="post.description"
                      :rows="2"
                      :max-rows="6"
                      placeholder="Descrição aqui..."
                      data-vv-as="descrição" 
                      name="descricao" 
                      v-validate data-vv-rules="required|min:3|max:15"/>
        <div class="custom-invalid-feedback" v-show="errors.has('descricao')">{{ errors.first('descricao') }}</div>
      </b-form-group>
      <b-button type="submit" variant="primary">Cadastar</b-button>
      <b-button type="reset" @click="resetar" variant="danger">Limpar</b-button>
    </b-form>
  </div>
</template>

<script>
import Post from '../../../domain/Post';
import PostService from '../../../services/PostService';

export default {
    data() {
      return {
          post: new Post(),
          id: this.$route.params.id
      }
  },
  methods: {
      gravar() {
        this.$validator
          .validateAll()
          .then(success => {
            if(success) {
              this.service
              .cadastrar(this.post)
              .then(() => {
                this.$router.push({ name: 'dashboard' });
              }, err => console.log(err));
            }
          });
      },
      resetar() {
        this.post = new Post();
      }
  },
  created() {
    this.service = new PostService(this.$resource);
     
     if(this.id) {
        this.service
          .buscar(this.id)
          .then(post => this.post = post);
      }
  }
}
</script>

<style scoped>
.custom-invalid-feedback {
    width: 100%;
    margin-top: .25rem;
    font-size: 80%;
    color: #dc3545;
}
</style>



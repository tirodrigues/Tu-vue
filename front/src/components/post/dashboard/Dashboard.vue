<template>
    <div class="mt-3">

        <b-alert :show="mensagem.length">{{ mensagem }}</b-alert>

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <router-link to="/cadastro" tag="button" class="btn btn-outline-secondary">Adicionar</router-link>
            </div>
            <b-form-input 
                  type="text"
                  placeholder="Pesquise pelo título"
                  v-model="filtro"/>            
        </div>
        <b-table :fields="fields" :items="postsComFiltro">
            <template slot="actions" slot-scope="data">
               <b-button-group>
                   <router-link :to="{ name : 'altera', params: { id: data.item.id} }">
                        <b-button>Editar</b-button>
                    </router-link>
                    <b-button variant="danger" @click="remove(data)">Excluir</b-button>
                </b-button-group>
            </template>
        </b-table> 
    </div>
</template>

<script>
import Post from '../../../domain/Post';
import PostService from '../../../services/PostService';

export default {
  data () {
    return {
      posts: [],
      filtro: '', 
      mensagem: '',
      fields: [
        { key: 'id', label: 'Id' },
        { key: 'title', label: 'Título' },
        { key: 'description', label: 'Descrição' },
        'actions'
      ]
    }
  },
  created() {
    this.service = new PostService(this.$resource);

    this.service
      .listar()
      .then(posts => this.posts = posts, err => this.mensagem = err.message);
  },
  computed: {
    postsComFiltro() {
      if(this.filtro) {
        let exp = new RegExp(this.filtro.trim(), 'i');
        return this.posts.filter(post => exp.test(post.title));
      } else {
        return this.posts;
      }
    }
  },
  methods: {
    remove(data) {
      this.service.apagar(data.item.id)
        .then(()=> {
          this.posts.splice(data.index, 1);
          this.mensagem = 'Post removido com sucesso';
        }, err => {
          this.mensagem = err.message;
        });
      }
  }
}
</script>

<style>
.align-center {
    text-align: center
}
</style>

<template>
    <div>
      <meu-menu></meu-menu>
      <b-container>
        <router-view></router-view>
      </b-container>
    </div>
</template>

<script>
import Menu from './components/shared/menu/Menu.vue';

export default {
  
  components: {
    'meu-menu' : Menu
  },

  data () {
    return {
    }
  }
}
</script>

<style>

</style>

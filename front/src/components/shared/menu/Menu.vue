<template>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <router-link class="navbar-brand" to="/">Tu-vue</router-link>
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav">
                <li v-if="auth" class="nav-item">
                    <router-link class="nav-link" to="/dashboard">
                        <span class="nav-link-text">Dashboard</span>
                    </router-link>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li v-if="!auth" class="nav-item">
                     <router-link class="nav-link" to="/login">
                        <span class="nav-link-text">Login</span>
                     </router-link>
                </li> 
                <li v-if="auth" class="nav-item">
                    <a @click="onLogout" class="nav-link"><span class="nav-link-text">Logout</span></a>
                </li>      
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    computed: {
        auth () {
            return this.$store.getters.isLoggedIn;
        }
    },
    methods: {
        onLogout() {
            this.$store.dispatch('logout');
        }
    }
}
</script>

<style>

</style>


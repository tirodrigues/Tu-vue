<template>
  <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <router-link class="navbar-brand" to="/">Tu-vue</router-link>
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <router-link class="nav-link" to="/dashboard">
                        <span class="nav-link-text">Dashboard</span>
                    </router-link>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                     <router-link class="nav-link" to="">
                        <span class="nav-link-text">Logout</span>
                     </router-link>
                </li>      
            </ul>
        </div>
    </nav>
</template>

<script>
export default {

}
</script>

<style>

</style>


<template>
    <div class="mt-3">
    <b-form @submit.prevent="login">
      <b-form-group id="exampleInputGroup1"
                    label="Username:"
                    label-for="login-input">
        <b-form-input id="login-input"
                      type="text"
                      v-model="username"
                      placeholder="username">
        </b-form-input>
      </b-form-group>
      <b-form-group id="password-input"
                    label="Password:"
                    label-for="exampleInput2">
        <b-form-input id="password-input"
                      type="password"
                      v-model="password"
                      placeholder="password">
        </b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Submit</b-button>
    </b-form>
  </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        login() {
            this.$store.dispatch('login', {'username': this.username, 'password': this.password});
        }
    }
}
</script>

<style>

</style>


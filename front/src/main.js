import Vue from 'vue'
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import VeeValidate from 'vee-validate';
import BootstrapVue from 'bootstrap-vue'

import App from './App.vue'
import router from './routes';
import msg from './pt_BR';
import store from './store'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(VueResource);
Vue.use(BootstrapVue);
Vue.http.options.root = 'http://localhost:8080';

Vue.http.interceptors.push((request, next) => {
  if(store.getters.isLoggedIn) {
    request.headers.set('Authorization', localStorage.getItem('tu-vue-token'));
  }
  request.headers.set('Accept', 'application/json');
  next()
});

Vue.use(VeeValidate, {
  fieldsBagName: 'inputs',
  locale: 'pt_BR',
  dictionary: {
    pt_BR: {
      messages: msg
    }
  }
});

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})

import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import BootstrapVue from 'bootstrap-vue'
import { routes } from './routes';
import VeeValidate from 'vee-validate';
import msg from './pt_BR';

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(VueResource);
Vue.http.options.root = 'http://localhost:8080';

Vue.http.headers.common['Authorization'] = '87de544a-3d4f-419d-8df9-cd82321be33a';

Vue.use(VueRouter);
Vue.use(BootstrapVue);

const router = new VueRouter({ routes });

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
  render: h => h(App)
})

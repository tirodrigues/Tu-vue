import Vue from 'vue'
import Vuex from 'vuex'
import VueResource from 'vue-resource';

import router from './routes';

Vue.use(VueResource);
Vue.use(Vuex);

const url = 'http://localhost:8080/api/login';

const LOGIN = "LOGIN";
const LOGIN_SUCCESS = "LOGIN_SUCCESS";
const LOGOUT = "LOGOUT";

const TOKEN_NAME = "tu-vue-token";

export default new Vuex.Store({
    state: {
      isLoggedIn: !!localStorage.getItem(TOKEN_NAME)
    },
    mutations: {
        [LOGIN] (state) {
          state.pending = true;
        },
        [LOGIN_SUCCESS] (state) {
          state.isLoggedIn = true;
          state.pending = false;
        },
        [LOGOUT](state) {
          state.isLoggedIn = false;
        }
    },
    actions: {
        login({ commit }, creds) {
          commit(LOGIN); 
          Vue.http.post(url, {
            "username": creds.username,
            "password": creds.password
          }).then((res) => {
            commit(LOGIN_SUCCESS);
            localStorage.setItem(TOKEN_NAME, res.data.token);
            router.replace('/dashboard');
          })
          .catch(err => console.log(err));
        },
        logout({ commit }) {
          localStorage.removeItem(TOKEN_NAME);
          commit(LOGOUT);
          router.replace('/');
        }
      },
    getters: {
        isLoggedIn: state => {
           return state.isLoggedIn
        }
    }
 });
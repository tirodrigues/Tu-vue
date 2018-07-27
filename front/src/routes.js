import Vue from 'vue'
import VueRouter from 'vue-router'

import Cadastro from './components/post/cadastro/Cadastro.vue';
import Dashboard from './components/post/dashboard/Dashboard.vue';
import Home from './components/post/home/Home.vue';
import Login from './components/login/Login.vue';

Vue.use(VueRouter)

const routes = [
   { path: '', name: 'home', component: Home },
   { path: '/dashboard', name: 'dashboard', component: Dashboard },
   { path: '/cadastro', name: 'cadastro', component: Cadastro },
   { path: '/cadastro/:id', name: 'altera', component: Cadastro },
   { path: '/login', name: 'login', component: Login },
   { path: '*', component: Home },
];

export default new VueRouter({mode: 'history', routes})
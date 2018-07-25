import Cadastro from './components/post/cadastro/Cadastro.vue';
import Dashboard from './components/post/dashboard/Dashboard.vue';
import Home from './components/post/home/Home.vue';

export const routes = [
   { path: '', name: 'home', component: Home },
   { path: '/dashboard', name: 'dashboard', component: Dashboard },
   { path: '/cadastro', name: 'cadastro', component: Cadastro },
   { path: '/cadastro/:id', name: 'altera', component: Cadastro },
   { path: '*', component: Home },
];
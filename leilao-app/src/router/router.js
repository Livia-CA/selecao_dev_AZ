import Vue from 'vue'
import Router from 'vue-router'
import Empresas from "@/views/empresa/Empresas.vue";
import Leiloes from "@/views/leilao/Leiloes.vue";
import Unidades from "@/views/unidade/Unidades.vue";

Vue.use(Router)

export default new Router({
    routes:[{
        path:'/unidades',
        component: Unidades
    },{
        path:'/leiloes',
        component: Leiloes
    },{
        path:'/empresas',
        component: Empresas
    }]
})
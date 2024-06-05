<template>
  <v-app>
    <Menu></Menu>
    <router-view />
  </v-app>
</template>

<script>
import Menu from './components/Menu.vue';

export default {
  name: 'App',

  components: {
    Menu,
  },
};
</script>

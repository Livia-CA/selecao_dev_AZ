<template>
  <v-bottom-navigation v-model="value" background-color="#F5F5F5" color="primary">
    <v-btn height="100%" to="/unidades">
      <span style="font-size: medium">Unidades</span>
    </v-btn>

    <v-btn height="100%" to="/empresas" value="empresas">
      <span style="font-size: medium">Empresas</span>
    </v-btn>

    <v-btn height="100%" to="/leiloes" value="leiloes">
      <span style="font-size: medium">Leilões</span>
    </v-btn>
  </v-bottom-navigation>
</template>


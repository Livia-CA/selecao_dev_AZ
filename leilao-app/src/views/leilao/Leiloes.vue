<template>
  <v-container>
    <v-card>
      <v-card-title>
        Cadastro de Leilões
        <v-spacer></v-spacer>
      </v-card-title>

      <v-data-table
          :headers="headers"
          :items="empresas"
          item-key="id"
          class="elevation-1"
      >
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Leilões</v-toolbar-title>
          </v-toolbar>
        </template>

      </v-data-table>
    </v-card>
  </v-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      dialog: false,
      headers: [
        { text: 'Razão Social do vendedor', value: 'razaoSocialComprador' },
        { text: 'Inicio Previsto', value: 'inicioPrevisto' },
        { text: 'Total', value: 'totalValoresLote' }
      ],
      empresas: [],
    };
  },

  methods: {
    async fetchEmpresas() {
      const response = await axios.get('/leilao');
      this.empresas = response.data;
    },
  },
  created() {
    this.fetchEmpresas();
  },
};
</script>

<style scoped>
</style>

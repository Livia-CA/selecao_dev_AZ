<template>
  <v-container>
    <v-card>
      <v-card-title>
        Cadastro de Empresas
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
            <v-toolbar-title>Empresas</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="800px">
              <template v-slot:activator="{ on, attrs }">
                <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">Nova Empresa</v-btn>
              </template>

              <v-card>
                <v-card-title>
                  <span class="headline">{{ formTitle }}</span>
                </v-card-title>

                <v-card-text>
                  <v-container>
                    <v-form ref="form" v-model="valid">
                      <v-row>
                        <v-col cols="12" sm="6">
                          <v-text-field v-model="editedItem.razaoSocial" :rules="[v => !!v || 'Razão Social é obrigatória']" label="Razão Social*" required></v-text-field>
                          <v-text-field v-model="editedItem.cnpj" :rules="[v => !!v || 'CNPJ é obrigatório', v => /^\d{14}$/.test(v) || 'CNPJ deve ter 14 dígitos']" label="CNPJ*" required></v-text-field>
                          <v-text-field v-model="editedItem.logradouro" label="Logradouro" required></v-text-field>
                          <v-text-field v-model="editedItem.numero" label="Numero" required></v-text-field>
                          <v-text-field v-model="editedItem.bairro" label="Bairro" required></v-text-field>
                          <v-text-field v-model="editedItem.telefone" label="Telefone" required></v-text-field>
                          <v-text-field v-model="editedItem.senha" label="Senha" required></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6">
                          <v-text-field v-model="editedItem.municipio" label="Municipio" required></v-text-field>
                          <v-text-field v-model="editedItem.complemento" label="Complemento" required></v-text-field>
                          <v-text-field v-model="editedItem.cep" label="CEP" required></v-text-field>
                          <v-text-field v-model="editedItem.email" :rules="[v => !!v || 'Email é obrigatório', v => /.+@.+\..+/.test(v) || 'Email deve ser válido']" label="Email*" required></v-text-field>
                          <v-text-field v-model="editedItem.site" label="Site" required></v-text-field>
                          <v-text-field v-model="editedItem.usuario" :rules="[v => !!v || 'Usuário é obrigatório']" label="Usuario*" required></v-text-field>
                        </v-col>
                      </v-row>
                    </v-form>
                  </v-container>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="closeDialog">Cancelar</v-btn>
                  <v-btn color="blue darken-1" text @click="saveEmpresa">Salvar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>

        <template v-slot:item.actions="{ item }">
          <v-icon small class="mr-2" @click="editEmpresa(item)">mdi-pencil</v-icon>
          <v-icon small @click="deleteEmpresa(item)">mdi-delete</v-icon>
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
      valid: true,
      headers: [
        {text: 'CNPJ', value: 'cnpj'},
        {text: 'Razão Social', value: 'razaoSocial'},
        {text: 'Telefone', value: 'telefone'},
        {text: 'Email', value: 'email'},
        {text: 'Ações', value: 'actions', sortable: false},
      ],
      empresas: [],
      editedIndex: -1,
      editedItem: {
        id: null,
        razaoSocial: '',
        cnpj: '',
        logradouro: '',
        municipio: '',
        numero: '',
        complemento: '',
        bairro: '',
        cep: '',
        telefone: '',
        email: '',
        site: '',
        usuario: '',
        senha: '',
        createdAt: '',
        updatedAt: '',
      },
      defaultItem: {
        id: null,
        razaoSocial: '',
        cnpj: '',
        logradouro: '',
        municipio: '',
        numero: '',
        complemento: '',
        bairro: '',
        cep: '',
        telefone: '',
        email: '',
        site: '',
        usuario: '',
        senha: '',
        createdAt: '',
        updatedAt: '',
      },
    };
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'Nova Empresa' : 'Editar Empresa';
    },
  },
  methods: {
    openDialog() {
      this.dialog = true;
    },
    closeDialog() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },
    async saveEmpresa() {
      const form = this.$refs.form;
      if (form.validate()) {
        if (this.editedIndex > -1) {
          await axios.put(`/empresa/${this.editedItem.id}`, this.editedItem);
          Object.assign(this.empresas[this.editedIndex], this.editedItem);
        } else {
          const response = await axios.post('/empresa', this.editedItem);
          this.empresas.push(response.data);
        }
        this.closeDialog();
        this.fetchEmpresas();
      }
    },
    editEmpresa(item) {
      this.editedIndex = this.empresas.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },
    async deleteEmpresa(item) {
      const index = this.empresas.indexOf(item);
      if (confirm('Você tem certeza que quer deletar esta empresa?')) {
        try {
          await axios.delete(`/empresa/${item.id}`);
          this.empresas.splice(index, 1);
        } catch (error) {
          alert('Ocorreu um erro ao tentar deletar a empresa.');
        }
      }
    },
    async fetchEmpresas() {
      const response = await axios.get('/empresa');
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

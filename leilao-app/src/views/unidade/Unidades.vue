<template>
  <v-container>
    <v-card>
      <v-card-title>
        Cadastro de Unidades
        <v-spacer></v-spacer>
      </v-card-title>

      <v-data-table
          :headers="headers"
          :items="unidades"
          item-key="id"
          class="elevation-1"
      >
        <template v-slot:top>
          <v-toolbar flat>
            <v-toolbar-title>Unidades</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="500px">
              <template v-slot:activator="{ on, attrs }">
                <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">Nova Unidade</v-btn>
              </template>

              <v-card>
                <v-card-title>
                  <span class="headline">{{ formTitle }}</span>
                </v-card-title>

                <v-card-text>
                  <v-container>
                    <v-form ref="form" v-model="valid">
                      <v-row>
                        <v-col cols="12" sm="12">
                          <v-text-field
                              v-model="editedItem.nome"
                              :rules="[v => !!v || 'Nome é obrigatório']"
                              label="Nome*"
                              required
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-form>
                  </v-container>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="closeDialog">Cancelar</v-btn>
                  <v-btn color="blue darken-1" text @click="saveUnidade">Salvar</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>

        <template v-slot:item.actions="{ item }">
          <v-icon small class="mr-2" @click="editUnidade(item)">mdi-pencil</v-icon>
          <v-icon small @click="deleteUnidade(item)">mdi-delete</v-icon>
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
        { text: 'ID', align: 'start', sortable: true, value: 'id' },
        { text: 'Nome', value: 'nome' },
        { text: 'Criado em', value: 'createdAt' },
        { text: 'Atualizado em', value: 'updatedAt' },
        { text: 'Ações', value: 'actions', sortable: false },
      ],
      unidades: [],
      editedIndex: -1,
      editedItem: {
        id: null,
        nome: '',
        createdAt: '',
        updatedAt: '',
      },
      defaultItem: {
        id: null,
        nome: '',
        createdAt: '',
        updatedAt: '',
      },
    };
  },
  computed: {
    formTitle() {
      return this.editedIndex === -1 ? 'Nova Unidade' : 'Editar Unidade';
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
    async saveUnidade() {
      const form = this.$refs.form;
      if (form.validate()) {
        if (this.editedIndex > -1) {
          await axios.put(`/unidade/${this.editedItem.id}`, this.editedItem);
          Object.assign(this.unidades[this.editedIndex], this.editedItem);
        } else {
          const response = await axios.post('/unidade', this.editedItem);
          this.unidades.push(response.data);
        }
        this.closeDialog();
        this.fetchUnidades();
      }
    },
    editUnidade(item) {
      this.editedIndex = this.unidades.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },
    async deleteUnidade(item) {
      const index = this.unidades.indexOf(item);
      if (confirm('Você tem certeza que quer deletar esta unidade?')) {
        await axios.delete(`/unidade/${item.id}`);
        this.unidades.splice(index, 1);
      }
    },
    async fetchUnidades() {
      const response = await axios.get('/unidade');
      this.unidades = response.data;
    },
  },
  created() {
    this.fetchUnidades();
  },
};
</script>

<style scoped>
</style>

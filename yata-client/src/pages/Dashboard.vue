<template>
  <v-data-table
      :headers="headers"
      :items="desserts"
      sort-by="date"
      class="elevation-1"
  >

    <template v-slot:top>
      <v-toolbar flat color="white">
        <v-text-field
            v-model="search"
            label="야타와 함께한 어느 여행을 찾으시나요?"
            single-line
            hide-details
        ></v-text-field>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                color="primary"
                dark
                class="mb-2"
                v-bind="attrs"
                v-on="on"
            >내 여행 추가 +</v-btn>
          </template>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
          small
          @click="deleteItem(item)"
      >
        mdi-delete
      </v-icon>
    </template>
    <template v-slot:no-data>
      <v-btn color="primary" @click="initialize">Reset</v-btn>
    </template>
  </v-data-table>
</template>
<script>
  export default {
    data: () => ({
      search: '',
      dialog: false,
      headers: [
        {
          text: '여행지',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        { text: '일정', value: 'date' },
        { text: '지움', value: 'actions', sortable: false },
      ],
      desserts: [],
      defaultItem: {
        name: '',
        date: 0
      },
    }),

    computed: {

    },

    watch: {
      dialog (val) {
        val || this.close()
      },
    },

    created () {
      this.initialize()
    },

    methods: {
      initialize () {
        this.desserts = [
          {
            name: '라오스 신나는 엑티비리~~~',
            date: '2020.07.11 ~ 2020.07.20'
          },
          {
            name: '뱅갈루루',
            date: '2020.08.11 ~ 2020.09.02'
          },
          {
            name: '제주도',
            date: '2020.09.30 ~ 2020.10.05'
          },
          {
            name: '김포나들이',
            date: '2020.11.01 ~ 2020.11.04'
          }
        ]
      },

      deleteItem (item) {
        const index = this.desserts.indexOf(item)
        confirm('여행을 안가실껀가요 ㅠㅠ?') && this.desserts.splice(index, 1)
      },

      close () {
        this.dialog = false
      },

      save () {
        this.close()
      },
    },
  }
</script>
<style>
</style>

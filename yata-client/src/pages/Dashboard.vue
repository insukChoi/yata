<template>
  <v-data-table
      :headers="headers"
      :items="desserts"
      sort-by="date"
      class="elevation-1"
      @click:row="handleRowClick"
  >

    <template v-slot:top>
      <v-toolbar flat color="white">
        <v-text-field
            v-model="search"
            label="야타와 함께한 어느 여행을 찾으시나요?"
            single-line
            hide-details
        ></v-text-field>

        <v-dialog
            v-model="dialog"
            persistent
            max-width="600px"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn
                color="primary"
                dark
                class="mb-2"
                v-bind="attrs"
                v-on="on"
            >내 여행 추가 +</v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">내 여행 추가</span>
            </v-card-title>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12">
                    <v-text-field
                        label="여행지"
                        name="title"
                        required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-layout row wrap>
                      <v-flex xs12 sm6>
                        <v-menu
                            ref="startMenu"
                            v-model="startMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            :return-value.sync="startDate"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                        >
                          <template v-slot:activator="{ on }">
                            <v-text-field
                                v-model="startDate"
                                label="출발일"
                                readonly
                                v-on="on"
                            ></v-text-field>
                          </template>
                          <v-date-picker v-model="startDate" no-title scrollable>
                            <v-spacer></v-spacer>
                            <v-btn flat color="primary" @click="startMenu = false">Cancel</v-btn>
                            <v-btn flat color="primary" @click="$refs.startMenu.save(startDate)">OK</v-btn>
                          </v-date-picker>
                        </v-menu>
                      </v-flex>
                      <v-spacer></v-spacer>
                      <v-flex xs12 sm6>
                        <v-menu
                            ref="endMenu"
                            v-model="endMenu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            :return-value.sync="endDate"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px"
                        >
                          <template v-slot:activator="{ on }">
                            <v-text-field
                                v-model="endDate"
                                label="도착일"
                                readonly
                                v-on="on"
                            ></v-text-field>
                          </template>
                          <v-date-picker v-model="endDate" no-title scrollable>
                            <v-spacer></v-spacer>
                            <v-btn flat color="primary" @click="endMenu = false">Cancel</v-btn>
                            <v-btn flat color="primary" @click="$refs.endMenu.save(endDate)">OK</v-btn>
                          </v-date-picker>
                        </v-menu>
                      </v-flex>
                    </v-layout>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                        label="장소"
                        name="place"
                        required
                    ></v-text-field>
                  </v-col>
                  <v-col cols="12">
                    <v-text-field
                        label="메모"
                        name="memo"
                        required
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
              <small>*새로운 여행은 언제나 설레입니다.</small>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                  color="blue darken-1"
                  text
                  @click="dialog = false"
              >
                Close
              </v-btn>
              <v-btn
                  color="blue darken-1"
                  text
                  @click="dialog = false"
              >
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
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
      startDate: new Date().toISOString().substr(0, 10),
      endDate: new Date().toISOString().substr(0, 10),
      startMenu: false,
      endMenu: false,
    }),

    computed: {

    },

    created () {
      this.initialize()
    },

    methods: {
      initialize () {
        this.$store.commit('changeViewDetail', false)
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

      handleRowClick (value) {
        console.log(value.name)
        this.$router.push({name: 'plan'});
      },

      deleteItem (item) {
        const index = this.desserts.indexOf(item)
        confirm('여행을 안가실껀가요 ㅠㅠ?') && this.desserts.splice(index, 1)
      },

    },
  }
</script>
<style>
</style>

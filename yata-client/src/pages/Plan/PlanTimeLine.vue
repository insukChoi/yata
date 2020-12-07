<template>
  <v-container style="max-width: 600px;">
    <v-timeline
        dense
        clipped
    >
      <v-timeline-item
          fill-dot
          class="white--text mb-12"
          color="#ffff"
          large
      >
        <template v-slot:icon>
          <span>YATA</span>
        </template>
        <v-text-field
            v-model="input"
            hide-details
            flat
            label="또 어디가??"
            solo
            @keydown.enter="comment"
        >
          <template v-slot:append>
            <v-btn
                class="mx-0"
                depressed
                @click="comment"
            >
              추가
            </v-btn>
          </template>
        </v-text-field>
      </v-timeline-item>

      <v-slide-x-transition
          group
      >
        <v-timeline-item
            v-for="event in timeline"
            :key="event.id"
            class="mb-4"
            color="pink"
            small
        >
          <v-row justify="space-between">
            <v-col
                cols="7"
                v-text="event.text"
            ></v-col>
            <v-col
                class="text-right"
                cols="5"
                v-text="event.time"
            ></v-col>
          </v-row>
        </v-timeline-item>
      </v-slide-x-transition>

      <v-timeline-item
          class="mb-6"
          hide-dot
      >
      </v-timeline-item>

      <v-timeline-item
          class="mb-4"
          color="grey"
          small
      >
        <v-row justify="space-between">
          <v-col cols="7">
            용바위 머리
          </v-col>
          <v-col
              class="text-right"
              cols="3"
          >
            15:25
          </v-col>
          <v-icon>
            mdi-calendar-remove
          </v-icon>
        </v-row>
      </v-timeline-item>

      <v-timeline-item
          color="grey"
          small
      >
        <v-row justify="space-between">
          <v-col cols="7">
            여수 간장게장 ㄲㄲ
          </v-col>
          <v-col
              class="text-right"
              cols="3"
          >
            19:00
          </v-col>
          <v-icon>
            mdi-calendar-remove
          </v-icon>
        </v-row>
      </v-timeline-item>
    </v-timeline>
  </v-container>
</template>

<script>
  export default {
    data: () => ({
      events: [],
      input: null,
      nonce: 0,
    }),

    computed: {
      timeline () {
        return this.events.slice().reverse()
      },
    },

    methods: {
      comment () {
        if (this.input === "" || this.input == null) return false;
        const time = (new Date()).toTimeString()
        this.events.push({
          id: this.nonce++,
          text: this.input,
          time: time.replace(/:\d{2}\sGMT-\d{4}\s\((.*)\)/, (match, contents, offset) => {
            return ` ${contents.split(' ').map(v => v.charAt(0)).join('')}`
          }),
        })

        this.input = null
      }
    },
  }
</script>
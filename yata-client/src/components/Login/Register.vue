<template>
  <v-app id="inspire" :style="cssProps">
    <v-main>
      <v-container
          class="fill-height"
          fluid
      >
        <v-row
            align="center"
            justify="center"
        >
          <v-col
              cols="12"
              sm="10"
              md="8"
          >
            <v-card class="elevation-12">
              <v-form
                  ref="form"
                  v-model="valid"
                  lazy-validation
              >
                <v-toolbar
                    color="primary"
                    dark
                    flat
                >
                  <v-toolbar-title>YATA 회원가입</v-toolbar-title>
                </v-toolbar>

                <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    label="E-mail"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="name"
                    :counter="10"
                    :rules="nameRules"
                    label="Name"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="password"
                    label="Password"
                    :rules="[v => !!v || 'Password is required']"
                    required
                ></v-text-field>

                <v-select
                    v-model="selectGender"
                    :items="gender"
                    :rules="[v => !!v || 'Gender is required']"
                    label="Gender"
                    required
                ></v-select>

                <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    transition="scale-transition"
                    offset-y
                    min-width="auto"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="birthday"
                        label="Birthday date"
                        prepend-icon="mdi-calendar"
                        :rules="[v => !!v || 'Birthday is required']"
                        required
                        readonly
                        v-bind="attrs"
                        v-on="on"
                    ></v-text-field>
                  </template>
                  <v-date-picker
                      ref="picker"
                      v-model="birthday"
                      :max="new Date().toISOString().substr(0, 10)"
                      min="1950-01-01"
                      @change="saveBirthDay"
                  ></v-date-picker>
                </v-menu>

                <v-text-field
                    v-model="phone"
                    label="Phone"
                    :rules="[v => !!v || 'phone is required']"
                    required
                ></v-text-field>

                <v-text-field
                    v-model="zipCode"
                    label="ZipCode"
                ></v-text-field>

                <v-text-field
                    v-model="address1"
                    label="Address"
                ></v-text-field>

                <v-text-field
                    v-model="address2"
                    label="Address Detail"
                ></v-text-field>

                <v-checkbox
                    v-model="checkbox"
                    :rules="[v => !!v || '야타랑 함께 해야돼~~!!!']"
                    label="야타랑 함께 할래?"
                    required
                ></v-checkbox>

                <v-btn
                    :disabled="!valid"
                    color="success"
                    class="mr-4"
                    @click="validate"
                >
                  회원가입
                </v-btn>

                <v-btn
                    color="error"
                    class="mr-4"
                    @click="reset"
                >
                  초기화
                </v-btn>
              </v-form>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    name: "register",
    data: () => ({
      valid: true,
      name: '',
      password: '',
      birthday: null,
      menu: false,
      phone: '',
      zipCode: '',
      address1: '',
      address2: '',
      cssProps: {
        backgroundImage: `url(${require('@/assets/img/loginback.jpeg')})`
      },
      nameRules: [
        v => !!v || 'Name is required',
        v => (v && v.length <= 10) || 'Name must be less than 10 characters',
      ],
      email: '',
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      selectGender: null,
      gender: [
        'GentleMan',
        'Lady'
      ],
      checkbox: false,
    }),

    methods: {
      validate() {
        if (this.$refs.form.validate()) {
          this.joinYata()
        }
      },
      reset() {
        this.$refs.form.reset()
      },
      saveBirthDay(date) {
        this.$refs.menu.save(date)
      },
      joinYata() {
        const data = {
          email: this.email,
          name: this.name,
          password: this.password,
          gender: this.selectGender,
          birthday: this.birthday,
          phone: this.phone,
          zipCode: this.zipCode,
          address1: this.address1,
          address2: this.address2
        };

        this.$Axios.post('/api/v2/auth/join', data)
            .then(res => {
              if (res.status === 201) {
                this.$toast.success("야타 회원가입 성공 >.<");
                this.$router.push({name: 'login'});
              }
            })
            .catch(function (error) {
              alert("회원가입 실패 ㅠㅠ")
            })
      }
    },

    watch: {
      menu (val) {
        val && setTimeout(() => (this.$refs.picker.activePicker = 'YEAR'))
      },
    }
  }
</script>

<style scoped>

</style>
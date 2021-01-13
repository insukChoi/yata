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
              sm="8"
              md="4"
          >
            <v-card class="elevation-12">
              <v-toolbar
                  color="primary"
                  dark
                  flat
              >
                <v-toolbar-title>YATA Login</v-toolbar-title>
                <v-spacer></v-spacer>
                <template v-slot:activator="{ on }">
                  <v-btn
                      :href="source"
                      icon
                      large
                      target="_blank"
                      v-on="on"
                  >
                    <v-icon>mdi-code-tags</v-icon>
                  </v-btn>
                </template>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field
                      label="Email"
                      name="email"
                      v-model="email"
                      prepend-icon="mdi-account"
                      type="text"
                  ></v-text-field>

                  <v-text-field
                      id="password"
                      label="Password"
                      name="password"
                      v-model="password"
                      prepend-icon="mdi-lock"
                      type="password"
                  ></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="primary" v-on:click="checkLogin">Login</v-btn>
                <v-btn color="primary" v-on:click="register">Register</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        cssProps: {
          backgroundImage: `url(${require('@/assets/img/loginback.jpeg')})`
        },
        email: '',
        password: ''
      }
    },
    props: {
      source: String,
    },
    methods: {
      checkLogin: function () {
        const _this = this;
        _this.$Axios.get('/api/v2/auth/login', {headers: {
            'X-USER-EMAIL' : _this.email,
            'X-USER-PASSWORD' : _this.password
          }}).then(res => {
            if (res.data.code === '0000') {
              _this.$toast.success("야타 로그인 성공 >.<");
              localStorage.setItem('accessToken', res.data.accessToken);
              _this.$router.push({name: 'dashboard'});
            }
        }).catch(function (error) {
          _this.$toast.error("아이디 또는 비밀번호가 틀렸습니다.")
        })

      },
      register: function () {
        this.$router.push({name: 'register'});
      }
    }
  }
</script>


<style scoped>
</style>
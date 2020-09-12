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
                      label="Login"
                      name="login"
                      prepend-icon="mdi-account"
                      type="text"
                  ></v-text-field>

                  <v-text-field
                      id="password"
                      label="Password"
                      name="password"
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
        }
      }
    },
    props: {
      source: String,
    },
    methods: {
      checkLogin: function () {
        localStorage.setItem('user', 'insuk');
        this.$router.push({name: 'dashboard'});
      },
      register: function () {
        this.$router.push({name: 'register'});
      }
    }
  }
</script>


<style scoped>
</style>
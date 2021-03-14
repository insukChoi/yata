/*!

 =========================================================
 * Vue Paper Dashboard - v2.0.0
 =========================================================

 * Product Page: http://www.creative-tim.com/product/paper-dashboard
 * Copyright 2019 Creative Tim (http://www.creative-tim.com)
 * Licensed under MIT (https://github.com/creativetimofficial/paper-dashboard/blob/master/LICENSE.md)

 =========================================================

 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 */
import Vue from "vue";
import App from "./App";
import router from "./router/index";
import vuetify from './plugins/vuetify'
import axios from 'axios'
import Toast, { POSITION } from "vue-toastification";
import "vue-toastification/dist/index.css";
import { store } from "./store";

import PaperDashboard from "./plugins/paperDashboard";

Vue.prototype.$Axios = axios

Vue.use(PaperDashboard);
Vue.use(Toast, {
  position: POSITION.TOP_RIGHT
});

new Vue({
  vuetify,
  router,
  store: store,
  render: h => h(App)
}).$mount("#app");

import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        viewDetail: false
    },
    mutations: {
        changeViewDetail: function (state, payload) {
            state.viewDetail = payload
        }
    }
});
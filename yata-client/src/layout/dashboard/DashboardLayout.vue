<template>
  <div class="wrapper">
    <side-bar>
      <template slot="links">
        <sidebar-link to="/dashboard" name="내 여행들" icon="ti-view-list-alt"/>
        <sidebar-link to="/plan" name="계획" icon="ti-map" v-if="this.$store.state.viewDetail"/>
        <sidebar-link to="/table-list" name="Table List" icon="ti-view-list-alt" v-if="this.$store.state.viewDetail"/>
        <sidebar-link to="/typography" name="Typography" icon="ti-text" v-if="this.$store.state.viewDetail"/>
        <sidebar-link to="/icons" name="Icons" icon="ti-pencil-alt2" v-if="this.$store.state.viewDetail"/>
        <sidebar-link to="/maps" name="Map" icon="ti-map" v-if="this.$store.state.viewDetail"/>
        <sidebar-link to="/notifications" name="Notifications" icon="ti-bell" v-if="this.$store.state.viewDetail"/>
      </template>
      <mobile-menu>
        <li class="nav-item">
          <a class="nav-link">
            <i class="ti-panel"></i>
            <p>Plan</p>
          </a>
        </li>
        <drop-down class="nav-item"
                   title="5 Notifications"
                   title-classes="nav-link"
                   icon="ti-bell">
          <a class="dropdown-item">Notification 1</a>
          <a class="dropdown-item">Notification 2</a>
          <a class="dropdown-item">Notification 3</a>
          <a class="dropdown-item">Notification 4</a>
          <a class="dropdown-item">Another notification</a>
        </drop-down>
        <li class="nav-item">
          <a class="nav-link">
            <i class="ti-settings"></i>
            <p>Settings</p>
          </a>
        </li>
        <li class="divider"></li>
      </mobile-menu>
    </side-bar>
    <div class="main-panel">
      <top-navbar></top-navbar>

      <dashboard-content @click.native="toggleSidebar">

      </dashboard-content>

      <content-footer></content-footer>
    </div>
  </div>
</template>
<style lang="scss">
</style>
<script>
import TopNavbar from "./TopNavbar.vue";
import ContentFooter from "./ContentFooter.vue";
import DashboardContent from "./Content.vue";
import MobileMenu from "./MobileMenu";
export default {
  data: () => ({
  }),
  components: {
    TopNavbar,
    ContentFooter,
    DashboardContent,
    MobileMenu
  },
  methods: {
    toggleSidebar() {
      if (this.$sidebar.showSidebar) {
        this.$sidebar.displaySidebar(false);
      }
    }
  }
};
</script>

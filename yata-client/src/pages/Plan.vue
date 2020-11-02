<template>
    <div class="row">
      <div class="col-xl-4 col-lg-5 col-md-6">
        <maps>

        </maps>
        <plan-time-line>

        </plan-time-line>
      </div>
      <div class="col-xl-8 col-lg-7 col-md-6">
        <edit-profile-form>

        </edit-profile-form>
      </div>
    </div>
</template>
<script>
import EditProfileForm from "./Plan/EditPlanForm.vue";
import Maps from "./Plan/Maps.vue";
import PlanTimeLine from "./Plan/PlanTimeLine.vue";
export default {
  components: {
    EditProfileForm,
    Maps,
    PlanTimeLine
  }
};
</script>
<style>
</style>

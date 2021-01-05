<template>
  <card class="card" title="Plan">
    <div>
      <form @submit.prevent>
        <div class="row">
          <div class="col-md-12">
            <fg-input type="text"
                      label="장소"
                      :disabled="true"
                      placeholder="여수"
                      v-model="plan.place">
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12">
            <fg-input type="text"
                      label="누구와"
                      placeholder="First Name"
                      v-model="plan.username">
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12">
            <fg-input type="text"
                      label="시차"
                      placeholder=""
                      v-model="plan.timeDiff">
            </fg-input>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label>메모를 적어볼래?</label>
              <textarea rows="5" class="form-control border-input"
                        placeholder="Here can be your description"
                        v-model="plan.memo">

              </textarea>
            </div>
          </div>
        </div>
        <div class="text-center">
          <p-button type="info"
                    round
                    @click.native.prevent="updatePlan">
            계획 수정
          </p-button>
        </div>
        <div class="clearfix"></div>
      </form>
    </div>
  </card>
</template>
<script>
export default {
  data() {
    return {
      plan: {
        place: "여수",
        username: "인디, 지수",
        timeDiff: "시차없음",
        memo: `메모`
      }
    };
  },
  methods: {
    updatePlan() {
      alert("Your data: " + JSON.stringify(this.user));
    }
  }
};
</script>
<style>
</style>

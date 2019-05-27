
<template>
  <div id="app">
    <event v-if="state === 0" :onclick="next"></event>
    <date v-if="state === 1" :id="id"></date>
  </div>
</template>

<script>
import Event from "./components/Event";
import Date from "./components/Date";
export default {
  data: function() {
    return {
      state: 0,
      id: null
    };
  },

  methods: {
    next: function () {
      this.state = 1
    }
  },

  components: {
    Event,
    Date
  }
};
</script>





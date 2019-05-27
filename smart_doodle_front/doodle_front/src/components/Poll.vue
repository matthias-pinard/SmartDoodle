<template>
  <id>
    <h1>{{ this.event.title }}</h1>
  </id>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      event: null
    };
  },

  mounted() {
    axios
      .get("http://148.60.11.233/polls/" + this.$route.params.id)
      .then(response => {
        this.event = response.data;
      });
  }
};
</script>

<style src="@/style/event.css">
</style>


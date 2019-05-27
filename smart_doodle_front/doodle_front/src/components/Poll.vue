<template>
  <id>
    <h1>{{ this.event.title }}</h1>
    <h2>Evénement créé par {{ this.event.guests[0].name }}</h2>
    <h3>{{ this.event.summary }}</h3>
    <p>
      Partagez le lien de la page pour inviter de nouveaux participants.
      </br>
      </br>
      <a :href="this.event.pad_link" target="_blank">Accéder au pad</a>
    </p>
  </id>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      event: null,
      url: null
    };
  },

  mounted() {
    axios
      .get("http://148.60.11.233/polls/" + this.$route.params.id)
      .then(response => {
        this.event = response.data;
      });
    this.url = location.href;
    console.log(location.href);
  }
};
</script>

<style src="@/style/event.css">
</style>


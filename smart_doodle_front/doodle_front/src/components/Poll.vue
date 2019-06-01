<template>
  <div class="contour">
    <h1>{{ event.title }}</h1>
    <h2>Evénement créé par {{ event.guests[0].name }}</h2>
    <h3>Description : {{ event.summary }}</h3>
    <h3>Lieu : {{event.place }}</h3>
    <p>
      Partagez le lien pour inviter de nouveaux participants. 
      <br>
      <br>
      <a :href="event.pad_link" target="_blank">Accéder au pad</a>
      <a :href="event.chat_link" target="_blank">Accéder au chat</a>
    </p>
    <h3>Disponibilités :</h3>
    <tableau :event="event"></tableau>
  </div>
</template>

<script>
import axios from "axios";
import tableau from "./tableau";
//import Clipboard from "v-clipboard";
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
        let slots = this.event.slots.slice();

        slots.sort((a, b) => {
          if (a.dateBegin > b.dateBegin) {
            return 1;
          } else {
            return -1;
          }
        });

        this.event.slots = slots;
        this.event = Object.assign(this.event);
      });
  },

  components: {
    tableau,
    Clipboard
  }
};
</script>

<style src="@/style/event.css">
</style>


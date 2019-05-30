<template>
  <div class="contour">
    <h1>{{ event.title }}</h1>
    <h2>Evénement créé par {{ event.guests[0].name }}</h2>
    <h3>{{ event.summary }}</h3>
    <p>
      Inviter de nouveaux participants :
      <button v-clipboard="value">Copiez le lien</button>
      <br>
      <br>
      <a :href="event.pad_link" target="_blank">Accéder au pad</a>
      <a :href="event.chat_link" target="_blank">Accéder au chat</a>
    </p>
    <p>Disponibilités :</p>
    <tableau :event="event"></tableau>
  </div>
</template>

<script>
import axios from "axios";
import tableau from "./tableau";
import Clipboard from "v-clipboard";
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


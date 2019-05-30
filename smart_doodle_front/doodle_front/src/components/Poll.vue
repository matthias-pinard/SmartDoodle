<template>
<<<<<<< HEAD
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
    
=======
  <div>
    <h1>{{ this.event.title }}</h1>
    <h2>Evénement créé par {{ this.event.guests[0].name }}</h2>
    <h3>{{ this.event.summary }}</h3>
    <p>
      Partagez le lien de la page pour inviter de nouveaux participants
      </br>
      </br>
      <a :href="this.event.pad_link" target="_blank">Accéder au pad</a>
    </p>
    <Tableau/>
>>>>>>> master
  </div>
</template>

<script>
import axios from "axios";
<<<<<<< HEAD
import tableau from "./tableau";
import Clipboard from "v-clipboard";
export default {
=======
import Tableau from './Tableau'
export default {
  components: {Tableau},
>>>>>>> master
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
<<<<<<< HEAD
  },

  components: {
    tableau,
    Clipboard
=======
    this.url = location.href;
    console.log(location.href);
>>>>>>> master
  }
};
</script>

<style src="@/style/event.css">
</style>


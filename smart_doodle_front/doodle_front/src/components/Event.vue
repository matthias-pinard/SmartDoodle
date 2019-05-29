<template>
  <div class="event">
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Créez votre événement !</h2>
    </header>

    <form @submit="submitForm">
      <p>
        <label for="title" v-if="title">Titre</label>
        <input id="title" v-model="title" type="text" name="title" placeholder="Titre" required>
      </p>

      <p>
        <label for="lieu" v-if="lieu">Lieu</label>
        <input id="lieu" v-model="lieu" type="text" name="lieu" placeholder="Lieu (facultatif)">
      </p>

      <p>
        <label for="summary" v-if="summary">Description</label>
        <input
          id="summary"
          v-model="summary"
          type="text"
          name="summary"
          placeholder="Description"
          required
        >
      </p>

      <p>
        <input type="submit" value="Continuer">
      </p>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "event",

  data() {
    return {
      title: null,
      lieu: null,
      summary: null,
      id: null
    };
  },

  methods: {
    submitForm(e) {
      e.preventDefault();
      axios
        .post("http://148.60.11.233/polls", {
          title: this.title,
          summary: this.summary,
          place: this.lieu
        })
        .then(response => {
          this.$router.push({ name: "date", params: { id: response.data.id } });
        });
    }
  }
};
</script>

<style src="@/style/event.css"></style>

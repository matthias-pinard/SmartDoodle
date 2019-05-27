<template>
  <div class="event">
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Créez votre événement </h2>
    </header>

    <form @submit="submitForm">

      <p>
        <label for="title" v-if="title">Titre</label>
        <input id="title" v-model="title" type="text" name="title" placeholder="Titre" required>
      </p>

      <p>
        <label for="lieu" v-if="lieu">Lieu</label>
        <input id="lieu" v-model="lieu" type="text" lieu="lieu" placeholder="Lieu (facultatif)">
      </p>

      <p>
        <label for="summary" v-if="summary">Description</label>
        <input id="summary" v-model="summary" type="text" summary="summary" placeholder="Description" required>
      </p>

      <p>
        <input type="submit" value="Continuer" @click="onclick">
      </p>
    </form>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      errors: [],
      title: null,
      lieu: null,
      summary: null
    }
  },

  props : {
    onclick: { type : Function }
  },

  methods: {
    submitForm (e) {
      e.preventDefault()
      axios.post('http://148.60.11.233/polls', {
        title: this.title,
        summary: this.summary
      }).then(response => {
        console.log(response)
      })
    }
  }
}
</script>

<style src="@/style/event.css"></style>

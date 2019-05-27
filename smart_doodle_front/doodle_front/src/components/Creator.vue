<template>
  <div class="event">
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Présentez-vous.</h2>
    </header>

    <form @submit="submitForm">

      <p>
        <label for="nom" v-if="nom">Nom</label>
        <input id="nom" v-model="nom" type="text" name="nom" placeholder="Votre nom" required>
      </p>

      <p>
        <label for="mail" v-if="mail">Adresse Email</label>
        <input id="mail" v-model="mail" type="text" name="mail" placeholder="Votre adresse email (facultatif)">
      </p>

      <p>
        <input type="submit" value="Continuer">
      </p>
    </form>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'createur',
  data () {
    return {
      nom: null,
      mail: null,
      id: null
    }
  },

  props : {
    onclick: { type : Function }
  },

  methods: {
    submitForm (e) {
      e.preventDefault()
      axios.post('http://148.60.11.233/polls/' + this.$route.params.id + '/guests' , {
        name: this.nom,
        mail: this.mail
      }).then(response => {
        this.$router.push({ name: 'poll', params: { id : this.$route.params.id }}
      )})
      
    }
  }
}
</script>

<style src="@/style/event.css"></style>
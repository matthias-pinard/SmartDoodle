<template>
  <div class="event">
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Description de votre événement </h2>
    </header>

    <form @submit="submitForm">

      <p>
        <label for="description" v-if="description">Description</label>
        <input id="description" v-model="description" type="text" name="description" placeholder=" saissir la discription" required>
      </p>

      <p>
        <label for="mail" v-if="mail">Votre mail</label>
        <input id="mail" v-model="mail" type="email" lieu="mail" placeholder="saissir votre mail" required>
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
      description: null,
      mail: null,
    }
  },
  props : {
    onclick: { type : Function }
  },
  methods: {
    submitForm (e) {
      e.preventDefault()
      axios.post('http://148.60.11.233/polls', {
        description: this.description,
        mail: this.mail
      }).then(response => {
        console.log(response)
      })
    }
  }
}
</script>

<style src="@/style/event.css"></style>

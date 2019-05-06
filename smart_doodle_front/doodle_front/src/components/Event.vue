<template>
  <div class="event">
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Créez votre événement !</h2>
    </header>

    <form @submit="checkForm" method="post" action="">
      <p v-if="errors.length">
        <b>Erreur(s) détectée(s) :</b>
        <ul>
          <li v-for="error in errors">{{ error }}</li>
        </ul>
      </p>

      <p>
        <label for="titre" v-if="titre">Titre</label>
        <input id="titre" v-model="titre" type="text" name="titre" placeholder="Titre">
      </p>

      <p>
        <label for="lieu" v-if="lieu">Lieu</label>
        <input id="lieu" v-model="lieu" type="text" lieu="lieu" placeholder="Lieu (facultatif)">
      </p>

      <p>
        <label for="description" v-if="description">Description</label>
        <input id="description" v-model="description" type="text" description="description" placeholder="Description (facultatif)">
      </p>

      <p>
        <input class="button button1" type="button" value="Continuer" v-if="!titre" disabled="disabled">
        <input type="submit" value="Continuer" v-if="titre">
      </p>
    </form>

  </div>
</template>

<script>
export default {
  data () {
    return {
      errors: [],
      titre: null,
      lieu: null,
      description: null
    }
  },

  methods: {
    checkForm (e) {
      if (this.titre) {
        return true
      }
      this.errors = []
      if (!this.titre) {
        this.errors.push('Titre requis.')
      }
      e.preventDefault()
    }
  }
}
</script>

<style src="@/style/event.css"></style>

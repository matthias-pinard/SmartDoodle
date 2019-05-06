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
        <label for="titre">Titre*</label>
        <input id="titre" v-model="titre" type="text" name="titre"
        >
      </p>

      <p>
        <label for="lieu">Lieu</label>
        <input id="lieu" v-model="lieu" type="text" lieu="lieu"
        >
      </p>

      <p>
        <label for="description">Description</label>
        <input id="description" v-model="description" type="text" description="description"
        >
      </p>

      <p>
        <input type="submit" value="Continuer">
      </p>
    </form>

  </div>
</template>

<script>
export default {
  data () {
    return {
      errors: [],
      titre: null
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
    },
    test () {
      alert("ok")
    }
  }
}
</script>

<style src="../style/event.css"></style>

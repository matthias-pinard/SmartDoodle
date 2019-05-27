
<template>
  <div>
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Les Membres</h2>
    </header>
    <div id="main">
      <form @submit="submitForm">
        <div v-for="i in nbMembre" :key="i"> le/Les
          <input type="email" v-model="mail[i-1]" required> 
        </div>
        <br>
        <input type="button" value="Ajouter membre" @click="addField">
        <br>
        <br>
        <input type="submit" value="Continuer">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      mail: [],
      nbMembre: 1
    }
  },
  props: {
    id: Number
  },
  methods: {
    addField() {
        this.nbMembre++
    },
    submitForm(e) {
      e.preventDefault()
      let listMembre = []
      for (let i = 0; i < this.nbMembre; i++) {
        mail:this.mail[i].toJSON(),
        listMembre.push(mails)
        Email.send({
                   To : 'them@website.com',
                   From : mails,
                   Subject : "rendez-vous",
                   Body : "And this is the body"
                  })
      }
      axios.post(`http://148.60.11.233/polls/slots/3`, listMembre)
      .then(response => {
      
      }).catch(err => {
        console.log(err)
      })
    }
  }
};
</script>

<style src="@/style/date.css"></style>

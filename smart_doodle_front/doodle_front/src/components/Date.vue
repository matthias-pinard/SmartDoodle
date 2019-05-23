<template>
  <div>
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Choisissez les dates possibles.</h2>
    </header>
    <div id="main">
      <form @submit="submitForm">
        <div v-for="i in nbDate" :key="i">
          <input type="date" v-model="jour[i]" required> De
          <input type="time" v-model="heureDebut[i]" required> à
          <input type="time" v-model="heureFin[i]">
        </div>
        <br>
        <input type="button" value="Ajouter date" @click="addField">
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
      jour: [],
      heureDebut: [],
      heureFin: [],
      nbDate: 1
    }
  },

  props: {
    id: Number
  },

  methods: {
    addField() {
        this.nbDate++
    },
    submitForm(e) {
      e.preventDefault()  
      let dateDebut = new Date(`${this.jour}T${this.heureDebut}`)
      let dateFin = new Date(`${this.jour}T${this.heureFin}`)
      console.log(dateDebut.toJSON())
      axios.post(`http://148.60.11.233/polls/slots/1`, {
        dateBegin: dateDebut.toJSON(),
        dateEnd: dateFin.toJSON()
      }).then(response => {
        console.log(response)
      })
    }
  }
};
</script>

<style src="@/style/date.css"></style>




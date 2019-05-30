<template>
  <div>
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Choisissez les dates possibles.</h2>
    </header>
    <div id="main">
      <form @submit="submitForm">
        <div v-for="i in nbDate" :key="i">
          Le
          <input type="date" v-model="jour[i-1]" required> à
          <input type="time" v-model="heureDebut[i-1]" required>
        </div>
        <br>
        <input type="button" value="Ajouter date" @click="addField">
        <input type="button" value="Supprimer date" @click="deleteField">
        <br>
        <br>
        <input type="submit" value="Continuer">
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      jour: [],
      heureDebut: [],
      nbDate: 1
    };
  },

  props: {
    id: Number
  },

  methods: {
    addField() {
      this.nbDate++;
    },
    deleteField () {
      this.nbDate--;
    },
    submitForm(e) {
      e.preventDefault();
      let listDate = [];
      for (let i = 0; i < this.nbDate; i++) {
        let tmp = new Date(`${this.jour[i]}T${this.heureDebut[i]}`).toJSON();
        let date = { dateBegin: tmp };
        listDate.push(date);
      }
      axios
        .post(
          'http://148.60.11.233/polls/' + this.$route.params.id + '/slots' ,
          listDate
        )
        .then(response => {
          this.$router.push({
            name: "creator",
            params: { id: this.$route.params.id }
          });
        });
    }
  }
};
</script>

<style src="@/style/date.css"></style>




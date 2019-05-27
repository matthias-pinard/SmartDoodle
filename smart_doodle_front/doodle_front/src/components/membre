<template>
  <id>
    <h1>Le titre de la réunion : {{ this.event.title }}</h1>
     <p>by {{this.event.nom}}</p>
     <p>Lieu : {{this.event.lieu}}</p>
     <p> la discription de la reunion : {{this.event.summary}}</p>
      <div class="container" id="tuto">
      <br>
 
      <div class="panel panel-primary" v-show="this.event.jour.length">
        <div class="panel-heading">Member</div>        
        <table class="table table-bordered table-striped">
          <thead>
          <th class="col-sm-5">membre</th>
            <tr v-for="date in this.event.jour">
             <th class="col-sm-5">{{this.event.jour}}+à+{{this.event.heureDebut}}</th>
            </tr>
          </thead>
          <tbody>
          <td>{{ this.event.nom }}</td>
            <tr v-for="date in this.event.jour">
            <td><input type="checkbox" name="nom_variable_1" ></td>
            </tr>  
          </tbody>       
        </table>
        
      </div> 

  </id>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      event: null,
      nbDate: 5
    };
  },
  mounted() {
    axios
      .get("http://148.60.11.233/polls/" + this.$route.params.id)
      .then(response => {
        this.event = response.data;
      });
  }
};
</script>

<style src="@/style/event.css">
</style>

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
            <tr v-for="date in dates.length">
             <th class="col-sm-5">{{date.jour}}+de+{{date.debut}}+à+{{date.fin}}</th>
            </tr>
          </thead>
          <tbody>
          <tr v-for="date in ">
          <tr v-for="p in participant">
          <td>{{ p.nom }}</td>
            <tr v-for="date in this.event.jour">
            <td><input type="checkbox" name="nom_variable_1" ></td>
            </tr> 
            </tr> 
          </tbody>       
        </table>
        
      </div> 

  </id>
  <p>
        <input type="submit" value="Continuer" @click="onclick">
      </p>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      event: null,
      dates: [
            {jour: "20/10/2019", debut: "9:00", fin : " 10:00"},
             {jour: "20/10/2019", debut: "11:00", fin : " 14:00"},
             {jour: "20/10/2019", debut: "20:00", fin : " 22:00"}          
          ],
          participant:[ {nom: "Durand"},            
            {nom: "Martin"},
            {nom: "Torlet"} ]
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

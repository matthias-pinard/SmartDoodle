<template>
       <table>
      <thead>
        <tr>
        <template v-for="date of dates">
           <td>{{date.jour}}+de+{{date.debut}}+à+{{date.fin}}</td>
        </template>
          </tr>
      </thead>
      <tbody repeat.for ="p of participant">
        <tr>
        <template v-for="date of dates">
        <td>
        <input type="checkbox" id="checkbox" v-model="checked" >
        </td>
        </template>
        <td >{{ p.nom }}</td>
            
        </tr>
      </tbody>
    </table>
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

<template>
  <div>
    <table>
      <thead>
        <tr>
          <td></td>
          <template>
            <td v-for="(date, index) in event.slots" :key="index">
              <FormatDate :dateString="date"></FormatDate>
            </td>
          </template>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(p, index) in event.guests" :key="index">
          <td>
            <input type="button" value="Modifier" @click="edit(p)">
            {{ p.name }}
          </td>
          <template>
            <td v-for="(date, index) in event.slots" :key="index">
              <input
                type="checkbox"
                id="checkbox"
                :disabled="isDisabled(p.name)"
                :checked="isChecked(p, date)"
                @change="updateDisponibility($event, p, date)"
              >
            </td>
          </template>
        </tr>
      </tbody>
    </table>
    <p>
      <input class="button1" type="button" value="Envoyer" @click="envoyer">
    </p>
  </div>
</template>

<script>
import axios from "axios";
import FormatDate from "./FormatDate";

export default {
  data() {
    return {
      currentUser: null,
      disponibility: {}
    };
  },
  props: {
    event
  },

  methods: {
    isDisabled(nom) {
      if (this.currentUser !== null) {
        return nom !== this.currentUser.name;
      }
      return true;
    },

    isChecked(p, date) {
      return this.disponibility[p.name][date.id];
    },

    edit(nom) {
      this.currentUser = nom;
    },
    envoyer: function() {
      let dispo = [];
      for (let i = 0; i < this.event.slots.length; i++) {
        let date = this.event.slots[i];
        dispo.push({
          slotId: date.id,
          available: this.disponibility[this.currentUser.name][date.id]
        });
      }
      let url =
        "http://148.60.11.233/polls/" +
        this.$route.params.id +
        "/disponibility/" +
        this.currentUser.id;
      axios
        .patch(url, dispo)
        .then(function(response) {
        })
        .catch(error => {
          console.log(error);
        });
    },
    updateDisponibility: function(event, people, date) {
      this.disponibility[people.name][date.id] = event.target.checked;
    }
  },

  mounted() {
    for (let i = 0; i < this.event.guests.length; i++) {
      let guest = this.event.guests[i];
      for (let j = 0; j < this.event.slots.length; j++) {
        let slot = this.event.slots[j];
        if (this.disponibility[guest.name] === undefined) {
          this.disponibility[guest.name] = {};
        }
        let available = false;
        guest.slots.forEach(s => {
          if(slot.id == s.id) {
            available = true
          }
        })
        
        this.disponibility[guest.name][slot.id] = available;
      }
    }
    this.disponibility = Object.assign({}, this.disponibility);
  },

  components: {
    FormatDate
  }
};
</script>

<style src="@/style/tableau.css">
</style>

<template>
  <div>
    <header class="header">
      <h1>Doodle++</h1>
      <h2>Choisissez les dates possibles</h2>
    </header>
      <div id="main">
          <input type="date"> De
          <input type="time"> à
          <input type="time">
          <div id="cible"></div>
          <br>
          <input type="button" value="Ajouter date" @click="addField">
      </div>
  </div>  
</template>

<script>
export default {
    methods: {
        addField () {
            document.getElementById('cible').innerHTML += '<input type="date"> De <input type="time"> à <input type="time"><br>';
        }
    }
}
</script>

<style src="@/style/date.css"></style>




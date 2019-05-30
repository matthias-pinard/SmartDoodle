<template>
  <div>
    <div class="jour">{{ `${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()}` }}</div>
    <div class="heure">{{ `${date.getHours()}:${date.getMinutes()}` }}</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      date: null
    };
  },
  props: {
    dateString: {type: Object}
  },
  mounted: function() {
    let tmp = this.dateString.dateBegin.replace('[UTC]', '')
    this.date = new Date(tmp)
  }
};
</script>

<style>
.jour,
.heure {
  text-align: center;
}

.jour {
  font-size: 15px;
}

.heure {
  font-size: 12px;
}
</style>


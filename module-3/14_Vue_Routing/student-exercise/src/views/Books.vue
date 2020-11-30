<template>
  <div>
    <div>
      <reading-list></reading-list>
    </div>
    <div>
        <router-link v-bind:to="{ name: 'create' }">Add Book to Reading List</router-link>
    </div>

    
  </div>
</template>

<script>
import ReadingList from "@/components/ReadingList.vue";
export default {
  components: {
    ReadingList,
  },
};
</script>

<style>
</style>
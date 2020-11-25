<template>
  <div class="book-container">
    <book-card v-bind:book="book" v-for="book in displayBooks" v-bind:key="book.isbn">

    </book-card>

  </div>
</template>

<script>
import BookCard from "./BookCard.vue";

export default {
    name: 'reading-list',
    components: {
      BookCard
    },
    computed: {
      displayBooks() {
        const bookList = this.$store.state.books;
        return bookList;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>
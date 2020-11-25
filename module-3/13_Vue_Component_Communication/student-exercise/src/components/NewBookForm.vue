<template>
  <form class="new-book-form" v-on:submit.prevent="addNewBook">
    <div>
      <label for="title">Title: </label>
      <input type="text" class="title-input" id="title" v-model="newBook.title" />
    </div>
    <div>
      <label for="author">Author: </label>
      <input type="text" class="author-input" id="author" v-model="newBook.author" />
    </div>
    <div>
      <label for="isbn">ISBN: </label>
      <input type="text" class="isbn-input" id="isbn" v-model="newBook.isbn" />
    </div>
    <div>
        <button type="submit">Submit Book</button>
    </div>
  </form>
</template>

<script>
export default {
    data() {
        return {
            newBook: {
                title: '',
                author: '',
                isbn: '',
                read: true
            }
        }
    },
    methods: {
        addNewBook() {
            this.$store.commit('ADD_NEW_BOOK', this.newBook);
            this.resetForm();

        },

        resetForm() {
            this.newBook = {};
        }
    }
};
</script>

<style>
</style>
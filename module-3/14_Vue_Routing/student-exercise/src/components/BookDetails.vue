<template>
<div>
    <div>
         <h2>{{ getBook.title }}</h2>
    </div>
    <div>
        <h2>{{ getBook.author }}</h2>
    </div>
    <div>
       <img v-bind:src="'http://covers.openlibrary.org/b/isbn/' + getBook.isbn + '-M.jpg'" />
    </div>
    <div>
        <p v-if="getBook.read === true">I have read this book.</p>
        <p v-else>I have not read this book.</p>
    </div>
   
</div>
  
</template>

<script>
export default {
    data() {
        return {
            currentISBN: ''
        }
    },

    computed: {
        getBook() {
            let result = null;
            for (let b of this.$store.state.books) {
                if(b.isbn === this.currentISBN){
                    result = b;
                }
            }
            return result;
        }
    },
    
    created() {
        this.currentISBN = this.$route.params.isbn;
    }

}
</script>

<style>

</style>
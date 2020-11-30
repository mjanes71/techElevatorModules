// @ts-nocheck

import Vue from 'vue';
import VueRouter from 'vue-router';

import Home from '@/views/Home.vue';
import Books from '@/views/Books.vue';
import Create from '@/views/Create.vue';
import Book from '@/views/Book.vue';

Vue.use(VueRouter);

const routes = [
  {
    path:'/',
    name:'home',
    component: Home
  },
  {
    path:'/myBooks',
    name:'books',
    component: Books
  },
  {
    path:'/addBook',
    name:'create',
    component: Create
  },
  {
    path:'/book/:isbn',
    name:'book',
    component: Book
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;

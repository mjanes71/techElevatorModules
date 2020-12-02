<template>
  <div class="messages">
    <topic-details v-bind:topic="activeTopic" />
  </div>
</template>

<script>
import TopicDetails from '@/components/TopicDetails.vue';
import TopicService from '@/services/TopicService.js';

export default {
  name: 'Messages',
  components: {
    TopicDetails
  },
  data() {
    return {
      activeTopic: {
        id: 0,
        title: '',
        messages: []
      },
    }
  },
  created(){
      TopicService.getTopic(this.$route.params.id).then(response => {
      this.activeTopic.id = response.data.id;
      this.activeTopic.title = response.data.title;
      this.activeTopic.messages = response.data.messages;
    });
  }
}
</script>

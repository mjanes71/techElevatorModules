import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },

  createMessage(myMessage){
    return http.post('/messages', myMessage);
  },

  updateMessage(myMessage){
    return http.put(`/messages/${myMessage.id}`, myMessage);
  },

  deleteMessage(id){
    return http.delete(`/messages/${id}`);
  }

}

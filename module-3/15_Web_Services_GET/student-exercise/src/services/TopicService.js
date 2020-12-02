import axios from 'axios'; //imprt axios

const http = axios.create({ //create http object
  baseURL: "http://localhost:3000" //set base url
});

export default {
    getTopics(){
        return http.get(`/topics`);
    },

    getTopic(id){
        return http.get(`/topics/${id}`);

    },

    
}
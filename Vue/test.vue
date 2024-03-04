<template>
    <button @click="getData"></button>
</template>

<script>
import axiosApi from './FrontEnd/src/services/axios'

    export default {
        data() {
            return {
                
            }
        },

        methods: {
            getData() {
                axiosApi.get('http://localhost:8080')
                .then(response => {
                    this.addUsers(response.data.list);
                })
                .catch(error => {
                    console.error(error);
                })
            }

            
        }
    }
</script>
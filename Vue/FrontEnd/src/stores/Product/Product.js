import { defineStore } from "pinia";

export const userProduct = defineStore('userProduct', {
    state() {
        return {
            userList: []
        }
    },
    actions:{
        addUsers(data) {
            this.userList.push(data);
        }  
    },
    getters: {
        getUsers(state) {

            return state.userList;
        }
    }
})

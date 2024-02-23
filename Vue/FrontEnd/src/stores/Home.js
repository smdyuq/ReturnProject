import { defineStore } from "pinia";

export const usersStore = defineStore('usersStore', {
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

            return state.userList[0];
        }
    }
})




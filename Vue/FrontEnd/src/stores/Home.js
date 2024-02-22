import { defineStore } from "pinia";

export const usersStore = defineStore('usersStore', {
    state() {
        return {
            userList: [],
            alllist: [],
            clothList: [],
            status: ''
        }
    },
    actions:{
        addUsers(data) {
            this.userList.push(data);
        },
        addCloth(data) {
            this.clothList.push(data);
        },
        addAll(data) {
            this.allList.push(data);
        },
        addStatus(data) {
            this.status = data;
        }
    },
    getters: {
        getUsers(state) {
            return state.userList[0];
        },
        getAll(state) {
            return state.allList[0];
        },
        getCloth(state) {
            return state.clothList[0];
        },
        getStatus(state) {
            return state.status;
        }
    }
})




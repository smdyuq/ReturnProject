import { defineStore } from "pinia";

export const infoListStore = defineStore('infoList', {
    state: () => ({
        pi: [],
        row: 0,
        users: [],
        type: ''
    }),
    actions: {
        addType(data) {
            this.type = data;
        },
        addUsers(data) {
            this.users = data;
        },
        addPi(data) {
            this.pi = data;
        },
        addRow(data) {
            this.row = data;
        }
    },
    getters: {
        getType(state) {
            return state.type;
        },
        getUsers(state) {
            return state.users;
        },
        getPi(state) {
            return state.pi;
        },
        getRow(state) {
            return state.row;
        }
    }
})
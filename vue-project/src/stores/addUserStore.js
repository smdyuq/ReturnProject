import { defineStore } from "pinia";

export const addUserStore = defineStore('user', {
    // state() {
    //     return {
    //         userList: []
    //     }
    // }
    state: () => ({ 
        userList: [],
        name: 'asdf'
    }),
    actions: {
        addUserList(data) {
            this.userList.push(data);
        }
    },
    getters: {
        getUser(state) {
            return state.userList;
        }
    }

})

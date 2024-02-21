import { defineStore } from "pinia";

export const parentStore = defineStore('parent', {
    state() {
        return {
            count: 0,
            name: 'Hello, Vue.js!'
        }
    },
    actions: {
        addCount() {
            //   0     =     0
            this.count++;
            this.count = this.count;
        }
    },
    getters: {
        getCount(state) {
            return state.count;
        },
        getName(state) {
            return state.name;
        }
    }
})
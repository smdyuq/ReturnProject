import { defineStore } from "pinia";

export const LikeStore = defineStore ('likeKey',{
    state() {
        return {
            likeList: []
        }
    },

    actions: {
        addLike(data) {
            this.addLike.push(data);
        }
    },

    getters: {
        getLike(state) {
            return state.likeList[0];
        }
    }

}) 
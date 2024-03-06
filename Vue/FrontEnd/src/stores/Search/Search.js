import { defineStore } from 'pinia';
import axiosApi from 'axios';

export const recentSearchesStore = defineStore('search', {
    state() {
        return {
            recentSearches: [],
            keyword: ''
        };
    },
    actions: {
        async getRecentSearches() {
            try {
                const response = await axiosApi.get('main/mainPage');
                this.recentSearches = response.data;
            } catch (error) {
                console.error(error);
            }
        },
        addKeyword(data) {
            this.keyword = data;
        }

    },

    getters: {
        getKeyword(state) {
            return state.keyword;
        }
    }

});

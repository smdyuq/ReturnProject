import { defineStore } from 'pinia';
import axiosApi from 'axios';

export const recentSearchesStore = defineStore('search', {
    state() {
        return {
            recentSearches: [],
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
    },
});

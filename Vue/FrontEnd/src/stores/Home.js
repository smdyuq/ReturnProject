import { defineStore } from "pinia";

export const usersStore = defineStore('usersStore', {
    state() {
        return {
            userList: [],
            allList: [],
            clothList: [],
            foodList: [],
            homeAppliancesList:[],
            storeList: [],
            jewelryList:[],
            status: '',
            deilvery: []
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
        addFood(data) {
            this.foodList.push(data);
        },
        addHomeAppliances(data) {
            this.homeAppliancesList.push(data);
        },
        addJewelry(data) {
            this.jewelryList.push(data);
        },
        addStatus(data) {
            this.status = data;
        },
        addStore(data) {
            this.status = data;
        },
        addDeilvery(data) {
            this.deilvery = data;
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
        getFood(state) {
            return state.foodList[0];
        },
        getHomeAppliances(state) {
            return state.homeAppliancesList[0];
        },
        getJewelry(state) {
            return state.jewelryList[0];
        },
        getStatus(state) {
            return state.status;
        },
        getStore(state) {
            return state.storeList[0];
        },
        getDeilvery(state) {
            return state.deilvery[0];
        }
            
    }
})




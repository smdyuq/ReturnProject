import { defineStore } from "pinia";

export const boardListStore = defineStore('boardList', {
    state: () => ({
        pi: [],
        row: 0,
        users: [],
        type: '',
        detail: {
            title: '',
            content: '',
            views: '',
            writer: ''
        }
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
        },
        addDetail(title, content, views, writer) {
            this.detail.title = title;
            this.detail.content = content;
            this.detail.views = views;
            this.detail.writer = writer;
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
        },
        getDetail(state) {
            return state.detail;
        }
    }
})
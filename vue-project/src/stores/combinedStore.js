import { defineStore } from "pinia";

export const combinedStore = defineStore('combined', {
    state: () => ({ 
        count: 0,
        flag: true,
        kor: '보임'
    }),
    actions: {
        combinedAddCount() {
            this.count = ++this.count;
        },
        combinedReverseFlag() {
            this.flag = !this.flag;

            if(this.flag) {
                this.kor = '보임';
            } else {
                this.kor = '안보임';
            }
        }
    },
    getters: {
        combinedGetCount() {
            return this.count;
        },
        combinedGetFlag() {
            return this.flag;
        },
        combinedGetKor() {
            return this.kor;
        }
    }

})

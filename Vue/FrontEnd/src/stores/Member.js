import { defineStore } from "pinia";

export const userStore = defineStore("userKey", {
  persist: {
    storage: sessionStorage, //쓰고싶은 스토리지(세션 또는 로컬)
  },
  state: () => {
    return {
        memberNo: -1,
        memberId: '',
        memberType: 1
    };
  },
  actions: {
    //원하는 함수
    setMemberNo(memberNo) {
        this.memberNo = memberNo;
    },
    setMemberId(memberId) {
        this.memberId = memberId;
    },
    setMemberType(memberType) {
        this.memberType = memberType;
    }
  },
  getters: {
    //원하는 getter
    getMemberNo() {
        return this.memberNo;
    },
    getMemberId() {
        return this.memberId;
    },
    getMemberType() {
        return this.memberType;
    }
  },
});

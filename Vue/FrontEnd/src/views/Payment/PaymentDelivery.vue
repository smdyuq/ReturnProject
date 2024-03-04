<template>
    <div class="paymentWrapper" v-for="(item, index) in salesList" :key="index">
        <div>
            <div @click="goPayment">
                <img class="leftArrow" src="../../assets/img/뒤로가기.png" style="width: 22px" />
            </div>
            <div>
                <div style="font-size: x-large; font-weight: bold" @click="goKakaoPayment">
                    결제하기
                </div>
                <div class="paymentWrap">
                    <div>
                        <img :src="'http://localhost:8080/resources/uploads/' + item.imageName"
                            style="width: 428px; height: 428px" />
                    </div>
                    <div class="paymentsWrap">
                        <div class="paymentContents">
                            <div class="paymentsTitle">상품가격</div>
                            <div class="paymentsTitle">상품명</div>
                            <div class="paymentsTitle">수령방법</div>
                        </div>
                        <div class="paymentContent">
                            <div>
                                <div class="paymentsDetail">{{ item.salesPrice }} 원</div>
                                <div class="paymentsDetail">{{ item.salesName }}</div>
                                <div class="paymentsDetail">택배거래</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="paymentList">
                <div style="display: flex">
                    <div>배송지 : {{ item.salesAddress }}</div>
                </div>
                <div>결제수단 : 택배거래</div>
                <div>결제금액 : {{ item.salesPrice }}원</div>
            </div>

            <div>
                <button class="paymentBtn" @click="goPaymentCompleted">결제하기</button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from 'pinia';
import { usersStore } from '../../stores/Home';
import axiosApi from '../../services/axios'

export default {
    data() {
        return {
            users: [],
            list: ''
        }
    },


    computed: {
        ...mapState(usersStore, ['getUsers']),
        salesList() {
        // userList는 getUsers를 통해 가져온 데이터입니다.
        // 여기서는 getUsers가 객체 하나를 반환하기 때문에 배열로 변환합니다.
        // 만약 getUsers가 배열을 반환한다면 따로 변환할 필요가 없습니다.
        return [this.getUsers];
        }
        
    },

    methods: {
        ...mapActions(usersStore, ['addUsers']),

        goPayment() {
            this.$router.push('/ProductDetail?salesNo=' + this.$route.query.salesNo);
        },
        goKakaoPayment() {

        },


        goPaymentCompleted() {
            this.$router.push('/paymentCompleted');
        }
    },
    beforeMount(){
        axiosApi.get('/pay/payDeliveryPage?salesNo='+this.$route.query.salesNo)
            .then(response => {
                this.addUsers(response.data.salesCheck);
            })
            .catch(error => {
                console.error(error);
            })
    }


}
</script>

<style>
.paymentWrapper {
    width: 700px;
    /* background-color: yellow; */
    flex-direction: center;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
}

.paymentWrap {
    display: flex;
}

.paymentContents {
    font-size: x-large;
    margin-left: 20px;
}

.paymentContent {
    font-size: large;
    margin-left: 20px;
}

.paymentsWrap {
    display: flex;
}

.paymentsDetail {
    width: 100%;
    height: 33%;
}

.paymentsTitle {
    width: 100%;
    height: 33%;
}

.paymentList {
    font-size: large;
}

.paymentBtn {
    background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
    display: block;
    width: 100%;
    padding: 10px;
    background-color: dimgray;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>

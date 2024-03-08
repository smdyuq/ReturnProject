<template>
    <div class="paymentWrapper" v-for="(item, index) in getUsers" :key="index">
        <div v-if="item.salesNo == this.$route.query.salesNo">
            <div class="leftArrow" @click="goPayment">
                <img class="leftArrow" src="../../assets/img/뒤로가기.png" style="width: 22px" />
            </div>
            <div>
                <div style="font-size: x-large; font-weight: bold" @click="goKakaoPayment">결제하기</div>
                <div class="paymentWrap">
                    <div style="display: flex">
                        <img :src="'http://localhost:8080/resources/uploads/' + item.imageName"
                            style="width: 121px; height: 94px" />
                        <div style=" display: flex; flex-direction: column; justify-content: center; margin-left: 25px;">
                            <div class="paymentsDetail" style="font-weight: bold; font-size: large">
                                {{ item.salesPrice }}원
                            </div>
                            <div class="paymentsDetail">{{ item.salesName }}</div>
                        </div>
                    </div>

                    <div class="line"></div>

                    <div class="paymentsWrap">
                        <div class="paymentContents">
                            <div class="paymentsTitle">거래방법</div>

                        </div>
                        <div class="paymentContent">
                            <div>
                                <div class="paymentsDetail">택배거래</div>
                            </div>
                        </div>
                    </div>

                    <div class="weightLine"></div>
                </div>
            </div>
            <div class="paymentList">
                <div class="addressWrap">
                    <div class="addressTitle">배송지</div>
                    <div class="address">{{ item.salesAddress }}</div>
                </div>
                <div class="paymentPriceWrap">
                    <div class="paymentPrice">결제금액</div>
                    <div class="price">{{ item.salesPrice }}원</div>
                </div>
            </div>

            <div>
                <button class="paymentBtn" @click="goPaymentCompleted">결제하기</button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapState, mapActions } from "pinia";
import { usersStore } from "../../stores/Home";
import axiosApi from "../../services/axios";

export default {
    data() {
        return {
            users: [],
            list: "",
        };
    },

    computed: {
        ...mapState(usersStore, ["getUsers"]),
    },

    methods: {
        ...mapActions(usersStore, ["addUsers"]),

        goPayment() {
            this.$router.push("/ProductDetail?salesNo=" + this.$route.query.salesNo);
        },
        goKakaoPayment() {


        },

        goPaymentCompleted() {
            this.$router.push("/paymentCompleted");
        },
    },
    mounted() {
        axiosApi
            .get("/pay/payDeliveryPage?salesNo=" + this.$route.query.salesNo)
            .then((response) => {
                this.addUsers(response.data.salesCheck);
            })
            .catch((error) => {
                console.error(error);
            });
    },
};
</script>

<style>
.paymentWrapper {
    width: 700px;
    flex-direction: center;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
}

.paymentContents {
    font-size: x-large;
}

.paymentsTitle {
    width: 100%;
    color: gray;
    font-size: medium;
    font-weight: bold;
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

.line {
    border: 0.5px solid #cccccc;
    margin: 25px 0;
}

.weightLine {
    border: 2px solid #cccccc;
    margin: 25px 0;
}

.leftArrow {
    margin: 12px 0;
}

.addressTitle {
    font-weight: bold;
    margin-bottom: 15px;
    margin-left: 20px;
}

.address {
    margin-left: 20px;
}

.addressWrap {
    border: 1px solid #cccccc;
    border-radius: 10px;
    height: 150px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.paymentPriceWrap {
    margin: 30px 0;
    border: 1px solid #cccccc;
    border-radius: 10px;
    height: 150px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.paymentPrice {
    font-weight: bold;
    margin-bottom: 15px;
    margin-left: 20px;
}

.price {
    margin-left: 20px;
}
</style>

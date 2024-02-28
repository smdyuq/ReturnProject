<template>
    <div class="paymentWrapper">
        <router-Link to="/ProductDetail">
            <div><img class="leftArrow" src="../../assets/img/뒤로가기.png" style="width:22px;"></div>
        </router-Link>
        <div>
            <div style="font-size: x-large; font-weight: bold;">결제하기</div>
            <div class="paymentWrap">
                <div>
                    <img src="https://via.placeholder.com/300.jpg" alt="400 * 400 size image">
                </div>
                <div class="paymentsWrap">
                    <div class="paymentContents">
                        <div class="paymentsTitle">상품가격</div>
                        <div class="paymentsTitle">상품명</div>
                        <div class="paymentsTitle">수령방법</div>
                    </div>
                    <div class="paymentContent">
                        <div class="paymentsDetail">{{ salesCheck.salesPrice }}</div>
                        <div class="paymentsDetail">{{ salesCheck.salesName }}</div>
                        <div class="paymentsDetail">{{ type }}</div>
                    </div>
                </div>
            </div>
        </div>

        <div class="paymentList">
            <div style="display:flex;">
                <div>배송지</div>
                <div>배송지 내용</div>
            </div>
            <div>결제수단</div>
            <div>결제금액</div>
        </div>

        <div>
            <button class="paymentBtn" @click="goPaymentCompleted">결제하기</button>
        </div>
    </div>
</template>

<script>
  import axiosApi from "../../services/axios";

export default {
    data() {
        return {

        }
    },
    methods: {
        goPaymentCompleted() {
            this.$router.push('/paymentCompleted');
        }
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
    font-size: large
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
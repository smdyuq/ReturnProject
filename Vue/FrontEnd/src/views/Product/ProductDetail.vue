<template>
    <HeaderVue />
    <SidebarVue />
    <div v-for="(item, index) in this.getUsers" :key="index" varStatus="status">
        <div v-if="item.salesNo == this.$route.query.salesNo">
            <div class="ProductDetailWrapper">
                <div class="productDetailWrap">
                    <div class="productImage">
                        <div><img :src="'http://localhost:8080/resources/uploads/' + item.imageName"

                                style="width: 428px; height: 428px; border: 0.5px solid #CCCCCC;"></div>

                        <!-- <img src="https://picsum.photos/428/428/?image=0" alt="sample image"> -->
                        <!-- <img :src="'http://192.168.0.4/resources/uploads/' + item.salesImageName" style="width: 194px; height: 194px;"> -->
                    </div>


                    <div class="productContents">
                        <div style="font-size:xx-large;">{{ item.salesName }} </div>
                        <div style="font-size:xx-large;">{{ item.salesPrice }} 원</div>
                        <div style="border-top:1px solid gray;"></div>

                        <div style="font-size:x-large;">
                            <div>
                                <span><svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="gray"
                                        class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1" />
                                    </svg> : {{ item.salesLikesCount }} </span>

                                <!-- <span>시간</span> -->
                            </div>
                        </div>
                        <div style="font-size:x-large;">
                            <div class="productContent">
                                <div class="productDetail">상품상태</div>
                                <div>{{ item.salesCondition }}</div>
                            </div>

                            <div class="productContent">
                                <div class="productDetail">배송비</div>
                                <div>{{ item.salesDelivery }}</div>
                            </div>
                            <div class="productContent">
                                <div class="productDetail">거래지역</div>
                                <div>{{ item.salesAddress }}</div>
                            </div>
                        </div>
                        <div class="buttonWrap">
                            <button class="likeBtn">
                                <span><svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="gray"
                                        class="bi bi-suit-heart-fill" viewBox="0 0 16 16">
                                        <path
                                            d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1" />
                                    </svg></span>
                                <span>찜</span>
                                <span>{{ item.salesLikesCount }}</span>
                            </button>

                            <button class="buyBtn" @click="showModal">바로구매</button>
                            <div v-if="isModalOpen" class="modal">
                                <div class="modal-content">
                                    <!-- <router-Link to="/"><div><img class="leftArrow" src="../../assets/img/뒤로가기.png" style="width:22px;"></div></router-Link> -->
                                    <div class="deliveryTransaction" @click="goPaymentDelivery">
                                        <div class="TransactionWrap">
                                            <div class="Transaction">택배거래</div>
                                            <div>안전하게 상품을 받을 때까지,</div>
                                            <div>리턴나라가 결제금액을 보관해요</div>
                                        </div>

                                        <div style="display:flex; align-items: center;">
                                            <img class="arrow" src="../../assets/img/화살표.png" style="width:22px;">
                                        </div>
                                    </div>

                                    <div style="border:0.5px solid gray"></div>

                                    <div class="directTransaction" @click="goPaymentDirect">
                                        <div class="TransactionWrap">
                                            <div class="Transaction">직거래</div>
                                            <div style="justify-content:center; display: flex; flex-direction: column;">
                                                직거래도 현금없이 간편하게 결제할 수 있어요
                                            </div>
                                        </div>
                                        <div style="display:flex; align-items: center;">
                                            <img class="arrow" src="../../assets/img/화살표.png" style="width:22px;">
                                        </div>
                                    </div>
                                    <!-- 모달 닫기 버튼 -->
                                    <!-- <button @click="hideModal">닫기</button> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="ProductInformation" style="margin-top:50px;">
                <div>

                    <div style="font-size:x-large; margin-top:30px; margin-left:30px; font-weight: bold;">상품정보</div>
                    <div style="margin-left: 30px; margin-top:30px;" class="productDescription">

                        <p>{{ item.salesComment }}</p>
                    </div>
                </div>


            </div>
        </div>
    </div>

    <FooterVue />
</template>

<script>
import HeaderVue from '../../components/layout/Header.vue'
import SidebarVue from '../../components/layout/Sidebar.vue'
import FooterVue from '../../components/layout/Footer.vue'
import axiosApi from 'axios';
import { mapActions, mapState } from 'pinia';
import { usersStore } from '../../stores/Home';


export default {
    components: {
        HeaderVue,
        FooterVue,
        SidebarVue
    },
    data() {
        return {
            users: [],
            list: '',
            isModalOpen: false
        };
    },
    computed: {
        ...mapState(usersStore, ['getUsers'])
    },
    methods: {
        ...mapActions(usersStore, ['addUsers']),

        getUsers() {
            axiosApi.get('/sales/detailSales')

                .then(response => {
                    this.addUsers(response.data.list);
                    console.log(response.data.list)
                })
                .catch(error => {
                    console.error(error);
                })
        },

        showModal() {
            this.isModalOpen = true;
        },
        hideModal() {
            this.isModalOpen = false;
        },
        goPaymentDelivery() {
            this.$router.push('/PaymentDelivery?salesNo=' + this.$route.query.salesNo);
        },
        goPaymentDirect() {
            this.$router.push("/PaymentDirect")
        }
    }
}

</script>

<style scoped>
.ProductDetailWrapper {
    border-top: 1px solid black;
}

.productDetailWrap {
    display: flex;
    margin-top: 50px;
}

.productContents {
    margin-left: 50px;
    width: 100%;
    height: 428px;
    flex-direction: column;
    display: flex;
    justify-content: space-between;
    /* background-color:skyblue; */
}

.buyBtn {
    background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
    color: white;
    width: 166px;
    height: 56px;
    border: none;
}

.likeBtn {
    /* background:gray; */
    color: white;
    width: 166px;
    height: 56px;
    border: none;
}

.buttonWrap {
    display: flex;
    justify-content: space-between;
}

.productContent {
    display: flex;
    font-size:16px;
}

.ProductInformation {
    width: 1024px;

    display: flex;
    border-top: 1px solid;
    margin-top: 50px;
    height: 250px;

}

.productDetail {
    color: gray;
    margin-right: 20px;
    margin-bottom: 20px;
}

.productDescription {
    margin-top: 20px;
}

.modal {
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    /* 배경 투명도 조절 */
}

.modal-content {
    background-color: white;
    padding: 20px;
    border-radius: 5px;
    width: 420px;
    height: 300px;
}

.deliveryTransaction {
    height: 50%;
    cursor: pointer;
    /* flex-direction: column; */
    display: flex;
    /* justify-content: center; */

}

.directTransaction {
    height: 50%;
    cursor: pointer;
    /* flex-direction: column; */
    display: flex;
    /* justify-content: center; */

}

.Transaction {
    margin-bottom: 10px;
    font-weight: bold;
    font-size: large;
}

.arrow {
    display: flex;
    flex-direction: center;
    justify-content: center;
}

.TransactionWrap {
    width: 92%;
    justify-content: center;
    display: flex;
    flex-direction: column;
}</style>
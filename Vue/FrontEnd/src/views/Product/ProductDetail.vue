<template>
    <HeaderVue />
    <SidebarVue />
    <div class="ProductDetailWrapper">
        <div class="productDetailWrap">
            <div class="productImage">
                <img src="https://picsum.photos/428/428/?image=0" alt="sample image">
                <!-- <img :src="'http://192.168.0.4/resources/uploads/' + item.salesImageName" style="width: 194px; height: 194px;"> -->
            </div>


            <div class="productContents">
                <div style="font-size:xx-large;">노트북 </div>
                <div style="font-size:xx-large;">500,000원</div>
                <div style="border-top:1px solid gray;"></div>
                <div>
                    <span>찜</span>
                    <span>뷰</span>
                    <span>시간</span>
                </div>

                <div class="productContent">
                    <div class="productDetail">상품상태</div>
                    <div>새상품</div>
                </div>
                <div class="productContent">
                    <div class="productDetail">교환여부</div>
                    <div>교환불가능</div>
                </div>
                <div class="productContent">
                    <div class="productDetail">배송비</div>
                    <div>배송비 별도</div>
                </div>
                <div class="productContent">
                    <div class="productDetail">거래지역</div>
                    <div>전국</div>
                </div>
                <div class="buttonWrap">
                    <button>
                        <span></span>
                        <span>찜</span>
                        <span>0</span>
                    </button>
                    <button>톡</button>
                    <button @click="showModal">바로구매</button>

                    <div v-if="isModalOpen" class="modal">
                        <div class="modal-content">
                            <!-- <router-Link to="/"><div><img class="leftArrow" src="../../assets/img/뒤로가기.png" style="width:22px;"></div></router-Link> -->
                            <div class="deliveryTransaction" @click="goPayment">
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

                            <div class="directTransaction" @click="goPayment">
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
            <div style="font-size:x-large">상품정보</div>
            <div class="productDescription">
                <p>상품 설명입니다.</p>
            </div>
        </div>

        <div>
            상점
        </div>

    </div>
    <FooterVue />
</template>

<script>
import HeaderVue from '../../components/layout/Header.vue'
import SidebarVue from '../../components/layout/Sidebar.vue'
import FooterVue from '../../components/layout/Footer.vue'
import axios from 'axios';
import { mapActions } from 'pinia';
import { usersStore } from '../../stores/Home';


export default {
    data() {
        return {
            users: [],
            isModalOpen: false
        };
    },
    mounted() {
        this.getUsers();
    },
    components: {
        HeaderVue,
        FooterVue,
        SidebarVue
    },
    methods: {
        ...mapActions(usersStore, ['addUsers']),
        getUsers() {
            axios.get('http://192.168.0.4/sales/detailSales')
                .then(response => {
                    this.addUsers(response.data.list);
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

        goPayment() {
            this.$router.push("/Payment")
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

button {
    width: 166px;
    height: 56px;
    border: none;
    background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
    color:white;
}

.buttonWrap {
    display: flex;
    justify-content: space-between;
}

.productContent {
    display: flex;
}

.ProductInformation {
    width: 1024px;
    height: 800px;
    background-color: goldenrod;
    display: flex;
}

.productDetail {
    color: gray;
    margin-right: 10px;
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

.arrow{
    display: flex;
    flex-direction: center;
    justify-content: center;
}

.TransactionWrap{
    width:92%;
    justify-content: center;
    display:flex;
    flex-direction: column;
}
</style>
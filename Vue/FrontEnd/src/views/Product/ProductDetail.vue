<template>
    <HeaderVue/>
    <SidebarVue/>
    <div class="ProductDetailWrapper" >
    <div class="productDetailWrap">
        <div class="productImage" >
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
            <div class="productDetail">상품상태</div><div>새상품</div>
        </div>
        <div class="productContent">
            <div class="productDetail">교환여부</div><div>교환불가능</div>
        </div>
        <div class="productContent">
            <div class="productDetail">배송비</div><div>배송비 별도</div>
        </div>
        <div class="productContent">
            <div class="productDetail">거래지역</div><div>전국</div>
        </div>
        <div class="buttonWrap">
            <button>
                <span></span>
                <span>찜</span>
                <span>0</span>
            </button>
            <button>톡</button>
            <button @click="toPayment()">바로구매</button>
        </div>
    </div>
</div>
</div>
    <div class="ProductInformation" style="margin-top:50px;">


            <div style="font-size:x-large">상품정보</div>
            <div>dd</div>

    </div>
<FooterVue/>
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
            users: []
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
        getUsers () {
            axios.get('http://192.168.0.4/sales/detailSales')
                .then(response => {
                    this.addUsers(response.data.list);
                })
                .catch(error => {
                    console.error(error);
                })
        },

        toPayment() {
            this.$router.push("/Payment")
        }
    }
}
</script>

<style scoped>
.ProductDetailWrapper {
    border-top:1px solid black;
}
.productDetailWrap {
    display:flex;
    margin-top:50px;
}

.productContents {
    margin-left:50px;
    width:100%;
    height:428px;
    flex-direction: column;
    display: flex;
    justify-content: space-between;
    /* background-color:skyblue; */
}

button {
    width:166px;
    height:56px;
    border:none;
}

.buttonWrap {
    display: flex;
    justify-content: space-between;
}

.productContent {
    display:flex;
}
.ProductInformation{
    width:1024px;
    height:800px;
    background-color:goldenrod;
}

.productDetail {
    color:gray;
    margin-right:10px;
    margin-bottom:20px;
}
</style>
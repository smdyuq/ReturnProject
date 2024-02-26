<template>
    <div class="saleWrapper">
        <div class="saleWrap">
            <div class="infoArticle">
                <span style="font-size: x-large">기본정보</span><span style="color: red; margin-left: 20px">*필수항목</span>
            </div>

            <div class="dividingLine"></div>

            <div class="infoTitle">
                <span class="basicInfo">상품이미지<span class="sectionSign">*</span></span>
                <!-- <div>
                    <input type="file" ref="fileInput" name="uploads" @change="handleFileChange" accept="image/jpg, image/jpeg, image/png" multiple="" />
                </div> -->

                <input id="upload" type="file" multiple/>

                <!-- <input type="text" v-model="ProductList.idx" />
                <input type="text" v-model="ProductList.title" /> -->

            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품명<span class="sectionSign">*</span></span>

                <div class="productNameWrap">
                    <input class="productName" type="search" placeholder="상품명을 입력해주세요." v-model="userProduct.salesName" />
                </div>
            </div>

            <div class="infoContent"></div>
            <div style="">
                <div class="infoTitle">
                    <span class="basicInfo">카테고리<span class="sectionSign">*</span></span>

                    <div class="infoContent">
                        <div class="category" v-for="(item, index) in radioList" :key="index">
                            <div>
                                <div>
                                    <input type="radio" :id="item.key" name="category" v-model="userProduct.salesCategory" value="가전"><label
                                    :for="item.key">가전</label>
                                </div>
                                <div>
                                    <input type="radio" :id="item.key" name="category" v-model="userProduct.salesCategory" value="의류"/><label
                                    :for="item.key">의류</label>
                                </div>
                                <div>
                                    <input type="radio" :id="item.key" name="category" v-model="userProduct.salesCategory" value="식품"/><label
                                    :for="item.key">식품</label>
                                </div>
                                <div>
                                    <input type="radio" :id="item.key" name="category" v-model="userProduct.salesCategory" value="주얼리"/><label
                                    :for="item.key">주얼리</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="infoTitle">
                <span class="basicInfo">거래지역<span class="sectionSign">*</span>
                </span>

                <div class="infoContent">
                    <input type="text" placeholder="지역을 입력해주세요." v-model="userProduct.salesAddress" />
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품상태<span class="sectionSign">*</span></span>
                <div>
                    <div>
                        <input type="radio" id="ProductStatus1" name="ProductStatus" v-model="userProduct.salesCondition" value="새상품(미사용)" /><label
                            for="ProductStatus1">새
                            상품(미사용)</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus2" name="ProductStatus" v-model="userProduct.salesCondition" value="사용감 없음"/><label
                            for="ProductStatus2">사용감
                            없음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus3" name="ProductStatus" v-model="userProduct.salesCondition" value="사용감 적음"/><label
                            for="ProductStatus3">사용감
                            적음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus4" name="ProductStatus" v-model="userProduct.salesCondition" value="사용감 많음"/><label
                            for="ProductStatus4">사용감
                            많음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus5" name="ProductStatus" v-model="userProduct.salesCondition" value="고장/파손 상품"/><label
                            for="ProductStatus5">고장/파손
                            상품</label>
                    </div>
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">가격<span class="sectionSign">*</span></span>
                <div><input type="number" v-model="userProduct.salesPrice" /><span>원</span></div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">배송비<span class="sectionSign">*</span></span>
                <div>
                    <input type="number" v-model="userProduct.salesDelivery"/><span>원</span>
                </div>
            </div>

            <div class="infoTitle">

                <span class="basicInfo">상품설명<span class="sectionSign">*</span></span>
                <textarea v-model="userProduct.salesComment"></textarea>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">수량<span class="sectionSign">*</span></span>
                <input type="number" id="count" v-model="userProduct.salesCount" /><span>개</span>
            </div>

            <div class="infoTitle">
                <span class="basicInfo" id="openChat">오픈채팅<span class="sectionSign">*</span></span>
                <input type="text" placeholder="오픈채팅" id="openChatRink" v-model="userProduct.salesChatLink" />
            </div>
        </div>
        <div>
            <button id="registerBtn" @click="registerProduct">등록하기</button>
        </div>
    </div>
</template>

<script>
import axiosApi from '../../services/axios';
import { mapActions, mapState } from 'pinia';
import { userProduct } from '../../stores/Product/Product';
import {userStore} from '../../stores/Member';

export default {
    data() {
        return {
            userProduct: {
                salesName: '',
                salesCategory: '',
                salesAddress: '',
                salesCondition: '',
                salesPrice: '',
                salesDelivery: '',
                salesComment: '',
                salesCount: '',
                salesChatLink: '',
                memberNo: ''
            },
            radioList: [
                {
                    key:'',
                    value:''
                }
            ]
        }
    },
    computed: {
        ...mapState(userProduct, ['getUsers']),

        ...mapState(userStore, ['getMemberNo'])
    },

    methods: {
        ...mapActions(userProduct, ['addUsers']),
        registerProduct() {
            const imageFile = document.getElementById('upload').files[0];
            this.userProduct.memberNo = this.getMemberNo;

            const jsonSales = JSON.stringify(this.userProduct);

            const data = new FormData();   // <form> </form>
            data.append('jsonSales', jsonSales);  // <form> <input type="hidden" name="jsonSales" value='{"salesName"}: "토마토", "sakesCategiry": "채소"' /> </form>
            data.append('upload', imageFile)

            axiosApi.post('/sales/enrollSales', data, {
                headers: {"Content-Type": 'multipart/form-data'}   // <form enctype="multipart/form-data" />
            })
                .then(response => {
                    // 등록 성공 시 처리할 로직
                    console.log(response.data);
                    alert('상품이 성공적으로 등록되었습니다.');
                    this.$router.push('/');
                })
                .catch(error => {

                    console.error(error);
                    alert('상품 등록에 실패했습니다. 다시 시도해주세요.');
                });
        }
    }
}
</script>

<style scoped>
.saleWrapper {
    height: 160vh;
}

#count {
    height: 31px;
    width: 187px;
}

.basicInfo {
    font-weight: bolder;
    font-size: large;
    width: 200px;
    height: 200px;
    /* background-color: yellow; */
}

.sectionSign {
    color: red;
}

.infoTitle {
    /* background-color: skyblue; */
    height: 200px;
    display: flex;
    width: 1024px;
}

.infoArticle {
    margin-bottom: 20px;
}

.dividingLine {
    border-top: 2px solid gray;
    margin: 30px auto;
    width: 1024px;
}

.productNameWrap {
    border: 1px solid black;
    height: 35px;
}

.productName {
    height: 33px;
    width: 750px;
    border: none;
    margin-left: 20px;
    margin-right: 20px;
    outline: none;
}

.infoContent {
    display: inline;
    /* width:1024px; */
}

textarea {
    width: 600px;
    height: 150px;
}

ul {
    padding-left: 0;
    list-style: none;
}

label {
    margin-right: 10px;
    font-size: large;
}

#openChat {
    position: relative;
}

#openChatRink {
    width: 300px;
    height: 50px;
}

#registerBtn {
    position: absolute;
    width: 150px;
    height: 50px;
    background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
    color: #fff;
    border: none;
    border-radius: 4px;
    padding: 8px;
    cursor: pointer;
    float: right;
    right: 13px;
    bottom: 100px;
}

.category {
    list-style: none;
    font-size: large;
    cursor: pointer;
}

</style>

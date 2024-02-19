<template>
    <div class="saleWrapper">
        <div class="saleWrap">
            <div class="infoArticle">
                <span style="font-size: x-large">기본정보</span><span style="color: red; margin-left: 20px">*필수항목</span>
            </div>

            <div class="dividingLine"></div>

            <div class="infoTitle">
                <span class="basicInfo">상품이미지<span class="sectionSign">*</span></span>
                <div>
                    <input type="file" accept="image/jpg, image/jpeg, image/png" multiple="" />
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품명<span class="sectionSign">*</span></span>

                <div class="productNameWrap">
                    <input class="productName" type="search" placeholder="상품명을 입력해주세요." v-model="salesName" />
                </div>
            </div>

            <div class="infoContent"></div>
            <div style="">
                <div class="infoTitle">
                    <span class="basicInfo">카테고리<span class="sectionSign">*</span></span>

                    <div class="infoContent">
                        <div class="category">
                            <div>
                                <div>
                                    <input type="radio" id="" name="category" v-model="salesCategory"><label for="">가전</label>
                                </div>
                                <div>
                                    <input type="radio" id="" name="category" v-model="salesCategory"/><label for="">의류</label>
                                </div>
                                <div>
                                    <input type="radio" id="" name="category" v-model="salesCategory"/><label for="">식품</label>
                                </div>
                                <div>
                                    <input type="radio" id="" name="category" v-model="salesCategory"/><label for="">주얼리</label>
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
                    <input type="text" placeholder="지역을 입력해주세요." v-model="salesAddress"/>
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품상태<span class="sectionSign">*</span></span>
                <div>
                    <div>
                        <input type="radio" id="ProductStatus1" name="ProductStatus" v-model="salesCondition"/><label for="ProductStatus1">새
                            상품(미사용)</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus2" name="ProductStatus" v-model="salesCondition"/><label for="ProductStatus2">사용감
                            없음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus3" name="ProductStatus" v-model="salesCondition"/><label for="ProductStatus3">사용감
                            적음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus4" name="ProductStatus" v-model="salesCondition"/><label for="ProductStatus4">사용감
                            많음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus5" name="ProductStatus" v-model="salesCondition"/><label for="ProductStatus5">고장/파손
                            상품</label>
                    </div>
                </div>
            </div>

            <!-- <div class="infoTitle">
                <span class="basicInfo">교환<span class="sectionSign">*</span></span>
                <div>
                    <div>
                        <input type="radio" id="ExchangeStatus1" name="ExchangeStatus" /><label
                            for="ExchangeStatus1">불가</label>
                    </div>
                    <div>
                        <input type="radio" id="ExchangeStatus1" name="ExchangeStatus" /><label
                            for="ExchangeStatus1">가능</label>
                    </div>
                </div>
            </div> -->

            <div class="infoTitle">
                <span class="basicInfo">가격<span class="sectionSign">*</span></span>
                <div><input type="number" v-model="salesPrice"/><span>원</span></div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">배송비<span class="sectionSign">*</span></span>
                <div>
                    <input type="radio" id="shipping1" name="ExchangeStatus" v-model="salesDelivery" /><label for="shipping1">배송비 포함</label>
                </div>
                <div>
                    <input type="radio" id="shipping1" name="ExchangeStatus" v-model="salesDelivery" /><label for="shipping1">배송비 별도</label>
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품설명<span class="sectionSign">*</span></span>
                <textarea v-model="salesComment"></textarea>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">수량<span class="sectionSign">*</span></span>
                <input type="number" id="count" v-model="salesCount"/><span>개</span>
            </div>

            <div class="infoTitle">
                <span class="basicInfo" id="openChat">오픈채팅<span class="sectionSign">*</span></span>
                <input type="text" placeholder="오픈채팅" id="openChatRink" v-model="salesChatLink"/>
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


export default {
    
    computed: {
        ...mapState(userProduct, ['getUsers'])
    },

    methods: {
        ...mapActions(userProduct, ['addUsers']),
        registerProduct() {
            // 등록할 상품 데이터
            const userProduct = {
                // 각 입력 필드에서 입력된 값을 가져와서 설정
                salesName: this.salesName,
                salesCategory: this.salesCategory,
                salesAddress: this.salesAddress,
                salesCondition: this.salesCondition,
                salesPrice : this.salesPrice,
                salesDelivery: this.salesDelivery,
                salesComment: this.salesComment,
                salesCount: this.salesCount,
                salesChatLink: this.salesChatLink

                // 나머지 필드에 대한 값들도 동일한 방식으로 설정
            };

            axiosApi.post('/sales/enrollSales', userProduct)
                .then(response => {
                    // 등록 성공 시 처리할 로직
                    console.log(response.data);
                    alert('상품이 성공적으로 등록되었습니다.');
                    this.$router.push('/ProductDetail');
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

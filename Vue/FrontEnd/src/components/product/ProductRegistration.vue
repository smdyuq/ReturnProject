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
                    <input class="productName" type="search" placeholder="상품명을 입력해주세요." />
                </div>
            </div>

            <div class="infoContent"></div>
            <div style="">
                <div class="infoTitle">
                    <span class="basicInfo">카테고리<span class="sectionSign">*</span></span>

                    <div class="infoContent">
                        <ul class="category">
                            <li>의류</li>
                            <li>주얼리</li>
                            <li>가전</li>
                            <li>식품</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="infoTitle">
                <span class="basicInfo">거래지역<span class="sectionSign">*</span>
                </span>

                <div class="infoContent">
                    <input type="text" placeholder="지역을 입력해주세요." />
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품상태<span class="sectionSign">*</span></span>
                <div>
                    <div>
                        <input type="radio" id="ProductStatus1" name="ProductStatus" /><label for="ProductStatus1">새
                            상품(미사용)</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus2" name="ProductStatus" /><label for="ProductStatus2">사용감
                            없음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus3" name="ProductStatus" /><label for="ProductStatus3">사용감
                            적음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus4" name="ProductStatus" /><label for="ProductStatus4">사용감
                            많음</label>
                    </div>
                    <div>
                        <input type="radio" id="ProductStatus5" name="ProductStatus" /><label for="ProductStatus5">고장/파손
                            상품</label>
                    </div>
                </div>
            </div>

            <div class="infoTitle">
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
            </div>

            <div class="infoTitle">
                <span class="basicInfo">가격<span class="sectionSign">*</span></span>
                <div><input type="number" /><span>원</span></div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">배송비<span class="sectionSign">*</span></span>
                <div>
                    <input type="radio" id="shipping1" name="ExchangeStatus" /><label for="shipping1">배송비 포함</label>
                </div>
                <div>
                    <input type="radio" id="shipping1" name="ExchangeStatus" /><label for="shipping1">배송비 별도</label>
                </div>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">상품설명<span class="sectionSign">*</span></span>
                <textarea></textarea>
            </div>

            <div class="infoTitle">
                <span class="basicInfo">수량<span class="sectionSign">*</span></span>
                <input type="number" id="count" /><span>개</span>
            </div>

            <div class="infoTitle">
                <span class="basicInfo" id="openChat">오픈채팅<span class="sectionSign">*</span></span>
                <input type="text" placeholder="오픈채팅" id="openChatRink" />
            </div>
        </div>
        <div>
            <button id="registerBtn">등록하기</button>
        </div>
    </div>
</template>

<script>
export default {};
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

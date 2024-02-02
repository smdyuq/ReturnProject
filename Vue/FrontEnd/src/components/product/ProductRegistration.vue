<template>
<div class="saleWrapper">
    <div class="infoArticle">
        <span style="font-size: x-large;">기본정보</span><span style="color:red;">*필수항목</span>
    </div>

    <div class="dividingLine"></div>


    <div class="infoTitle">
        <span class="basicInfo">상품이미지<span class="sectionSign">*</span></span><div><input type="file" accept="image/jpg, image/jpeg, image/png" multiple=""></div>
    </div>

    <div class="infoTitle"><span class="basicInfo">상품명<span class="sectionSign">*</span></span><input type="" placeholder="상품명을 입력해주세요."></div>
    <div class="infoContent"></div>

    <div class="infoTitle"><span class="basicInfo">카테고리<span class="sectionSign">*</span></span></div>
    <div class="infoContent">내용</div>

    <div class="infoTitle"><span class="basicInfo">거래지역<span class="sectionSign">*</span></span></div>
    <div class="infoContent">거래지역 내용</div>

    <div class="infoTitle">
    <div><span class="basicInfo">상품상태<span class="sectionSign">*</span></span></div>
    <div class="infoTitle">
        <div><input type="radio" id="ProductStatus1" name="ProductStatus"><label for="ProductStatus1">새 상품(미사용)</label></div>
        <div><input type="radio" id="ProductStatus2" name="ProductStatus"><label for="ProductStatus2">사용감 없음</label></div>
        <div><input type="radio" id="ProductStatus3" name="ProductStatus"><label for="ProductStatus3">사용감 적음</label></div>
        <div><input type="radio" id="ProductStatus4" name="ProductStatus"><label for="ProductStatus4">사용감 많음</label></div>
        <div><input type="radio" id="ProductStatus5" name="ProductStatus"><label for="ProductStatus5">고장/파손 상품</label></div>
    </div>
    </div>

    <div>

    </div>
</div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.saleWrapper {
    height:140vh;
}
    .basicInfo {   
        font-size:large;
        width:200px;
        height:200px;
        background-color: yellow;
    }
    .sectionSign {
        color:red;
    }

    .infoTitle {
        background-color: skyblue;
        width:200px;
        height:200px;
    }
.infoArticle {
    margin-bottom: 20px;
}

.dividingLine {
    border-top: 2px solid gray;
    margin: 30px auto;
    width: 1024px;
}

</style>
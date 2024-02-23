<template>
  <div class="storeWrapper">
    <div class="storeManagement">
      <div>
        <img src="../../assets/img/상점.png" width="50px" height="50px" />
      </div>
      <div id="MyStore">
        <router-link to="/ProductManagement">내 상점 관리</router-link>
      </div>
    </div>

    <div class="store">
      <div class="storeWrap">
        <div class="storeContents" id="content1">
          <span>닉네임</span>
          <button style="margin-left: 12px">상점명 수정</button>
        </div>

        <div class="storeContents" id="content2">
          <div class="storeContent">
            <div>상점 방문수</div>
            F
            <span>0</span>
          </div>
          <div class="storeContent">
            <div>상품 판매수</div>
            <span>0</span>
          </div>
        </div>

        <div class="storeContents" id="content3">
          <textarea></textarea>
          <button>확인</button>
        </div>

        <div class="storeContents" id="content4">
          <button>소개글 수정</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
textarea {
  width: 580px;
  height: 140px;
}

button {
  width: 90px;
  height: 25px;
  font-size: small;
  border: 0.5px solid gray;
}

#content3 > button {
  height: auto;
}

.storeListWrap {
  font-size: larger;
}

.storeList {
  width: 1024px;
  display: flex;
  margin-bottom: 30px;
}

.storeWrapper {
  border: 1px solid gray;
  width: 1024px;
  margin-top: 30px;
  margin-bottom: 30px;
  height: 310px;
  display: flex;
}

.storeManagement {
  width: 310px;
  height: 310px;
  text-align: center;
  flex-direction: column;
  display: flex;
  justify-content: center;
  background-color: gray;
}

.store {
  display: flex;
  margin-left: 20px;
  width: 714px;
}

.storeProduct {
  border: 0.5px solid gray;
  /* background-color:green; */
  text-align: center;
  width: 200px;
  height: 35px;
}

.storeLike {
  text-align: center;
  border: 0.5px solid gray;
  width: 200px;
  height: 35px;
  /* background-color:yellow; */
}

.storeContents {
  display: flex;
}

.storeContent {
  display: flex;
  margin-right: 12px;
}

.storeWrap {
  flex-direction: column;
  display: flex;
  width: 700px;
  justify-content: space-between;
}

#content1 {
  margin-top: 20px;
}

#content4 {
  margin-bottom: 20px;
}

/* 카드 */

.cardContainer {
  display: flex;
  margin-top: 30px;
}

.cardWrapper {
  display: flex;
  width: 1024px;
  justify-content: space-between;
  flex-wrap: wrap;
}

.cardWrap {
  display: block;
  margin-bottom: 25px;
}
</style>

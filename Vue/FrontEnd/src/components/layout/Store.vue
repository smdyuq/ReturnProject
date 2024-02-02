<template>
    <div class="storeWrapper">
      <div class="storeManagement">
        <div>
          <img src="../../assets/img/상점.png" width="50px" height="50px">
        </div>
        <div id="MyStore">
          <router-link to="/ProductManagement">내 상점 관리</router-link>
        </div>
      </div>
  
      <div class="store">
        <div class="aaa">
          <div class="storeContents" id="content1">
            User ID
            <button>상점명 수정</button>
          </div>
  
          <div class="storeContents" id="content2">
            <div>상점 방문수</div>
            <div>상품 판매수</div>
          </div>
  
          <div class="storeContents" id="content3">소개글</div>
  
          <div class="storeContents" id="content4">
            <button>소개글 수정</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'StoreManagement',
  }
  </script>
  
  <style scoped>
  .storeWrapper {
    border: 1px solid gray;
    width: 1024px;
    margin-top: 30px;
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
    background-color:gray;
  }
  
  .store {
    display: flex;
    margin-left: 20px;
    width: 714px;
    background-color:yellow;
  }
  
  .storeContents {
    display: flex;
  }
  
  .aaa {
    flex-direction: column;
    display: flex;
    display: inline-grid;
  }
  
  #content1 {
    height: 50px;
  }
  
  #content2 {
    height: 50px;
  }
  
  #content4 {
    height: 50px;
  }
  </style>
  
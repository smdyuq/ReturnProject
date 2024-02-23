<template>
  <header>
    <div class="headerWrapper">
      <div style="display: grid">
        <div class="loginSignup" style="margin-top: 0">
          <p
            style="color: gray; margin-bottom: 0; margin-right: 15px"
            v-if="isLoggedIn()"
          >
            환영합니다, {{ memberId }}님!
          </p>
          <button v-if="!isLoggedIn()" @click="goLogin()" style="color: gray">
            로그인
          </button>
          <button v-if="!isLoggedIn()" @click="goSignUp()" style="color: gray">
            회원가입
          </button>
          <button v-if="isLoggedIn()" @click="logout()" style="color: gray">
            로그아웃
          </button>
        </div>
        <div class="headerWrap">
          <router-link to="/">
            <div class="headerLogo">리턴나라</div>
          </router-link>
          <div class="searchWrapper">
            <div class="searchWrap" @click="toggleRecentSearches">
              <input
                class="search"
                type="search"
                placeholder="상품명, 지역명, @상점명 입력"
              />
              <a
                ><img
                  class="searchImg"
                  src="../../assets/img/검색.png"
                  width="16"
                  height="16"
              /></a>
            </div>
            <div class="recentSearches" style="display: none">
              <div class="recentSearche">최근검색어</div>
              <div></div>
            </div>
          </div>
          <div style="width: 300px">
            <ul class="headerList" style="color: black">
              <li @click="goSales()" class="MyList">
                <img
                  src="../../assets/img/판매.png"
                  width="30"
                  height="30"
                  style="margin-right: 5px 0px"
                />판매
              </li>

              <li @click="goStore()" class="MyList">
                <img
                  src="../../assets/img/내상점.png"
                  width="30"
                  height="30"
                  style="margin-right: 5px 0px"
                />내상점
              </li>

              <li @click="goBoard()" class="MyList">
                <img
                  src="../../assets/img/문의하기.png"
                  width="30"
                  height="30"
                  style="margin-right: 5px 0px"
                />문의
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="headerMenuWrapper">
        <div class="headerMenu" @mouseover="showMenu">
          <img src="../../assets/img/메뉴.png" width="20" height="20" />
        </div>
      </div>
      <ul class="menubars" @mouseover="showMenu" @mouseleave="hideMenu">
        <li class="menuCategory">
          <router-link to="/CategoryAll" style="color: black"
            >전체 카테고리</router-link
          >
        </li>
        <div class="line" style="border: 0.5px solid gray"></div>
        <router-link to="/CategoryHomeAppliances">
          <li>가전</li>
        </router-link>
        <router-link to="/CategoryCloth">
          <li>의류</li>
        </router-link>
        <router-link to="/CategoryFood">
          <li>식품</li>
        </router-link>
        <router-link to="/CategoryJewelry">
          <li>주얼리</li>
        </router-link>
      </ul>
    </div>
  </header>
</template>

<script>
import { mapState, mapActions } from "pinia";
import { userStore } from "../../stores/Member";

export default {
  computed: {
    ...mapState(userStore, ["getMemberId"]),
    // : computed(() => userStore.getMemberId() !== ''), // 로그인 여부 확인
  },
  methods: {
    ...mapActions(userStore, ["setMemberId"]),
    isLoggedIn() {
      return this.getMemberId !== "";
    },
    goSales() {
      if (this.getMemberId !== "") {
        this.$router.push("/SalesManagement");
      } else {
        alert("로그인이 필요합니다.");
      }
    },
    goStore() {
      if (this.getMemberId !== "") {
        this.$router.push("/StoreProduct");
      } else {
        alert("로그인이 필요합니다.");
      }
    },
    goBoard() {
      if (this.getMemberId !== "") {
        this.$router.push("/Board");
      } else {
        alert("로그인이 필요합니다.");
      }
    },

    goLogin() {
      this.$router.push("/loginPage");
    },
    goSignUp() {
      this.$router.push("/signupPage");
    },
    logout() {
      this.setMemberId("");
      this.$router.push("/");
    },
    showMenu() {
      const menu = document.querySelector(".menubars");
      menu.style.display = "block";
    },
    hideMenu() {
      const menu = document.querySelector(".menubars");
      menu.style.display = "none";
    },
    toggleRecentSearches() {
      const recentSearches = document.querySelector(".recentSearches");
      recentSearches.style.display =
        recentSearches.style.display === "block" ? "none" : "block";
    },
  },
};
</script>


<style scoped>
.loginSignup {
  /* border-bottom: 1px solid gray; */
  display: flex;
}

header {
  width: 100%;
  position: relative;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 150px;
  flex-direction: column;
  color: white;
  font-weight: bold;
  background-color: white;
}

.headerMenuWrapper {
  width: 1024px;
}

.hedaerWrapper {
  position: fixed;
  display: grid;
  top: 0;
  margin: 0;
  height: 150px;
  width: 1024px;
  z-index: 99998;

  background: white;
}

.headerLogo {
  font-size: 32px;
  font-weight: bold;
  text-align: center;
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  -webkit-background-clip: text;
  /* 웹킷 브라우저에 대한 설정 */
  background-clip: text;
  color: transparent;
}

.searchWrapper {
  width: 35rem;
  margin-left: 30px;
}

.headerWrap {
  display: flex;
  /* background-color:pink; */
  align-items: center;
  text-align: center;
  justify-content: space-between;
}

.loginSignup {
  float: right;
  display: flex;
  /* background-color:skyblue; */
  justify-content: right;
}

.headerMenu {
  text-align: left;
  width: 20px;
  height: 20px;
  /* background-color:darksalmon; */
}

.searchWrap {
  border-radius: 50px;
  border: 2px solid;
  border-image: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec) 1;
  border-image-slice: 1;
  outline: none;
  height: 39px;
}

input:focus {
  outline: none;
}

.search {
  width: 32rem;
  height: 35px;
  border: none;
  margin-left: 10px;
}

li {
  list-style: none;
}

ul {
  margin: 0;
}

.headerList {
  display: flex;
  width: 300px;
  float: right;
  color: turquoise;
  font-weight: bold;
}

button {
  border: 0;
  background-color: transparent;
}

.headerMenu:hover ~ .menubars {
  display: block;
  text-align: left;
  position: fixed;
}

.menubars {
  display: none;
  text-align: left;
  position: absolute;
  width: 16%;
  box-shadow: 0px 10px 8px 0px rgba(0, 0, 0, 0.3);
  padding: 8px;
  z-index: 999999;
  color: black;
  background-color: white;
  top: 130px;
}

.menuCategory {
  font-size: medium;
  display: flex;
  color: black;
}

.line {
  border-top: 1px solid #444444;
  margin: 10px 0px;
  width: 100%;
}
.MyList {
  font-size: medium;
  font-weight: bold;
  color: steelblue;
}

.menubars > li {
  font-size: medium;
}

li {
  margin-left: 20px;
}

/* .headerList > li {
            margin-right:2px;
        } */

a > img {
  margin-right: 5px;
}

.recentSearches {
  background-color: blue;
  display: none;
  text-align: left;
  position: absolute;
  width: 560px;
  height: 300px;
  box-shadow: 0px 10px 8px 0px rgba(0, 0, 0, 0.3);
  padding: 8px;
  z-index: 999999;
  color: black;
  background-color: white;
  top: 35px;
  border: 0.5px solid gray;
}

.recentSearche {
  text-align: center;
  font-size: large;
  font-weight: bold;
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  -webkit-background-clip: text;
  background-clip: text;
  color: transparent;
  border-bottom: 1.5px solid blue;
}

.headerList li {
  position: relative;
}

.headerList li::after {
  content: "";
  position: absolute;
  left: 0px;
  bottom: -5px;
  width: 0;
  height: 2px;
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  transition: width 0.1s ease;
}

.headerList li:hover::after {
  width: 100%;
}

li > a {
  color: cornflowerblue;
  font-size: 15px;
  font-weight: bold;
}
</style>

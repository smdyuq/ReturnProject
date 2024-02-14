<template>
  <header>
    <div class="headerWrapper">
      <div style="display:grid">
        <div class="loginSignup" style="margin-top:0;">
          <button v-if="!isLoggedIn" @click="goLogin()" style="color:gray;">로그인</button>
          <button v-if="!isLoggedIn" @click="goSignUp()" style="color:gray;">회원가입</button>
          <button v-if="isLoggedIn" @click="logout()" style="color:gray;">로그아웃</button>
        </div>
        <div class="headerWrap">
          <router-link to="/">
            <div class="headerLogo">리턴나라</div>
          </router-link>
          <div class="searchWrapper">
            <div class="searchWrap" @click="toggleRecentSearches">
              <input class="search" type="search" placeholder="상품명, 지역명, @상점명 입력">
              <a><img class="searchImg" src="../../assets/img/검색.png" width="16" height="16"></a>
            </div>
            <div class="recentSearches" style="display: none;">
              <div class="recentSearche">최근검색어</div>
              <div></div>
            </div>
          </div>
          <div style="width:300px;">
            <ul class="headerList">
              <li><router-link to="/SalesManagement"><img src="../../assets/img/판매.png" width="30" height="30" style="margin-right:5px 0px">판매</router-link></li>
              <li><router-link to="/StoreProduct"><img src="../../assets/img/내상점.png" width="30" height="30" style="margin-right:5px 0px">내상점</router-link></li>
              <li><router-link to="/Chat"><img src="../../assets/img/문의하기.png" width="30" height="30" style="margin-right:5px 0px">문의</router-link></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="headerMenuWrapper">
        <div class="headerMenu" @mouseover="showMenu">
          <img src="../../assets/img/메뉴.png" width="20" height="20">
        </div>
      </div>
      <ul class="menubars" @mouseover="showMenu" @mouseleave="hideMenu">
        <li class="menuCategory"><router-link to="/CategoryAll" style="color:black;">전체 카테고리</router-link></li>
        <div class="line" style="border: 0.5px solid gray;"></div>
        <router-link to="/CategoryCloth"><li>의류</li></router-link>
        <router-link to="/CategoryJewelry"><li>주얼리</li></router-link>
        <router-link to="/CategoryHomeAppliances"><li>가전</li></router-link>
        <router-link to="/CategoryFood"><li>식품</li></router-link>
      </ul>
    </div>
  </header>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      // 실제 로그인 상태를 확인하는 로직을 구현합니다.
      const isLoggedIn = sessionStorage.getItem('isLoggedIn');
      return isLoggedIn === 'true'; // sessionStorage에 저장된 값이 'true'인 경우에만 로그인 상태로 간주합니다.
    }
  },
  methods: {
    goLogin() {
      this.$router.push('/LoginPage');
    },
    goSignUp() {
      this.$router.push('/SignupPage');
    },
    logout() {
      // 실제 로그아웃 동작을 여기에 추가하세요
      // 로그아웃 후에는 로그인 상태를 false로 변경하거나, 세션을 삭제하는 등의 작업을 수행해야 합니다.
      // 아래는 예시로 세션을 삭제하는 방법을 보여줍니다.
      sessionStorage.removeItem('isLoggedIn'); // 세션에서 로그인 상태를 삭제합니다.
      this.$router.push('/'); // 로그아웃 후 홈 페이지로 이동합니다.
    },
    showMenu() {
      const menu = document.querySelector('.menubars');
      menu.style.display = 'block';
    },
    hideMenu() {
      const menu = document.querySelector('.menubars');
      menu.style.display = 'none';
    },
    toggleRecentSearches() {
      const recentSearches = document.querySelector('.recentSearches');
      recentSearches.style.display = recentSearches.style.display === 'block' ? 'none' : 'block';
    }
  }
}
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
}

input:focus {
    outline: none;
}

.search {
    width: 32rem;
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
    padding-left: 10px;
    width: 300px;
    float: right;
}

button {
    border: 0;
    background-color: transparent;
}

.headerMenu:hover~.menubars {
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

.menubars>li {
    font-size: medium;
}

li {
    margin-left: 20px;
}

/* .headerList > li {
            margin-right:2px;
        } */

a>img {
    margin-right: 5px;
}

.recentSearches {
    background-color:blue;
    display: none;
    text-align: left;
    position: absolute;
    width: 560px;
    height:300px;
    box-shadow: 0px 10px 8px 0px rgba(0, 0, 0, 0.3);
    padding: 8px;
    z-index: 999999;
    color: black;
    background-color: white;
    top: 35px;
    border:0.5px solid gray;
}

.recentSearche{
    text-align: center;
    font-size:large;
    font-weight:bold;
    background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
    -webkit-background-clip: text;
    /* 웹킷 브라우저에 대한 설정 */
    background-clip: text;
    color: transparent;
    border-bottom:1.5px solid blue;

}


</style>

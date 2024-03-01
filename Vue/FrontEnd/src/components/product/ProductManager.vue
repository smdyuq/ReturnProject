<template>
    <div class="productManagerWrapper">

        <div class="filter">
            <div style="border:1px solid black;">
                <input style="height:46px" type="text" v-model="searchQuery" placeholder="검색어를 입력하세요">
                <button @click="search()" style="float:right;">
                    <img class="searchImg" src="../../assets/img/검색.png" width="16" height="16">
                </button>
            </div>

            <div class="searchCondition" style="display:flex;">
                <select style="height:50px;">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="searchCondition">
                <select style="height:50px;">
                    <option>전체</option>
                    <option>판매 중</option>
                    <option>예약 중</option>
                    <option>판매완료</option>
                </select>
            </div>
        </div>



        <table>
            <thead>
                <div style="display:inline-block;">
                    <tr class="list">
                        <th>사진</th>
                        <th>판매상태</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>안전결제 환영</th>
                        <th>찜</th>
                        <th>최근수정일</th>
                        <th>기능</th>
                    </tr>
                </div>
            </thead>

            <tbody>
                <tr class="listInfo">
                    <td><img src="https://via.placeholder.com/130x150.png"></td>
                    <td>
                        <select id="select">
                            <option>판매 중</option>
                            <option>예약 중</option>
                            <option>삭제</option>
                            <option>판매완료</option>
                        </select>
                    </td>
                    <td>노스페이스 패딩</td>
                    <td>150,000원</td>
                    <td>O</td>
                    <td>12</td>
                    <td>2024-02-02</td>
                    <td>UP</td>
                </tr>

                <tr class="listInfo">
                    <td><img src="https://via.placeholder.com/130x150.png"></td>
                    <td>
                        <select id="select" style="height:50px;">
                            <option>판매 중</option>
                            <option>예약 중</option>
                            <option>삭제</option>
                            <option>판매완료</option>
                        </select>
                    </td>
                    <td>노스페이스 패딩</td>
                    <td>150,000원</td>
                    <td>O</td>
                    <td>12</td>
                    <td>2024-02-02</td>
                    <td>UP</td>
                </tr>

                <tr class="listInfo">
                    <td><img src="https://via.placeholder.com/130x150.png"></td>
                    <td>
                        <select id="select">
                            <option>판매 중</option>
                            <option>예약 중</option>
                            <option>삭제</option>
                            <option>판매완료</option>
                        </select>
                    </td>
                    <td>노스페이스 패딩</td>
                    <td>150,000원</td>
                    <td>O</td>
                    <td>12</td>
                    <td>2024-02-02</td>
                    <td>UP</td>
                </tr>



                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>
            </tbody>

        </table>




    </div>
</template>

<script>
export default {
    data() {
        return {
            searchQuery: ''
        }
    },
    methods: {
        search() {
            // 검색 기능 구현
            console.log('검색어:', this.searchQuery);
        }
    }
}
</script>


<style scoped>
.productManagerWrapper {
    width: 1024px;
}

button {
    background-color: transparent;
    border: none;
    cursor: pointer;
}

.list {
    display: flex;
    width: 1024px;
    justify-content: space-around;
    font-size: larger;
    font-weight: 500;
    border-top: 1px solid black;
    border-bottom: 1px solid black;
    text-align: center;
    vertical-align: middle;

}

.filter {
    display: flex;
    font-size: large;
    margin: 2.5rem 0px 2rem;
    width: 1024px;
    height: 50px;
}

.listInfo {
    display: flex;
    justify-content: space-between;
    font-size: large;
    width: 1024px;
    height: 180px;
    text-align: center;
    align-items: center;
    border-bottom: 1px solid gray;

}

table {
    text-align: center;
}

.list>th {
    margin-left: 20px;
}

.listInfo>td {
    margin-right: 25px;
}

.listInfo>img {
    margin-left: 0px;
}

#select {
    width: 90px;
    height: 50px;

}

input:focus {
    outline: none;
}

input {
    border: none;
    height: 46px;
    margin-left: 20px;
    margin-right: 20px;
}

div>button {
    height: 46px;
}

.searchCondition {
    margin-left: 20px;
}</style>
<template>
    <Header-vue v-bind:queryData="queryData" />
    <Sidebar-vue />
    {{ queryData }}
    <CategoryAll-Vue />
    <!-- <CardWrapper-Vue/> -->
    <div class="품목들">
        <div class="품목" v-for=" data of datas2">
            <div class="상품 no"> {{ data.salesNo }} </div>
            <div class="name"> {{ data.salesName }} </div>
            <div class="cate"> {{ data.salesCategory }} </div>
        </div>
    </div>
    <Footer-Vue />
</template>

<script>
import HeaderVue from '../components/layout/Header.vue';
import FooterVue from '../components/layout/Footer.vue';
import SlideVue from '../components/layout/Slide.vue';
// import CardWrapperVue from '../components/layout/CardWrapper.vue';
import SidebarVue from '../components/layout/Sidebar.vue';
import CategoryAllVue from '../components/Category/CategoryAll.vue';
import axios from '../services/axios';



export default {
    components: {
        HeaderVue,
        SlideVue,
        FooterVue,
        // CardWrapperVue,
        SidebarVue,
        CategoryAllVue
    },

    data() {
        return {
            main: {
                searchWord: ''
            }

        }
    },


    mounted() {
        // const route = useRoute();
        // const queryData = ref('');
        // queryData.value = route.query.keyword;

        // const datas = [
        //     { "salesNo": 58, "salesName": "링 목걸이", "salesCategory": "주얼리", "salesAddress": "경기도 수원시", "salesCondition": "새상품(미사용)", "salesPrice": 320000, "salesDelivery": 3000, "salesComment": "링 목걸이 팔아요", "salesCount": 1, "salesDate": "3월 1, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240301141954_UhJXGftM.jpg" },
        //     { "salesNo": 57, "salesName": "링 육포", "salesCategory": "식품", "salesAddress": "경기도 안양시", "salesCondition": "새상품(미사용)", "salesPrice": 12000, "salesDelivery": 2500, "salesComment": "육포 새거 많이 팔아요 수량 말씀해주세요~", "salesCount": 100, "salesDate": "3월 1, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240301141846_agKINndt.jpg" },
        //     { "salesNo": 56, "salesName": "링 카스타드", "salesCategory": "식품", "salesAddress": "서울 강남", "salesCondition": "새상품(미사용)", "salesPrice": 5000, "salesDelivery": 1500, "salesComment": "카스타드 빵 팔아요", "salesCount": 1, "salesDate": "3월 1, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240301141222_HCmiARGf.jpg" },
        //     { "salesNo": 55, "salesName": "다이슨 헤어드라이기", "salesCategory": "가전", "salesAddress": "경기도 하남시", "salesCondition": "사용감 없음", "salesPrice": 700000, "salesDelivery": 3000, "salesComment": "다이슨 헤어드라이기 입니다\n사용한지 일주일정도 밖에 안 됐어요", "salesCount": 1, "salesDate": "3월 1, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240301141123_vTPbYMqr.jpg" }, { "salesNo": 54, "salesName": "아이패드", "salesCategory": "가전", "salesAddress": "경기도 군포", "salesCondition": "사용감 적음", "salesPrice": 500000, "salesDelivery": 3000, "salesComment": "사용감 적은 아이패드 팝니다.", "salesCount": 1, "salesDate": "3월 1, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240301140924_vpRpowNp.jpg" }, { "salesNo": 53, "salesName": "팔찌", "salesCategory": "주얼리", "salesAddress": "경기도 수원시", "salesCondition": "사용감 많음", "salesPrice": 150000, "salesDelivery": 3000, "salesComment": "14k 금팔찌입니다\n착용횟수가 많아 좀 저렴하게 판매해봅니다", "salesCount": 1, "salesDate": "2월 27, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240227204329_nBTCCziL.jpg" }, { "salesNo": 52, "salesName": "다이아반지", "salesCategory": "주얼리", "salesAddress": "전라북도 군산", "salesCondition": "사용감 적음", "salesPrice": 900000, "salesDelivery": 3000, "salesComment": "다이아반지이고 , 몇번 착용 안 했습니다\n직거래는 전라북도 군산입니다", "salesCount": 1, "salesDate": "2월 27, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240227204250_SbXDSymZ.jpg" }, { "salesNo": 51, "salesName": "전동킥보드", "salesCategory": "가전", "salesAddress": "인천", "salesCondition": "사용감 적음", "salesPrice": 800000, "salesDelivery": 5000, "salesComment": "전동킥보드 팔아요\n직접 가지러 오셔야 합니다.", "salesCount": 1, "salesDate": "2월 27, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240227204202_xIFhsZOH.jpg" }, { "salesNo": 50, "salesName": "프로틴", "salesCategory": "식품", "salesAddress": "경기도 안양", "salesCondition": "사용감 적음", "salesPrice": 25000, "salesDelivery": 3000, "salesComment": "한입 먹은 프로틴 팝니다\n직거래는 안양역에서 합니다", "salesCount": 1, "salesDate": "2월 27, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240227204053_flgbwCyp.jpg" }, { "salesNo": 49, "salesName": "가죽점퍼", "salesCategory": "의류", "salesAddress": "경기도 의왕시", "salesCondition": "새상품(미사용)", "salesPrice": 300000, "salesDelivery": 3000, "salesComment": "가죽점퍼 판매합니다\n직거래 의왕역", "salesCount": 1, "salesDate": "2월 27, 2024", "salesComplete": 0, "memberNo": 1, "salesChatLink": "오픈채팅", "salesLikesCount": 0, "searchText": "", "searchWord": "", "imageNo": 0, "imageName": "240227203941_wVQpOIsL.jpg" }
        // ];

        // const datas2 = [];

        // datas.forEach((data)=> {
        //     if(data.salesName.indexOf(queryData.value) !== -1) datas2.push(data);
        // })


        // console.log(datas2);
            this.main.searchWord = this.$route.query.keyword;

        axios.post('/main/search',this.main)
            .then(response => {
                console.log(response)

            })

            .catch(error => {

            })

        // return {
        //     queryData,
        //     datas,
        //     datas2,
        // }
    },
}
</script>
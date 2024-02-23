<template>
    <div class="cardContainer">
        <div class="cardWrapper">

            <div class="cardWrap" v-for="(item, index) in list" :key="index" @click="goDetail(item.salesNo)">
                <div class="imgWrapper">
                    <div><img :src="'http://192.168.0.16/resources/uploads/' + item.imageName" style="width: 194px; height: 194px;"></div>
                </div>


                <div>
                    <div><router-link to="/productDetail">{{ item.salesName }}</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">{{ item.salesPrice }}원</router-link></span>
                        <span><router-link to="/productDetail">{{ item.salesDate }}</router-link></span>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>


<script>
import axiosApi from '../../services/axios';
import { mapActions, mapState } from 'pinia';
import { usersStore } from '../../stores/Home'
import { userStore } from '../../stores/Member'

export default {
    data() {
        return {
            list: '',
            menu: ''
        }
    },
    computed: {
        ...mapState(usersStore, ['getUsers', 'getStatus','getAll','getCloth', 'getFood','getCategoryHomeAppliances','getJewelry']),
        ...mapState(userStore, ['getMemberNo'])
    },
    mounted() {
        this.printList();
    },
    methods: {
        ...mapActions(usersStore, ['addStatus','addAll','addCloth','addFood','addHomeAppliances','addJewelry']),
        
        printList() {

            if (this.$route.path == '/CategoryAll' ) {
                this.addStatus('전체');

            } else if (this.$route.path == '/CategoryCloth') {
                this.addStatus('의류');

            } else if (this.$route.path == '/CategoryFood') {
                this.addStatus("식품");

            } else if (this.$route.path == '/CategoryHomeAppliances') {
                this.addStatus("가전");

            } else if (this.$route.path == '/CategoryJewelry') {
                this.addStatus("주얼리");

            } else if (this.$route.path == '/') {

                this.addStatus("전체","의류","식품","가전","주얼리")
            } else if(this.$route.path == '/StoreProduct') {
                this.menu = "sales";
            }

            if(this.$route.path == '/StoreProduct') {
                axiosApi.get('/member/storeForm?memberNo='+this.getMemberNo+"&menu="+this.menu) 
                .then(response => {
                    
                })
                .catch(error => {
                    
                })
            }

            axiosApi.get('/main/categorySales?salesCategory='+this.getStatus)
            .then(response => {

                if(this.getStatus == '전체') {
                    this.addAll(response.data.list);

                } else if(this.getStatus == '의류') {
                    this.addCloth(response.data.list);
                    
                } else if(this.getStatus == '식품') {
                    this.addFood(response.data.list);

                } else if(this.getStatus == '가전') {
                    this.addHomeAppliances(response.data.list);

                } else if(this.getStatus == '주얼리') {
                    this.addJewelry(response.data.list);

                } else if(this.getStatus == '전체' , '의류' , '식품' , '가전' , '주얼리') {
                    this.addAll(response.data.list);
                }

                this.list = response.data.list;
            })
            .catch(error => {
                console.error(error);
            });
        },
        goDetail(salesNo) {
            this.$router.push('ProductDetail?salesNo='+salesNo);
        },
        
    }
}
</script>

<style scoped>
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
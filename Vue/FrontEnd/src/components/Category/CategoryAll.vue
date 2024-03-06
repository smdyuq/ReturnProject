<template>
    <div>
        <div>
            <span>홈 > </span>
            <select v-model="selectedCategory" @change="handleCategoryChange">
                <option>전체</option>
                <option>의류</option>
                <option>주얼리</option>
                <option>가전</option>
                <option>식품</option>
            </select>
        </div>
        <div>
            
            <div class="categoryBar">

                <div @click="goAll" class="category">전체</div>
                <div @click="goCloth" class="category">의류</div>
                <div @click="goJewelry" class="category">주얼리</div>
                <div @click="goHomeAppliances" class="category">가전</div>
                <div @click="goFood" class="category">식품</div>



                <!-- <router-link :to="{ path: '/CategoryAll?keyword='+this.getKeyword }" class="category">전체</router-link>
                <router-link :to="{ path: '/CategoryCloth?keyword='+this.getKeyword }" class="category">의류</router-link>
                <router-link :to="{ path: '/CategoryJewelry?keyword='+this.getKeyword }" class="category">주얼리</router-link>
                <router-link :to="{ path: '/CategoryHomeAppliances?keyword='+this.getKeyword }" class="category">가전</router-link>
                <router-link :to="{ path: '/CategoryFood?keyword='+this.getKeyword }" class="category">식품</router-link> -->
            </div>
           
        </div>
        <div class="cardWrapper">
            <div class="cardWrap" v-for="(item, index) in getUsers" :key="index">
                <div class="imgWrapper">
                    <router-link :to="{ path: `/productDetail/${item.id}` }">
                        <img :src="'http://192.168.0.4/resources/uploads/' + item.salesImageName" style="width: 194px; height: 194px;">
                    </router-link>
                </div>
                <div>
                    <div>
                        <router-link :to="{ path: `/productDetail/${item.id}` }">{{ item.salesName }}</router-link>
                    </div>
                    <div>
                        <span>{{ item.salesPrice }}원</span>
                        <span>{{ item.salesDate }}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { defineComponent } from 'vue';
import { recentSearchesStore } from '@/stores/Search/Search';
import { mapActions, mapState } from 'pinia';


export default defineComponent({
    data() {
        return {
            selectedCategory: ''
        };
    },
    computed: {
        ...mapState(recentSearchesStore , ['getKeyword'])
    },
    methods: {
        ...mapActions(recentSearchesStore, ['addKeyword']),
        handleCategoryChange() {
            switch (this.selectedCategory) {
            case '의류':
                this.$router.push({name: 'CategoryCloth', query: {keyword: this.$route.query.keyword}});
                break;
            case '주얼리':
                this.$router.push({name: 'CategoryJewelry', query: {keyword: this.$route.query.keyword}});
                break;
            case '가전':
                this.$router.push({name: 'CategoryHomeAppliances', query: {keyword: this.$route.query.keyword}});
                break;
            case '식품':
                this.$router.push({name: 'CategoryFood', query: {keyword: this.$route.query.keyword}});
                break;
            default:
                this.$router.push({name: 'CategoryAll', query: {keyword: this.$route.query.keyword}});
                break;
            }
        },

        goAll() {
            this.$router.push({name: 'CategoryAll', query: {keyword: this.$route.query.keyword}});
        },
        goHomeAppliances() {
            this.$router.push({name: 'CategoryHomeAppliances', query: {keyword: this.$route.query.keyword}});
        },
        goFood() {
            this.$router.push({name: 'CategoryFood', query: {keyword: this.$route.query.keyword}});
        },
        goJewelry() {
            this.$router.push({name: 'CategoryJewelry', query: {keyword: this.$route.query.keyword}});
        },
        goCloth() {
            this.$router.push({name: 'CategoryCloth', query: {keyword: this.$route.query.keyword}});
        }


    },
    mounted() {
        if(this.getKeyword === undefined) {
            this.addKeyword("");
        }

        switch (this.$route.path) {
            case '/CategoryCloth':
                this.selectedCategory = '의류';
                break;
            case '/CategoryJewelry':
                this.selectedCategory = '주얼리';
                break;
            case '/CategoryHomeAppliances':
                this.selectedCategory = '가전';
                break;
            case '/CategoryFood':
                this.selectedCategory = '식품';
                break;
            default:
                this.selectedCategory = '전체';
                break;
        }

        
    }
});
</script>

<style scoped>
.categoryBar {
    display: flex;
    justify-content: space-between;
    border: 0.5px solid gray;
    height: 60px;
    margin-top: 4%;
    margin-bottom: 4%;
    cursor: pointer;
}

.category {
    display: flex;
    justify-content: center;
    flex-direction: column;
    border: 0.5px solid gray;
    width: 20%;
    text-align: center;
}
</style>

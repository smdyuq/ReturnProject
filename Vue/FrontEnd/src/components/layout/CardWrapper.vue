<template>
    <div class="cardContainer">




        <div class="cardWrapper">

            <!-- <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div>

            <div class="cardWrap">
                <div class="imgWrapper">
                    <div><router-link to="/productDetail"><img src="https://via.placeholder.com/194.jpg"
                                alt="194 * 194 size image"></router-link></div>
                </div>
                <div>
                    <div><router-link to="/productDetail">상품판매 제목입니다.</router-link></div>
                    <div>
                        <span><router-link to="/productDetail">상품가격</router-link></span>
                        <span><router-link to="/productDetail">업데이트 시간</router-link></span>
                    </div>
                </div>
            </div> -->

            










<!-- 데이터-->
            <div class="cardWrapper">
                <div class="cardWrap" v-for="(item, index) in getUsers" :key="index">
                    <div class="imgWrapper">
                        <div><router-link to="/productDetail"><img
                                    :src="'http://192.168.0.24/resources/uploads/' + item.imageName"
                                    style="width: 194px; height: 194px;"></router-link></div>
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
    </div>
</template>


<script>
import { mapState } from 'pinia'
import { usersStore } from '../../stores/Home'

export default {
    computed: {
        ...mapState(usersStore, ['getUsers'])
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

}</style>
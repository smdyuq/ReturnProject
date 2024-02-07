<template>
<div class="cardContainer">
    <div class="cardWrapper">
        <div class="cardWrap" v-for="(item, index) in getUsers" :key="index">
            <div class="imgWrapper" >
            <div><router-link to="/productDetail"><img :src="'http://192.168.0.4/resources/uploads/' + item.salesImageName" style="width: 194px; height: 194px;"></router-link></div>
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
    import {mapState} from 'pinia'
    import {usersStore} from '../../stores/Home'

export default {
    computed: {
        ...mapState(usersStore , ['getUsers'])
    }
}
</script>

<style scoped>
    .cardWrapper {
        display:flex;
        width:1024px;
        justify-content: space-between;
        flex-wrap: wrap;     
    }
    .cardWrap {
        display:block;
        margin-bottom:25px;

        }
</style>
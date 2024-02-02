<template>
    <div>
        <div>
            <span>홈 > </span> 
            <select>
                <option>의류</option>
                <option>주얼리</option>
                <option>가전</option>
                <option>식품</option>
            </select>
        </div>
        <div>
            <div class="categoryBar">
                <div class="category">전체</div>
                <div class="category">의류</div>
                <div class="category">주얼리</div>
                <div class="category">가전</div>
                <div class="category">식품</div>
            </div>
            
        </div>
        <div></div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.categoryBar {
    display:flex;
    justify-content: space-between;
    border:0.5px solid gray;
    height: 60px;
    margin-top:4%;
    margin-bottom:4%;

}

.category {
    
    display:flex;
    justify-content: center;
    flex-direction: column;
    border:0.5px solid gray;
    width:20%;
    text-align: center;
}
</style>
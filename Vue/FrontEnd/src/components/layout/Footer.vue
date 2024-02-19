<template>
    <footer>
        <div class="footerWrapper">
            <div class="footerWrap">
                <div>(주)리턴</div>
                <div>대표자 : 리턴</div>
                <div>사업자 등록번호 : ***-**-*****</div>
                <div>주소 : 경기도 안양시</div>
                <div>전화 : 1004-1004</div>
                <div>고객문의</div>
                <div></div>
            </div>
            <div class="footerIcon">
                <img src="../../assets/img/인스타그램.png" width="30" height="30">
                <img src="../../assets/img/페이스북.png" width="30" height="30">
                <img src="../../assets/img/트위터.png" width="30" height="30">
                <img src="../../assets/img/깃허브.png" width="30" height="30">
            </div>
        </div>
    </footer>
</template>

<style scoped>
    .footerIcon>img {
        margin-right:2%;
        margin-top: 5%;
    }
    Footer {
     
        left: 0;
        bottom:0;
        right:0;
        height: 12rem;
        width: 100%;

        
    }

    .footerWrapper {
        text-align: center;
        display:flex;
    
    } 
    .footerWrap{
        width:50%;
        text-align: left;
        bottom:0;
        margin-top: 2%;
        
    }
    .footerIcon {
        justify-content: right;
        width:50%;
        display:flex;
    }
    
</style>



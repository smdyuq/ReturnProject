<template>
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <router-link to="/Event1"><img src="../../assets/img/배너이미지1.jpg" min-width="1024px" height="300px" class="d-block w-100" alt="..."></router-link>
    </div>
    <div class="carousel-item">
      <router-link to="/Event2"><img src="../../assets/img/배너2.jpg" min-width="1024px" height="300px" class="d-block w-100" alt="..."></router-link>
    </div>
    <div class="carousel-item">
      <router-link to="/Event3"><img src="../../assets/img/배너3.jpg" width="1024px" height="300px" class="d-block w-100" alt="..."></router-link>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</template>

<script>
export default {

    }

</script>

<style scoped>
#carousel-control-prev {
  width:20%;
}

#carouselExampleAutoplaying{
    margin-bottom:20px;
    text-align: -webkit-center;
}

 .carousel-inner {
    /* min-width:1279px;
    max-width:1280px; */

        width:1024px;
        height:300px;
        position:relative;
        
 }

 .carousel-item {
    width:100%;
    height:100%;
 }
</style>
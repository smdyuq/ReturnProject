<template>
  <body>
    <calc-header-vue></calc-header-vue>
    <div>
      <p>{{ calcType }}</p>
      <input type="text" v-model="calc" />
      <button @click="calcCheck">버튼</button>
      <hr />
      <input type="number" v-model="num1" /> {{calcTypeicon}}
       <input type="number" v-model="num2" />
      <button @click="calcResult">계산</button>

      <p>{{ result }}</p>

      <p></p>
    </div>
  </body>
</template>

<script>
import calcHeaderVue from "../components/calcHeader.vue";

export default {
  components: {
    calcHeaderVue,
  },
  data() {
    return {
      calc: null,
      num1: 0,
      num2: 0,
      result: null,
      calcType: "",
      calcTypeicon : "",
    };
  },
  methods: {
    calcCheck: function () {
      if (this.calc === "더하기") {
        this.calcType = "덧셈";
        this.calcTypeicon = "+";
      } else {
        this.calcType = "곱셈";
        this.calcTypeicon = "x";
      }
    },
    calcResult: function () {
        if(this.calcType === "덧셈"){
            this.result = this.num1+ this.num2;
        } else{
            this.result = this.num1* this.num2;
        }
    },
  },
};
</script>
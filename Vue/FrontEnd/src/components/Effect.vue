<template>
    <div ref="sparklingContainer" class="sparkling-container"></div>
</template>

<script>
export default {
    mounted() {
        this.createSparkles();
    },
    methods: {
        createSparkles() {
            const sparkles = 50;
            const container = this.$refs.sparklingContainer;
            const swide = window.innerWidth;
            const shigh = window.innerHeight;

            const tiny = new Array();
            const star = new Array();
            const starv = new Array();
            const starx = new Array();
            const stary = new Array();

            for (let i = 0; i < sparkles; i++) {
                const tinyDiv = createDiv(3, 3);
                tinyDiv.style.visibility = "hidden";
                tinyDiv.style.zIndex = "999";
                container.appendChild(tinyDiv);
                tiny[i] = tinyDiv;
                starv[i] = 0;

                const starDiv = createDiv(5, 5);
                starDiv.style.backgroundColor = "transparent";
                starDiv.style.visibility = "hidden";
                starDiv.style.zIndex = "999";
                const rlef = createDiv(1, 5);
                const rdow = createDiv(5, 1);
                starDiv.appendChild(rlef);
                starDiv.appendChild(rdow);
                rlef.style.top = "2px";
                rlef.style.left = "0px";
                rdow.style.top = "0px";
                rdow.style.left = "2px";
                container.appendChild(starDiv);
                star[i] = starDiv;
            }

            function createDiv(height, width) {
                const div = document.createElement("div");
                div.style.position = "absolute";
                div.style.height = height + "px";
                div.style.width = width + "px";
                div.style.overflow = "hidden";
                return div;
            }

            function newColour() {
                const c = new Array();
                c[0] = 255;
                c[1] = Math.floor(Math.random() * 256);
                c[2] = Math.floor(Math.random() * (256 - c[1] / 2));
                c.sort(function () {
                    return 0.5 - Math.random();
                });
                return "rgb(" + c[0] + ", " + c[1] + ", " + c[2] + ")";
            }

            function sparkle() {
                const x = Math.floor(Math.random() * swide);
                const y = Math.floor(Math.random() * shigh);
                for (let c = 0; c < sparkles; c++) {
                    if (!starv[c]) {
                        star[c].style.left = (starx[c] = x) + "px";
                        star[c].style.top = (stary[c] = y + 1) + "px";
                        star[c].style.clip = "rect(0px, 5px, 5px, 0px)";
                        star[c].childNodes[0].style.backgroundColor =
                            star[c].childNodes[1].style.backgroundColor =
                            colour == "random" ? newColour() : colour;
                        star[c].style.visibility = "visible";
                        starv[c] = 50;
                        break;
                    }
                }
                setTimeout(sparkle, 1000); // Adjust the timing for new sparkles
            }

            sparkle();
        }
    }
};
</script>

<style scoped>
/* Add any necessary styling here */
</style>

<template>
    <nav aria-label="Page navigation example ">
        <ul class="pagination justify-content-center">

            <!-- 
                1. pi 가져오기 (testAxuis에서 $emit 으로 넘겨줘함 함)
                2. choose를 vue 문법으로 변환(v-if, v-else-if, v-else)
            -->
            <li class="page-item"  v-if="getPi.cpage === 1">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item" v-else>
                <a class="page-link" :href="`list.do?cpage=${getPi.cpage - 1}`" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            
            <!-- 
                pi.startPage 부터 시작해서 pi.endPage까지 반복
            -->
            <li class="page-item" v-for="(page, index) in getRange(getPi.startPage, getPi.endPage)" :key="index">
                <a class="page-link" :href="`list.do?cpage=${page}`">{{page}}</a>
            </li>
            
            <li class="page-item" v-if="getPi.cpage === getPi.maxPage">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="page-item" v-else>
                <a class="page-link" :href="`list.do?cpage=${getPi.cpage+1}`" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li> 
        </ul>
    </nav>
</template>

<script>
import { mapState } from 'pinia';
import { boardListStore } from '../stores/boardList'

export default {
    // props: ['pi'],
    computed: {
        ...mapState(boardListStore, ['getPi'])
    },
    methods: {
        getRange(startPage, endPage) {
			// Array.from : 배열로 변환
			// startPage : 5,  endPage : 10
			// [5, 6, 7, 8, 9, 10]
			return Array.from(
				{ length: endPage - startPage + 1 },
				(_, index) => startPage + index
				);
		}
    }
}
</script>
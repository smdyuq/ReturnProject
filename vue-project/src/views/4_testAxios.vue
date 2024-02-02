<template>
    <div>
        <button @click="getData">데이터 받아오기</button>
        <!-- <ul>
            <li v-for="(item, index) in users" :key="index">
                {{ item }}
            </li>
        </ul> -->
    </div>
</template>

<script>
import axios from 'axios';
import { boardListStore } from '../stores/boardList'
import { mapActions, mapState } from 'pinia';

export default {
    data() {
        return {
            users: [],
            pi: []
        }
    },
    computed: {
        ...mapState(boardListStore, ['getBoardList'])
    },
    methods: {
        ...mapActions(boardListStore, ['addBoardList']),
        getData() {
            axios.get('http://localhost:8080/free/list.do')
                .then((res) => {
                    this.pi.push(res.data.pi);
                    this.users.push(res.data.list);
                })
                .catch((err) => {
                    console.log(err);
                })
            this.$emit('getPi', this.pi);
            this.$emit('boardList', this.users);
        }

    }
}
</script>
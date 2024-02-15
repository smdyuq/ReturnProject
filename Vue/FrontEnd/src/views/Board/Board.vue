<template>
    <!-- <div id="app" class="container"> -->
    <div class="boardTitle">
        <h2>문의내역</h2>
    </div>
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자(ID)</th>
                <th>작성일</th>
                <th>답변여부</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(post, index) in posts" :key="index">
                <td>{{ index + 1 }}</td>
                <td>{{ post.title }}</td>
                <td>{{ post.author }}</td>
                <td>{{ post.date }}</td>
                <td>{{ post.status }}</td>
            </tr>
        </tbody>
    </table>

    <button class="add-post-btn" @click="goToAbout">글쓰기</button>
    <div v-if="showForm">
        <!-- 여기에 글 작성 폼을 넣으세요 -->
        <form>
            <!-- 폼 내용 -->
        </form>



        <!-- </div> -->
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    setup() {
        const posts = ref([
            { title: "첫 번째 글입니다.", author: "user123", date: "2024-02-15", status: "답변완료" },
            { title: "두 번째 글입니다.", author: "admin456", date: "2024-02-16", status: "미진행" }
            // 추가적인 데이터는 여기에 추가합니다.
        ]);
        const showForm = ref(false);

        const showPostForm = () => {
            showForm.value = true;
        }

        return { posts, showForm, showPostForm };
    },
    methods: {
        goToAbout() {
            this.$router.push('/aboutPage')
        }
    }
}
</script>

<style>
.boardTitle {
    margin-top: 20px;
    margin-bottom: 15px;
}

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

.container {
    width: 80%;
    margin: 20px auto;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th,
td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #f2f2f2;
}

.add-post-btn {
    /* width:100%; */
    margin-top: 20px;
    padding: 10px 20px;
    background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    position: relative;
    width: 120px;
    height: 50px;

}

.add-post-btn:hover {
    background-color: #45a049;
}</style>
  
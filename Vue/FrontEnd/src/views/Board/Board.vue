<template>
  <div class="boardTitle">
    <h2 style="font-weight: bold">문의내역</h2>
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
      <tr v-for="(post, index) in posts" :key="index" @click="openModal(post)">
        <td>{{ index + 1 }}</td>
        <td>{{ post.ask_title }}</td>
        <td>{{ post.member_id }}</td>
        <td>{{ post.ask_date }}</td>
        <td>{{ post.commentCount > 0 ? "O" : "" }}</td>
      </tr>
    </tbody>
  </table>

  <div v-if="modalCreated" class="boardModal">
    <div class="inquiriesTitle">문의 상세내용</div>
    <div>
      <div class="inquiriesList">제목 : {{ selectedPost.ask_title }}</div>
      <div class="inquiriesList">작성자 ID : {{ selectedPost.member_id }}</div>
      <div class="inquiriesList">작성일 : {{ selectedPost.ask_date }}</div>
      <div class="inquiriesList" id="inquiriesContent">
        문의내용 : {{ selectedPost.ask_content }}
      </div>
    </div>
    <table id="comment_tb">
      <tr v-for="comment in comments" :key="comment.id">
        <td>{{ comment.ask_comment_content }}</td>
        <td>관리자</td>
      </tr>
    </table>
    <div>

        <!-- <div class="comment-count">댓글</div>
        <div class="comment-name">
          <span class="anonym"
            >작성자 :
            <input
              type="text"
              class="form-control"
              id="com_writer"
              placeholder="이름"
              value="관리자"
              readonly
              style="width: 100px; border: none"
            />
          </span> 
        </div> -->
        <div v-if=" this.getMemberType === 0">
          <div class="comment-box">
          <!-- {{ this.getMemberType }} -->

          <textarea
            class="comment-input"
            id="com_content"
            cols="80"
            rows="2"
            v-model="ask_comment_content"
          >
          </textarea>

        </div>
        <div class="regBtn">
          <button class="modalBtn" @click="registerComment">댓글등록</button>
        </div>
      </div>


      <button class="modalBtn" @click="closeModal">닫기</button>
    </div>
  </div>

  <button class="add-post-btn" @click="goToAbout">글쓰기</button>
</template>

<script>
import axiosApi from "../../services/axios";
import { mapState } from "pinia";
import { userStore } from "../../stores/Member";

export default {
  
  data() {
    return {
      posts: [],
      modalCreated: false,
      selectedPost: null,
      membertype: 0,
      ask_comment_content: "",
      member: {
        memberType: -1,
        memberNo: -1,
        memberId: "",
        cpage: 1,
      },
      askNo: 0,
      comments:""
    };
  },
  computed: {
    ...mapState(userStore, [
      "getMemberNo",
      "getMemberType",
      "getMemberId",
      "getCpage",
    ]),
  },
  mounted() {
    this.fetchBoardList();
  },

  methods: {
    async fetchBoardList() {
      try {
        this.member.memberNo = this.getMemberNo;
        this.member.memberType = this.getMemberType;
        this.member.memberId = this.getMemberId;

        const response = await axiosApi.post("/inquiry/boardList", this.member);

        if (response
        .status === 200) {
          this.posts = response.data.list;
        }
      } catch (error) {
        console.error("게시물 불러오기 실패:", error);
      }
    },
    async registerComment() {
      // 댓글 등록 코드 추가
      // 여기에 댓글 등록 코드를 작성해주세요.
      const commentData = {
        content: this.ask_comment_content
      };
      console.log(commentData)
      
      axiosApi
      .post("/reply/insertComment", { reply: commentData, member: this.member, askNo: this.askNo} )
      .then((response) => {
          // 댓글 등록 성공 시 처리할 내용을 작성해주세요.
          this.fetchCommentList();
          console.log("댓글이 성공적으로 등록되었습니다.");
          this.ask_comment_content = '';
        })
        .catch((error) => {
          // 댓글 등록 실패 시 처리할 내용을 작성해주세요.
          console.error("댓글 등록 실패:", error);
        });
    },
    fetchCommentList() {
      const com_bno = this.askNo;
      axiosApi.get(`/reply/CommentList/${com_bno}`)
        .then(response => {
          console.log(response)
          this.comments = response.data.list;
        });
    },
    openModal(post) {
      console.log(post)
      this.askNo = post.ask_no;
      this.selectedPost = post;
      this.modalCreated = true;
      this.fetchCommentList(); 
    },
    closeModal() {  
      this.modalCreated = false;
    },
    goToAbout() {
      window.location.href = "aboutPage";
    },
  },
};
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
}

.boardModal {
  display: inline;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 20vh;
  left: 18vw;
  width: 64vw;
  height: 50vh;
  /* background-color: rgba(0, 0, 0, 0.5); */
  background-color: cornsilk;
  z-index: 100;
  /* 배경 투명도 조절 */
  border-radius: 1vw;
}

.modalBtn {
  display: inline-block;
  background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 8px;
  cursor: pointer;
  width: 10vw;
  margin-left: 2vw;
}

.inquiriesList {
  margin-left: 2vw;
  margin-bottom: 1vh;
  font-size: large;
}

.inquiriesTitle {
  font-size: x-large;
  font-weight: bold;
  margin-left: 2vw;
  margin-bottom: 1vh;
  margin-top: 3vh;
}
#inquiriesContent {
  height: 20vh;
  width: 60vw;
}
</style>

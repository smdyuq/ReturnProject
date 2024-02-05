<template>
    <div class="ChatWrapper">
      <div class="ChatList">
        <!-- 전체 대화방 목록 -->
        <h2>전체 대화방 목록</h2>
        <div class="ChatListContainer">
          <ul class="ChatRoomList">
            <li v-for="room in chatRooms" :key="room.id" @click="openChatRoom(room.id)">
              {{ room.name }}
            </li>
          </ul>
        </div>
      </div>
  
      <div class="ChatRoom" v-if="selectedChatRoom">
        <!-- 선택된 실시간 채팅방 -->
        
        <h2>{{ selectedChatRoom.name }}</h2>
        <div>
          <ul class="chat-messages">
            <li v-for="message in selectedChatRoom.messages" :key="message.id">
              {{ message.content }}
            </li>
          </ul>
  
          <input type="text" v-model="newMessage" />
          <button @click="sendMessage">전송</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    data() {
      return {
        chatRooms: [
          { id: 1, name: '방 1', messages: [] },
          { id: 2, name: '방 2', messages: [] },
          { id: 3, name: '방 3', messages: [] },
          { id: 1, name: '방 1', messages: [] },
          { id: 2, name: '방 2', messages: [] },
          { id: 3, name: '방 3', messages: [] },
          { id: 1, name: '방 1', messages: [] },
          { id: 2, name: '방 2', messages: [] },
          { id: 3, name: '방 3', messages: [] },
          
        ],
        selectedChatRoom: null,
        newMessage: '',
      };
    },
    methods: {
      openChatRoom(roomId) {
        this.selectedChatRoom = this.chatRooms.find((room) => room.id === roomId);
      },
      sendMessage() {
        if (this.newMessage && this.selectedChatRoom) {
          const newId = this.selectedChatRoom.messages.length + 1;
          const newMessage = {
            id: newId,
            content: this.newMessage,
          };
          this.selectedChatRoom.messages.push(newMessage);
          this.newMessage = '';
        }
      },
    },
  };
  </script>

<style scoped>
/* 전체 대화방 목록 스타일 */
h2 {
  font-size: 24px;
  font-weight: bold;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 8px;
  cursor: pointer;
}

/* 실시간 채팅방 스타일 */
input[type="text"] {
  width: 200px;
  height: 30px;
  margin-right: 8px;
}

button {
  padding: 8px 16px;
  background-image: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
  color: #fff;
  border: none;
  cursor: pointer;
}

button:hover {
  background-image: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
}

ul.chat-messages {
  list-style-type: none;
  padding: 0;
}

ul.chat-messages li {
  margin-bottom: 4px;
}

.ChatWrapper {
  display: flex;
  width: 1024px;
  height: 100%;
  border: 1px solid gray;
}

.ChatList {
  width: 50%;
  margin-left: 3%;
  margin-top: 3%;
  overflow-y: auto;
}

.ChatListContainer {
  max-height: 300px; /* 원하는 높이로 조정하세요 */
}

.ChatRoom {
  width: 50%;
  margin-left: 3%;
  margin-top: 3%;
  content: "대화방을 선택해주세요";
}

/* 대화방 선택 안내 문구 스타일 */
.chat-messages::before {
  content: "대화방을 선택해주세요";
  align-items: center;
  justify-content: center;
  height: 100%;
  font-size: 16px;
  font-weight: bold;
  color: gray;
}
</style>
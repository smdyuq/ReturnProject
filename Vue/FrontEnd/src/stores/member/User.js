// // stores/user.js

// import { createStore } from 'vuex';

// export const usersStore = createStore({
//   state: {
//     isLoggedIn: false,
//   },
//   mutations: {
//     setLoggedIn(state, isLoggedIn) {
//       state.isLoggedIn = isLoggedIn;
//     },
//   },
//   actions: {
//     login({ commit }) {
//       // 로그인 API 호출 등의 로직 수행
//       // 성공적으로 로그인했다고 가정하고 isLoggedIn을 true로 변경
//       commit('setLoggedIn', true);
//     },
//     logout({ commit }) {
//       // 로그아웃 API 호출 등의 로직 수행
//       // 로그아웃 성공 후 isLoggedIn을 false로 변경
//       commit('setLoggedIn', false);
//     },
//   },
// });

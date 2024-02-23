import axiosApi from '../../services/axios';

export default (await import('vue')).defineComponent({
data() {
return {
posts: [],
modalCreated: false,
selectedPost: null,
MemberType: -1,
member_no: -1
};
},
computed: {
...mapState(userStore, ['getMemberType'], ['getMemberNo'])
},
mounted() {
console.log('14');
this.fetchBoardList();
console.log('15');
},

methods: {
async fetchBoardList() {

console.log('1');
try {
this.member_no = this.getMemberNo;
this.member_type = this.getMemberType;
console.log('2');
const response = await axiosApi.get('/inquiry/boardList')
.then(res => {
console.log(res);
})
.catch(err => {
console.log(err);
});
console.log('2-1 :' + response.data);
console.log('3');
this.posts = response.data.list;
console.log('4');
} catch (error) {
console.log('5');
console.error('게시물 불러오기 실패:', error);
console.log('6');
}
},
openModal(post) {
console.log('7');
this.selectedPost = post;
console.log('8');
this.modalCreated = true;
console.log('9');
},
closeModal() {
console.log('10');
this.modalCreated = false;
console.log('11');
},
goToEnrollForm() {
console.log('12');
window.location.href = '/inquiry/enrollForm.do';
console.log('13');
}
}
});

<template>
    <div>
        <input type="text" v-model="name">
        <button @click="addUser">추가</button>

        <ul>
            <!-- <li>{{ getUser }}</li> -->
            <li v-for="(item, index) in getUser" :key="index">
                {{ item }}
            </li>
        </ul>
    </div>
</template>

<script>
import { mapActions, mapState } from 'pinia';
import { addUserStore } from '../stores/addUserStore';                  

export default {
    data: () => ({
        name: ''
    }),
    computed: {
        ...mapState(addUserStore, ['getUser'])
    },
    methods: {
        ...mapActions(addUserStore, ['addUserList']),
        addUser() {
            this.addUserList(this.name);
            this.name = '';
        }
    }
}
</script>
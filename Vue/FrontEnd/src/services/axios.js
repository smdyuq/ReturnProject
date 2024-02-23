import axios from 'axios'

const instance = axios.create ({
    baseURL: 'http://192.168.0.16'
    // timeout: 'http://192.168.0.4/api',
    // withCredentials: true
})
export default instance
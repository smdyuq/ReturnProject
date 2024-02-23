import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  proxy: {
    '/':{
      "target":'http://localhost:8080',
      "pathRewrite":{'^/':''},
      "changeOrigin":true,
      "secure":false
    }
  }
})
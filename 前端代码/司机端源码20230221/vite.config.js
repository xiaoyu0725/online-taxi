/*
 * @Author: ch cwl_ch@163.com
 * @Date: 2022-11-21 17:23:51
 * @LastEditors: ch
 * @LastEditTime: 2023-01-03 16:23:03
 * @Description: file content
 */
import { defineConfig } from 'vite'
import uni from '@dcloudio/vite-plugin-uni'
// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    uni(),
  ],
  server: {
    proxy: {
      "/api": {
        target: "http://localhost:8088",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, "/")
      },
      "/sseApi": {
        target: "http://localhost:9000",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/sseApi/, "/")
      },
    },
  },
})

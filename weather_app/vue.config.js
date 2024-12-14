const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',  // 后端 API 地址
        changeOrigin: true,  // 是否更改原始的主机头
        pathRewrite: {
          '^/api': '',  // 去除请求中的 '/api' 前缀
        },
        secure: false, // 如果是 https 接口，设置为 true
      },
    },
  },
})
// // 正确的 vue.config.js 使用 ESM 语法
// export default {
//
// };

module.exports = {
    //... 생략
    // historyApiFallback: true,
    proxy: {
        '/*': {
          target: 'http://192.168.0.4',
          changeOrigin: true,
        }
    }
}
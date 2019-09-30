module.exports = {
    runtimeCompiler: true,
    configureWebpack: {
        externals: {
            // global app config object
            config: JSON.stringify({
                apiUrl: 'http://localhost:8081'
            })
        },
    }
  };
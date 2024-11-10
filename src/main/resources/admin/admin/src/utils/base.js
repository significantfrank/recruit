const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot2p4rpc91/",
            name: "springboot2p4rpc91",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot2p4rpc91/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "求职招聘系统"
        } 
    }
}
export default base

const base = {
    get() {
                return {
            url : "http://localhost:8080/ssmso1m5/",
            name: "ssmso1m5",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmso1m5/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "企业销售人员培训系统"
        } 
    }
}
export default base

<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="180px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="求职账号" prop="qiuzhizhanghao">
            <el-input v-model="ruleForm.qiuzhizhanghao" 
                placeholder="求职账号" clearable :disabled=" false  ||ro.qiuzhizhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="求职姓名" prop="qiuzhixingming">
            <el-input v-model="ruleForm.qiuzhixingming" 
                placeholder="求职姓名" clearable :disabled=" false  ||ro.qiuzhixingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="学历" prop="xueli">
            <el-input v-model="ruleForm.xueli" 
                placeholder="学历" clearable :disabled=" false  ||ro.xueli"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="年龄" prop="nianling">
            <el-input v-model="ruleForm.nianling" 
                placeholder="年龄" clearable :disabled=" false  ||ro.nianling"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="性别" prop="xingbie">
            <el-input v-model="ruleForm.xingbie" 
                placeholder="性别" clearable :disabled=" false  ||ro.xingbie"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机号" prop="shoujihao">
            <el-input v-model="ruleForm.shoujihao" 
                placeholder="手机号" clearable :disabled=" false  ||ro.shoujihao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="电子邮箱" prop="dianziyouxiang">
            <el-input v-model="ruleForm.dianziyouxiang" 
                placeholder="电子邮箱" clearable :disabled=" false  ||ro.dianziyouxiang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="简历附件" prop="jianlifujian">
            <file-upload
            tip="点击上传简历附件"
            action="file/upload"
            :limit="1"
			:type="3"
            :multiple="true"
            :fileUrls="ruleForm.jianlifujian?ruleForm.jianlifujian:''"
            @change="jianlifujianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="期望薪资" prop="qiwangxinzi">
            <el-input v-model="ruleForm.qiwangxinzi" 
                placeholder="期望薪资" clearable :disabled=" false  ||ro.qiwangxinzi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="职位类型" prop="zhiweileixing">
            <el-select v-model="ruleForm.zhiweileixing" placeholder="请选择职位类型" :disabled=" false  ||ro.zhiweileixing" >
              <el-option
                  v-for="(item,index) in zhiweileixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="所在地点" prop="suozaididian">
            <el-input v-model="ruleForm.suozaididian" 
                placeholder="所在地点" clearable :disabled=" false  ||ro.suozaididian"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="毕业院校" prop="biyeyuanxiao">
            <el-input v-model="ruleForm.biyeyuanxiao" 
                placeholder="毕业院校" clearable :disabled=" false  ||ro.biyeyuanxiao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
            <file-upload
            tip="点击上传头像"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
            @change="touxiangUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="头像" prop="touxiang">
                <img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="自我介绍" prop="ziwojieshao">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="自我介绍"
              v-model="ruleForm.ziwojieshao">
            </el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="优势技能" prop="youshijineng">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="优势技能"
              v-model="ruleForm.youshijineng">
            </el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#1e3c4f","width":"128px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #1e3c4f","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1e3c4f","borderRadius":"6px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				qiuzhizhanghao : false,
				qiuzhixingming : false,
				xueli : false,
				nianling : false,
				xingbie : false,
				shoujihao : false,
				dianziyouxiang : false,
				jianlifujian : false,
				qiwangxinzi : false,
				zhiweileixing : false,
				suozaididian : false,
				biyeyuanxiao : false,
				ziwojieshao : false,
				youshijineng : false,
				touxiang : false,
				clicktime : false,
				clicknum : false,
				storeupnum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          qiuzhizhanghao: '',
          qiuzhixingming: '',
          xueli: '',
          nianling: '',
          xingbie: '',
          shoujihao: '',
          dianziyouxiang: '',
          jianlifujian: '',
          qiwangxinzi: '',
          zhiweileixing: '',
          suozaididian: '',
          biyeyuanxiao: '',
          ziwojieshao: '',
          youshijineng: '',
          touxiang: '',
          clicktime: '',
          clicknum: '',
          storeupnum: '',
        },
        zhiweileixingOptions: [],


        rules: {
          qiuzhizhanghao: [
          ],
          qiuzhixingming: [
          ],
          xueli: [
          ],
          nianling: [
          ],
          xingbie: [
          ],
          shoujihao: [
          ],
          dianziyouxiang: [
          ],
          jianlifujian: [
          ],
          qiwangxinzi: [
          ],
          zhiweileixing: [
          ],
          suozaididian: [
          ],
          biyeyuanxiao: [
          ],
          ziwojieshao: [
          ],
          youshijineng: [
          ],
          touxiang: [
          ],
          clicktime: [
          ],
          clicknum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          storeupnum: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='qiuzhizhanghao'){
              this.ruleForm.qiuzhizhanghao = obj[o];
              this.ro.qiuzhizhanghao = true;
              continue;
            }
            if(o=='qiuzhixingming'){
              this.ruleForm.qiuzhixingming = obj[o];
              this.ro.qiuzhixingming = true;
              continue;
            }
            if(o=='xueli'){
              this.ruleForm.xueli = obj[o];
              this.ro.xueli = true;
              continue;
            }
            if(o=='nianling'){
              this.ruleForm.nianling = obj[o];
              this.ro.nianling = true;
              continue;
            }
            if(o=='xingbie'){
              this.ruleForm.xingbie = obj[o];
              this.ro.xingbie = true;
              continue;
            }
            if(o=='shoujihao'){
              this.ruleForm.shoujihao = obj[o];
              this.ro.shoujihao = true;
              continue;
            }
            if(o=='dianziyouxiang'){
              this.ruleForm.dianziyouxiang = obj[o];
              this.ro.dianziyouxiang = true;
              continue;
            }
            if(o=='jianlifujian'){
              this.ruleForm.jianlifujian = obj[o];
              this.ro.jianlifujian = true;
              continue;
            }
            if(o=='qiwangxinzi'){
              this.ruleForm.qiwangxinzi = obj[o];
              this.ro.qiwangxinzi = true;
              continue;
            }
            if(o=='zhiweileixing'){
              this.ruleForm.zhiweileixing = obj[o];
              this.ro.zhiweileixing = true;
              continue;
            }
            if(o=='suozaididian'){
              this.ruleForm.suozaididian = obj[o];
              this.ro.suozaididian = true;
              continue;
            }
            if(o=='biyeyuanxiao'){
              this.ruleForm.biyeyuanxiao = obj[o];
              this.ro.biyeyuanxiao = true;
              continue;
            }
            if(o=='ziwojieshao'){
              this.ruleForm.ziwojieshao = obj[o];
              this.ro.ziwojieshao = true;
              continue;
            }
            if(o=='youshijineng'){
              this.ruleForm.youshijineng = obj[o];
              this.ro.youshijineng = true;
              continue;
            }
            if(o=='touxiang'){
              this.ruleForm.touxiang = obj[o].split(",")[0];
              this.ro.touxiang = true;
              continue;
            }
            if(o=='clicktime'){
              this.ruleForm.clicktime = obj[o];
              this.ro.clicktime = true;
              continue;
            }
            if(o=='clicknum'){
              this.ruleForm.clicknum = obj[o];
              this.ro.clicknum = true;
              continue;
            }
            if(o=='storeupnum'){
              this.ruleForm.storeupnum = obj[o];
              this.ro.storeupnum = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.qiuzhizhanghao!=''&&json.qiuzhizhanghao) || json.qiuzhizhanghao==0){
                this.ruleForm.qiuzhizhanghao = json.qiuzhizhanghao;
				this.ro.qiuzhizhanghao = true;
            }
            if((json.qiuzhixingming!=''&&json.qiuzhixingming) || json.qiuzhixingming==0){
                this.ruleForm.qiuzhixingming = json.qiuzhixingming;
				this.ro.qiuzhixingming = true;
            }
            if((json.xueli!=''&&json.xueli) || json.xueli==0){
                this.ruleForm.xueli = json.xueli;
				this.ro.xueli = true;
            }
            if((json.nianling!=''&&json.nianling) || json.nianling==0){
                this.ruleForm.nianling = json.nianling;
				this.ro.nianling = true;
            }
            if((json.xingbie!=''&&json.xingbie) || json.xingbie==0){
                this.ruleForm.xingbie = json.xingbie;
				this.ro.xingbie = true;
            }
            if((json.shoujihao!=''&&json.shoujihao) || json.shoujihao==0){
                this.ruleForm.shoujihao = json.shoujihao;
				this.ro.shoujihao = true;
            }
            if((json.dianziyouxiang!=''&&json.dianziyouxiang) || json.dianziyouxiang==0){
                this.ruleForm.dianziyouxiang = json.dianziyouxiang;
				this.ro.dianziyouxiang = true;
            }
          }
        });
        this.$http.get('option/zhiweileixing/zhiweileixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.zhiweileixingOptions = res.data.data;
          }
        });

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`gerenjianli/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('gerenjianli/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`gerenjianli/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`gerenjianli/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				}
			});
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		// 返回
		back() {
			this.$router.go(-1);
		},
      jianlifujianUploadChange(fileUrls) {
          this.ruleForm.jianlifujian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      touxiangUploadChange(fileUrls) {
          this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 180px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border-radius: 30px;
	  padding: 0 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 300px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 350px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #eee;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 350px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #999;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #eee;
	  line-height: 60px;
	  border-radius: 20px;
	  background: #fff;
	  width: 120px;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  height: 60px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #eee;
	  border-radius: 20px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>

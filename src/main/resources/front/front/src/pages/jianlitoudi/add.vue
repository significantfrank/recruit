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
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="职位名称" prop="zhiweimingcheng">
            <el-input v-model="ruleForm.zhiweimingcheng" 
                placeholder="职位名称" clearable :disabled=" false  ||ro.zhiweimingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="职位类型" prop="zhiweileixing">
            <el-input v-model="ruleForm.zhiweileixing" 
                placeholder="职位类型" clearable :disabled=" false  ||ro.zhiweileixing"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="应聘人数" prop="zhaopinrenshu">
            <el-select v-model="ruleForm.zhaopinrenshu" placeholder="请选择应聘人数" :disabled="true  ||ro.zhaopinrenshu" >
              <el-option
                  v-for="(item,index) in zhaopinrenshuOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="公司图片" v-if="type!='cross' || (type=='cross' && !ro.gongsitupian)" prop="gongsitupian">
            <file-upload
            tip="点击上传公司图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.gongsitupian?ruleForm.gongsitupian:''"
            @change="gongsitupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="公司图片" prop="gongsitupian">
                <img v-if="ruleForm.gongsitupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.gongsitupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.gongsitupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="公司账号" prop="gongsizhanghao">
            <el-input v-model="ruleForm.gongsizhanghao" 
                placeholder="公司账号" clearable :disabled=" false  ||ro.gongsizhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="公司名称" prop="gongsimingcheng">
            <el-input v-model="ruleForm.gongsimingcheng" 
                placeholder="公司名称" clearable :disabled=" false  ||ro.gongsimingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="个人简历" prop="gerenjianli">
            <file-upload
            tip="点击上传个人简历"
            action="file/upload"
            :limit="1"
			:type="3"
            :multiple="true"
            :fileUrls="ruleForm.gerenjianli?ruleForm.gerenjianli:''"
            @change="gerenjianliUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="投递时间" prop="toudishijian">
              <el-date-picker
				  :disabled=" false  ||ro.toudishijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.toudishijian" 
                  type="datetime"
                  placeholder="投递时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="求职账号" prop="qiuzhizhanghao">
            <el-input v-model="ruleForm.qiuzhizhanghao" 
                placeholder="求职账号" clearable :disabled=" false  ||ro.qiuzhizhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="求职姓名" prop="qiuzhixingming">
            <el-input v-model="ruleForm.qiuzhixingming" 
                placeholder="求职姓名" clearable :disabled=" false  ||ro.qiuzhixingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机号" prop="shoujihao">
            <el-input v-model="ruleForm.shoujihao" 
                placeholder="手机号" clearable :disabled=" false  ||ro.shoujihao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="职位要求" prop="zhiweiyaoqiu">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="职位要求"
              v-model="ruleForm.zhiweiyaoqiu">
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
				zhiweimingcheng : false,
				zhiweileixing : false,
				zhaopinrenshu : false,
				zhiweiyaoqiu : false,
				gongsitupian : false,
				gongsizhanghao : false,
				gongsimingcheng : false,
				gerenjianli : false,
				toudishijian : false,
				qiuzhizhanghao : false,
				qiuzhixingming : false,
				shoujihao : false,
				sfsh : false,
				shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          zhiweimingcheng: '',
          zhiweileixing: '',
          zhaopinrenshu: Number('1') ,
          zhiweiyaoqiu: '',
          gongsitupian: '',
          gongsizhanghao: '',
          gongsimingcheng: '',
          gerenjianli: '',
          toudishijian: '',
          qiuzhizhanghao: '',
          qiuzhixingming: '',
          shoujihao: '',
        },
        zhaopinrenshuOptions: [],


        rules: {
          zhiweimingcheng: [
          ],
          zhiweileixing: [
          ],
          zhaopinrenshu: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          zhiweiyaoqiu: [
          ],
          gongsitupian: [
          ],
          gongsizhanghao: [
          ],
          gongsimingcheng: [
          ],
          gerenjianli: [
          ],
          toudishijian: [
          ],
          qiuzhizhanghao: [
          ],
          qiuzhixingming: [
          ],
          shoujihao: [
          ],
          sfsh: [
          ],
          shhf: [
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
      this.ruleForm.toudishijian = this.getCurDateTime()
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
            if(o=='zhiweimingcheng'){
              this.ruleForm.zhiweimingcheng = obj[o];
              this.ro.zhiweimingcheng = true;
              continue;
            }
            if(o=='zhiweileixing'){
              this.ruleForm.zhiweileixing = obj[o];
              this.ro.zhiweileixing = true;
              continue;
            }
            if(o=='zhaopinrenshu'){
              this.ruleForm.zhaopinrenshu = obj[o];
              this.ro.zhaopinrenshu = true;
              continue;
            }
            if(o=='zhiweiyaoqiu'){
              this.ruleForm.zhiweiyaoqiu = obj[o];
              this.ro.zhiweiyaoqiu = true;
              continue;
            }
            if(o=='gongsitupian'){
              this.ruleForm.gongsitupian = obj[o].split(",")[0];
              this.ro.gongsitupian = true;
              continue;
            }
            if(o=='gongsizhanghao'){
              this.ruleForm.gongsizhanghao = obj[o];
              this.ro.gongsizhanghao = true;
              continue;
            }
            if(o=='gongsimingcheng'){
              this.ruleForm.gongsimingcheng = obj[o];
              this.ro.gongsimingcheng = true;
              continue;
            }
            if(o=='gerenjianli'){
              this.ruleForm.gerenjianli = obj[o];
              this.ro.gerenjianli = true;
              continue;
            }
            if(o=='toudishijian'){
              this.ruleForm.toudishijian = obj[o];
              this.ro.toudishijian = true;
              continue;
            }
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
            if(o=='shoujihao'){
              this.ruleForm.shoujihao = obj[o];
              this.ro.shoujihao = true;
              continue;
            }
          }
            this.ruleForm.zhaopinrenshu=Number('1') ;
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
            if((json.shoujihao!=''&&json.shoujihao) || json.shoujihao==0){
                this.ruleForm.shoujihao = json.shoujihao;
				this.ro.shoujihao = true;
            }
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
        this.$http.get(`jianlitoudi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			if(!this.ruleForm.zhaopinrenshu){
				this.$message.error("应聘人数不能为空");
				return
			}
			var obj = JSON.parse(localStorage.getItem('crossObj'));
			var table = localStorage.getItem('crossTable');
			obj.zhaopinrenshu = obj.zhaopinrenshu - this.ruleForm.zhaopinrenshu
			if(obj.zhaopinrenshu<0){
				this.$message.error("应聘人数不足");
				return
			}
			//this.$http.post(table+`/update`, obj).then(res => {});
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
						this.$http.get('jianlitoudi/list', {
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
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								var table = localStorage.getItem('crossTable');

								obj.zhaopinrenshu = parseFloat(obj.zhaopinrenshu) - parseFloat(this.ruleForm.zhaopinrenshu)

								this.$http.post(table+`/update`,obj).then(res => {});
								this.$http.post(`jianlitoudi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.zhaopinrenshu = parseFloat(obj.zhaopinrenshu) - parseFloat(this.ruleForm.zhaopinrenshu)

						this.$http.post(table+`/update`,obj).then(res => {});
						this.$http.post(`jianlitoudi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
      gongsitupianUploadChange(fileUrls) {
          this.ruleForm.gongsitupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      gerenjianliUploadChange(fileUrls) {
          this.ruleForm.gerenjianli = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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

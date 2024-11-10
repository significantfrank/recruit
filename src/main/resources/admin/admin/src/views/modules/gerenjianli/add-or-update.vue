<template>
	<div class="addEdit-block" :style='{"padding":"30px"}'>
		<el-form
			:style='{"borderRadius":"6px","padding":"30px"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="200px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="求职账号" prop="qiuzhizhanghao">
					<el-input v-model="ruleForm.qiuzhizhanghao" placeholder="求职账号" clearable  :readonly="ro.qiuzhizhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="求职账号" prop="qiuzhizhanghao">
					<el-input v-model="ruleForm.qiuzhizhanghao" placeholder="求职账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="求职姓名" prop="qiuzhixingming">
					<el-input v-model="ruleForm.qiuzhixingming" placeholder="求职姓名" clearable  :readonly="ro.qiuzhixingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="求职姓名" prop="qiuzhixingming">
					<el-input v-model="ruleForm.qiuzhixingming" placeholder="求职姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="学历" prop="xueli">
					<el-input v-model="ruleForm.xueli" placeholder="学历" clearable  :readonly="ro.xueli"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="学历" prop="xueli">
					<el-input v-model="ruleForm.xueli" placeholder="学历" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" placeholder="年龄" clearable  :readonly="ro.nianling"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" placeholder="年龄" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="性别" prop="xingbie">
					<el-input v-model="ruleForm.xingbie" placeholder="性别" clearable  :readonly="ro.xingbie"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="性别" prop="xingbie">
					<el-input v-model="ruleForm.xingbie" placeholder="性别" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机号" prop="shoujihao">
					<el-input v-model="ruleForm.shoujihao" placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机号" prop="shoujihao">
					<el-input v-model="ruleForm.shoujihao" placeholder="手机号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="电子邮箱" prop="dianziyouxiang">
					<el-input v-model="ruleForm.dianziyouxiang" placeholder="电子邮箱" clearable  :readonly="ro.dianziyouxiang"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="电子邮箱" prop="dianziyouxiang">
					<el-input v-model="ruleForm.dianziyouxiang" placeholder="电子邮箱" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.jianlifujian" label="简历附件" prop="jianlifujian">
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.jianlifujian" label="简历附件" prop="jianlifujian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(44, 55, 66, 0.8)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.jianlifujian)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="!ruleForm.jianlifujian" label="简历附件" prop="jianlifujian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 15px","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(44, 55, 66, 0.8)","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="期望薪资" prop="qiwangxinzi">
					<el-input v-model="ruleForm.qiwangxinzi" placeholder="期望薪资" clearable  :readonly="ro.qiwangxinzi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="期望薪资" prop="qiwangxinzi">
					<el-input v-model="ruleForm.qiwangxinzi" placeholder="期望薪资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="职位类型" prop="zhiweileixing">
					<el-select :disabled="ro.zhiweileixing" v-model="ruleForm.zhiweileixing" placeholder="请选择职位类型" >
						<el-option
							v-for="(item,index) in zhiweileixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="职位类型" prop="zhiweileixing">
					<el-input v-model="ruleForm.zhiweileixing"
						placeholder="职位类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="所在地点" prop="suozaididian">
					<el-input v-model="ruleForm.suozaididian" placeholder="所在地点" clearable  :readonly="ro.suozaididian"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="所在地点" prop="suozaididian">
					<el-input v-model="ruleForm.suozaididian" placeholder="所在地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="毕业院校" prop="biyeyuanxiao">
					<el-input v-model="ruleForm.biyeyuanxiao" placeholder="毕业院校" clearable  :readonly="ro.biyeyuanxiao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="毕业院校" prop="biyeyuanxiao">
					<el-input v-model="ruleForm.biyeyuanxiao" placeholder="毕业院校" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.touxiang" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="touxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.touxiang" label="头像" prop="touxiang">
					<img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="自我介绍" prop="ziwojieshao">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="自我介绍"
					  v-model="ruleForm.ziwojieshao" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.ziwojieshao" label="自我介绍" prop="ziwojieshao">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.ziwojieshao}}</span>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="优势技能" prop="youshijineng">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="优势技能"
					  v-model="ruleForm.youshijineng" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.youshijineng" label="优势技能" prop="youshijineng">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.youshijineng}}</span>
				</el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont " :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
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
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				storeupnum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.touxiang = obj[o];
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
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
					if(((json.qiuzhizhanghao!=''&&json.qiuzhizhanghao) || json.qiuzhizhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.qiuzhizhanghao = json.qiuzhizhanghao
						this.ro.qiuzhizhanghao = true;
					}
					if(((json.qiuzhixingming!=''&&json.qiuzhixingming) || json.qiuzhixingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.qiuzhixingming = json.qiuzhixingming
						this.ro.qiuzhixingming = true;
					}
					if(((json.xueli!=''&&json.xueli) || json.xueli==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xueli = json.xueli
						this.ro.xueli = true;
					}
					if(((json.nianling!=''&&json.nianling) || json.nianling==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.nianling = json.nianling
						this.ro.nianling = true;
					}
					if(((json.xingbie!=''&&json.xingbie) || json.xingbie==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingbie = json.xingbie
						this.ro.xingbie = true;
					}
					if(((json.shoujihao!=''&&json.shoujihao) || json.shoujihao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shoujihao = json.shoujihao
						this.ro.shoujihao = true;
					}
					if(((json.dianziyouxiang!=''&&json.dianziyouxiang) || json.dianziyouxiang==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.dianziyouxiang = json.dianziyouxiang
						this.ro.dianziyouxiang = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
            this.$http({
				url: `option/zhiweileixing/zhiweileixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.zhiweileixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `gerenjianli/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.jianlifujian!=null) {
		this.ruleForm.jianlifujian = this.ruleForm.jianlifujian.replace(new RegExp(this.$base.url,"g"),"");
	}
	if(this.ruleForm.touxiang!=null) {
		this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "gerenjianli/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `gerenjianli/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.gerenjianliCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `gerenjianli/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.gerenjianliCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.gerenjianliCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    jianlifujianUploadChange(fileUrls) {
	    this.ruleForm.jianlifujian = fileUrls;
    },
    touxiangUploadChange(fileUrls) {
	    this.ruleForm.touxiang = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 200px;
	  	  font-size: 14px;
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
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #eee;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #333;
	  	  object-fit: cover;
	  	  width: 140px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #eee;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #333;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 24px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: rgba(44, 55, 66, 0.8);
				width: auto;
				font-size: 14px;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.8;
			}
</style>

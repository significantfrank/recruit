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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="职位名称" prop="zhiweimingcheng">
					<el-input v-model="ruleForm.zhiweimingcheng" placeholder="职位名称" clearable  :readonly="ro.zhiweimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="职位名称" prop="zhiweimingcheng">
					<el-input v-model="ruleForm.zhiweimingcheng" placeholder="职位名称" readonly></el-input>
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.gongsitupian" label="公司图片" prop="gongsitupian">
					<file-upload
						tip="点击上传公司图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.gongsitupian?ruleForm.gongsitupian:''"
						@change="gongsitupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.gongsitupian" label="公司图片" prop="gongsitupian">
					<img v-if="ruleForm.gongsitupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.gongsitupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.gongsitupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="工作地点" prop="gongzuodidian">
					<el-input v-model="ruleForm.gongzuodidian" placeholder="工作地点" clearable  :readonly="ro.gongzuodidian"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="工作地点" prop="gongzuodidian">
					<el-input v-model="ruleForm.gongzuodidian" placeholder="工作地点" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="薪资待遇" prop="xinzidaiyu">
					<el-input v-model.number="ruleForm.xinzidaiyu" placeholder="薪资待遇" clearable  :readonly="ro.xinzidaiyu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="薪资待遇" prop="xinzidaiyu">
					<el-input v-model="ruleForm.xinzidaiyu" placeholder="薪资待遇" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="招聘人数" prop="zhaopinrenshu">
					<el-input v-model.number="ruleForm.zhaopinrenshu" placeholder="招聘人数" clearable  :readonly="ro.zhaopinrenshu"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="招聘人数" prop="zhaopinrenshu">
					<el-input v-model="ruleForm.zhaopinrenshu" placeholder="招聘人数" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.fabushijian" 
						type="date"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="公司账号" prop="gongsizhanghao">
					<el-input v-model="ruleForm.gongsizhanghao" placeholder="公司账号" clearable  :readonly="ro.gongsizhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="公司账号" prop="gongsizhanghao">
					<el-input v-model="ruleForm.gongsizhanghao" placeholder="公司账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="公司名称" prop="gongsimingcheng">
					<el-input v-model="ruleForm.gongsimingcheng" placeholder="公司名称" clearable  :readonly="ro.gongsimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="公司名称" prop="gongsimingcheng">
					<el-input v-model="ruleForm.gongsimingcheng" placeholder="公司名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="公司规模" prop="gongsiguimo">
					<el-input v-model="ruleForm.gongsiguimo" placeholder="公司规模" clearable  :readonly="ro.gongsiguimo"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="公司规模" prop="gongsiguimo">
					<el-input v-model="ruleForm.gongsiguimo" placeholder="公司规模" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="职位要求" prop="zhiweiyaoqiu">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="职位要求"
					  v-model="ruleForm.zhiweiyaoqiu" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.zhiweiyaoqiu" label="职位要求" prop="zhiweiyaoqiu">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}'>{{ruleForm.zhiweiyaoqiu}}</span>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="公司介绍" prop="gongsijieshao">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.gongsijieshao" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.gongsijieshao" label="公司介绍" prop="gongsijieshao">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.gongsijieshao"></span>
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
				zhiweimingcheng : false,
				zhiweileixing : false,
				gongsitupian : false,
				gongzuodidian : false,
				zhiweiyaoqiu : false,
				xinzidaiyu : false,
				zhaopinrenshu : false,
				fabushijian : false,
				lianxifangshi : false,
				gongsizhanghao : false,
				gongsimingcheng : false,
				gongsiguimo : false,
				gongsijieshao : false,
				clicktime : false,
				clicknum : false,
				discussnum : false,
				storeupnum : false,
			},
			
			
			ruleForm: {
				zhiweimingcheng: '',
				zhiweileixing: '',
				gongsitupian: '',
				gongzuodidian: '',
				zhiweiyaoqiu: '',
				xinzidaiyu: '',
				zhaopinrenshu: '',
				fabushijian: '',
				lianxifangshi: '',
				gongsizhanghao: '',
				gongsimingcheng: '',
				gongsiguimo: '',
				gongsijieshao: '',
				clicktime: '',
			},
		
			zhiweileixingOptions: [],

			
			rules: {
				zhiweimingcheng: [
				],
				zhiweileixing: [
				],
				gongsitupian: [
				],
				gongzuodidian: [
				],
				zhiweiyaoqiu: [
				],
				xinzidaiyu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				zhaopinrenshu: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				fabushijian: [
				],
				lianxifangshi: [
				],
				gongsizhanghao: [
				],
				gongsimingcheng: [
				],
				gongsiguimo: [
				],
				gongsijieshao: [
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				discussnum: [
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
		this.ruleForm.fabushijian = this.getCurDate()
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
						if(o=='gongsitupian'){
							this.ruleForm.gongsitupian = obj[o];
							this.ro.gongsitupian = true;
							continue;
						}
						if(o=='gongzuodidian'){
							this.ruleForm.gongzuodidian = obj[o];
							this.ro.gongzuodidian = true;
							continue;
						}
						if(o=='zhiweiyaoqiu'){
							this.ruleForm.zhiweiyaoqiu = obj[o];
							this.ro.zhiweiyaoqiu = true;
							continue;
						}
						if(o=='xinzidaiyu'){
							this.ruleForm.xinzidaiyu = obj[o];
							this.ro.xinzidaiyu = true;
							continue;
						}
						if(o=='zhaopinrenshu'){
							this.ruleForm.zhaopinrenshu = obj[o];
							this.ro.zhaopinrenshu = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='lianxifangshi'){
							this.ruleForm.lianxifangshi = obj[o];
							this.ro.lianxifangshi = true;
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
						if(o=='gongsiguimo'){
							this.ruleForm.gongsiguimo = obj[o];
							this.ro.gongsiguimo = true;
							continue;
						}
						if(o=='gongsijieshao'){
							this.ruleForm.gongsijieshao = obj[o];
							this.ro.gongsijieshao = true;
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
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
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
					if(((json.lianxifangshi!=''&&json.lianxifangshi) || json.lianxifangshi==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxifangshi = json.lianxifangshi
						this.ro.lianxifangshi = true;
					}
					if(((json.gongsizhanghao!=''&&json.gongsizhanghao) || json.gongsizhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsizhanghao = json.gongsizhanghao
						this.ro.gongsizhanghao = true;
					}
					if(((json.gongsimingcheng!=''&&json.gongsimingcheng) || json.gongsimingcheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsimingcheng = json.gongsimingcheng
						this.ro.gongsimingcheng = true;
					}
					if(((json.gongsiguimo!=''&&json.gongsiguimo) || json.gongsiguimo==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsiguimo = json.gongsiguimo
						this.ro.gongsiguimo = true;
					}
					if(((json.gongsijieshao!=''&&json.gongsijieshao) || json.gongsijieshao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.gongsijieshao = json.gongsijieshao
						this.ro.gongsijieshao = true;
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
        url: `zhiweixinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.gongsijieshao = this.ruleForm.gongsijieshao.replace(reg,'../../../springboot2p4rpc91/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.gongsitupian!=null) {
		this.ruleForm.gongsitupian = this.ruleForm.gongsitupian.replace(new RegExp(this.$base.url,"g"),"");
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
					url: "zhiweixinxi/page", 
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
								url: `zhiweixinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.zhiweixinxiCrossAddOrUpdateFlag = false;
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
				url: `zhiweixinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.zhiweixinxiCrossAddOrUpdateFlag = false;
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
      this.parent.zhiweixinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    gongsitupianUploadChange(fileUrls) {
	    this.ruleForm.gongsitupian = fileUrls;
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

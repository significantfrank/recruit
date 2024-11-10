<template>
	<div>

	<div class="container" :style='{"minHeight":"calc(100vh - 70px)","borderColor":"#d7eaff","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231128/4426e8245c254fa88b7032f81fb1e71b.jpg)","borderWidth":"35px 140px 35px 140px","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","borderStyle":"solid","backgroundRepeat":"no-repeat","justifyContent":"flex-start"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"minHeight":"calc(100vh - 70px)","padding":"0 180px","margin":"0","borderRadius":"0px","flexWrap":"wrap","background":"#fff","display":"flex","width":"calc(53% - 0px)","position":"relative","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"20px","color":"rgba(64, 158, 255, 1)","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"60px auto 10px","color":"#1e3c4f","textAlign":"center","width":"100%","letterSpacing":"2px","lineHeight":"44px","fontSize":"32px","fontWeight":"600"}'>求职招聘系统注册</p></div>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="qiuzhizhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('qiuzhizhanghao')?'required':''">求职账号：</div>
				<el-input v-model="registerForm.qiuzhizhanghao"  placeholder="请输入求职账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="qiuzhixingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('qiuzhixingming')?'required':''">求职姓名：</div>
				<el-input v-model="registerForm.qiuzhixingming"  placeholder="请输入求职姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="shoujihao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('shoujihao')?'required':''">手机号：</div>
				<el-input v-model="registerForm.shoujihao"  placeholder="请输入手机号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in qiuzhizhexingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="nianling">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="qiuzhizhetouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="xueli">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('xueli')?'required':''">学历：</div>
				<el-input v-model="registerForm.xueli"  placeholder="请输入学历" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='qiuzhizhe'" prop="dianziyouxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('dianziyouxiang')?'required':''">电子邮箱：</div>
				<el-input v-model="registerForm.dianziyouxiang"  placeholder="请输入电子邮箱" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="gongsizhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('gongsizhanghao')?'required':''">公司账号：</div>
				<el-input v-model="registerForm.gongsizhanghao"  placeholder="请输入公司账号" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="gongsimingcheng">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('gongsimingcheng')?'required':''">公司名称：</div>
				<el-input v-model="registerForm.gongsimingcheng"  placeholder="请输入公司名称" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="lianxifangshi">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="gongsitouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="gongsiguimo">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('gongsiguimo')?'required':''">公司规模：</div>
                <el-select v-model="registerForm.gongsiguimo" placeholder="请选择公司规模" >
                  <el-option
                      v-for="(item,index) in gongsigongsiguimoOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="qiyedaibiao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('qiyedaibiao')?'required':''">企业代表：</div>
				<el-input v-model="registerForm.qiyedaibiao"  placeholder="请输入企业代表" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="chuanglishijian">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('chuanglishijian')?'required':''">创立时间：</div>
                <el-date-picker
                    format="yyyy 年 MM 月 dd 日"
                    value-format="yyyy-MM-dd"
                    v-model="registerForm.chuanglishijian"
                    type="date"
                    placeholder="创立时间"
                ></el-date-picker>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="gongsidizhi">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('gongsidizhi')?'required':''">公司地址：</div>
				<el-input v-model="registerForm.gongsidizhi"  placeholder="请输入公司地址" />
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="fazhanlicheng">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('fazhanlicheng')?'required':''">发展历程：</div>
			    <editor
			        :style='{"minHeight":"250px","border":"0px solid #1abc9e30","borderRadius":"0px","color":"#666","background":"#fff","width":"400px","clear":"both","minWidth":"300px","height":"auto"}'
			        v-model="registerForm.fazhanlicheng" 
			        class="editor" 
			        action="file/upload">
			    </editor>
			</el-form-item>
			<el-form-item :style='{"width":"400px","padding":"0","margin":"0 auto 10px","height":"auto"}' v-if="tableName=='gongsi'" prop="gongsijieshao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","left":"-100px","background":"none","display":"inline-block","width":"100px","lineHeight":"36px","fontSize":"14px","position":"absolute"}' :class="changeRules('gongsijieshao')?'required':''">公司介绍：</div>
			    <editor
			        :style='{"minHeight":"250px","border":"0px solid #1abc9e30","borderRadius":"0px","color":"#666","background":"#fff","width":"400px","clear":"both","minWidth":"300px","height":"auto"}'
			        v-model="registerForm.gongsijieshao" 
			        class="editor" 
			        action="file/upload">
			    </editor>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 auto","color":"#fff","display":"block","outline":"none","borderRadius":"4px","background":"#1e3c4f","width":"400px","fontSize":"16px","height":"44px","order":"30"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 0px","margin":"0px auto 20px","color":"#999","textAlign":"right","display":"block","outline":"none","borderRadius":"4px","background":"none","width":"400px","fontSize":"14px","height":"44px","order":"40"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 0px","margin":"0 auto 20px","color":"#1e3c4f","textAlign":"center","display":"block","width":"400px","lineHeight":"1","fontSize":"14px","textDecoration":"none","order":"20"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            qiuzhizhexingbieOptions: [],
            gongsigongsiguimoOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='qiuzhizhe'){
				this.registerForm = {
					qiuzhizhanghao: '',
					qiuzhixingming: '',
					mima: '',
					mima2: '',
					shoujihao: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					xueli: '',
					dianziyouxiang: '',
				}
			}
			if(this.tableName=='gongsi'){
				this.registerForm = {
					gongsizhanghao: '',
					gongsimingcheng: '',
					mima: '',
					mima2: '',
					lianxifangshi: '',
					touxiang: '',
					gongsiguimo: '',
					qiyedaibiao: '',
					chuanglishijian: '',
					gongsidizhi: '',
					fazhanlicheng: '',
					gongsijieshao: '',
					sfsh: '',
					shhf: '',
					storeupnum: '',
				}
			}
			if ('qiuzhizhe' == this.tableName) {
				this.requiredRules.qiuzhizhanghao = [{ required: true, message: '请输入求职账号', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.requiredRules.qiuzhixingming = [{ required: true, message: '请输入求职姓名', trigger: 'blur' }]
			}
			if ('qiuzhizhe' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('gongsi' == this.tableName) {
				this.requiredRules.gongsizhanghao = [{ required: true, message: '请输入公司账号', trigger: 'blur' }]
			}
			if ('gongsi' == this.tableName) {
				this.requiredRules.gongsimingcheng = [{ required: true, message: '请输入公司名称', trigger: 'blur' }]
			}
			if ('gongsi' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.qiuzhizhanghao = [{ required: true, message: '请输入求职账号', trigger: 'blur' }];
		  }
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.qiuzhixingming = [{ required: true, message: '请输入求职姓名', trigger: 'blur' }];
		  }
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.shoujihao = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
			this.qiuzhizhexingbieOptions = "男,女".split(',');
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('qiuzhizhe' == this.tableName) {
			this.rules.dianziyouxiang = [{ required: true, validator: this.$validate.isEmail, trigger: 'blur' }];
		  }
		  if ('gongsi' == this.tableName) {
			this.rules.gongsizhanghao = [{ required: true, message: '请输入公司账号', trigger: 'blur' }];
		  }
		  if ('gongsi' == this.tableName) {
			this.rules.gongsimingcheng = [{ required: true, message: '请输入公司名称', trigger: 'blur' }];
		  }
		  if ('gongsi' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('gongsi' == this.tableName) {
			this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
			this.gongsigongsiguimoOptions = "50人以下,100人以上,500人以上,1000人以上".split(',');
		  if ('gongsi' == this.tableName) {
			this.rules.storeupnum = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      qiuzhizhetouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      gongsitouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.qiuzhizhanghao) && `qiuzhizhe` == this.tableName){
					this.$message.error(`求职账号不能为空`);
					return
				}
				if((!this.registerForm.qiuzhixingming) && `qiuzhizhe` == this.tableName){
					this.$message.error(`求职姓名不能为空`);
					return
				}
               if(`qiuzhizhe` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `qiuzhizhe` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
					if(`qiuzhizhe` == this.tableName && this.registerForm.shoujihao &&(!this.$validate.isMobile2(this.registerForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
				if(`qiuzhizhe` == this.tableName && this.registerForm.nianling &&(!this.$validate.isIntNumer2(this.registerForm.nianling))){
					this.$message.error(`年龄应输入整数`);
					return
				}
					if(`qiuzhizhe` == this.tableName && this.registerForm.dianziyouxiang &&(!this.$validate.isEmail2(this.registerForm.dianziyouxiang))){
						this.$message.error(`电子邮箱应输入邮件格式`);
						return
					}
			  if(this.tableName=='gongsi'){
				  this.registerForm.sfsh = '待审核'
			  }
				if((!this.registerForm.gongsizhanghao) && `gongsi` == this.tableName){
					this.$message.error(`公司账号不能为空`);
					return
				}
				if((!this.registerForm.gongsimingcheng) && `gongsi` == this.tableName){
					this.$message.error(`公司名称不能为空`);
					return
				}
               if(`gongsi` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `gongsi` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
					if(`gongsi` == this.tableName && this.registerForm.lianxifangshi &&(!this.$validate.isMobile2(this.registerForm.lianxifangshi))){
						this.$message.error(`联系方式应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231128/4426e8245c254fa88b7032f81fb1e71b.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #333;
						border-width: 1px;
						border-style: solid;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #333;
						border-width: 1px;
						border-style: solid;
						min-width: 300px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #333;
						border-width: 1px;
						border-style: solid;
						min-width: 300px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #666;
						background: #fff;
						width: 400px;
						font-size: 14px;
						border-color: #333;
						border-width: 1px;
						border-style: solid;
						min-width: 300px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  cursor: pointer;
		  		  color: #002355;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #333;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  color: #002355;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #333;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  color: #002355;
		  		  font-weight: 600;
		  		  font-size: 32px;
		  		  border-color: #333;
		  		  line-height: 60px;
		  		  border-radius: 30px;
		  		  background: #fff;
		  		  width: 120px;
		  		  border-width: 1px;
		  		  border-style: solid;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 90px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>

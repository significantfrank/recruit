package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 面试申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@TableName("mianshishenqing")
public class MianshishenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MianshishenqingEntity() {
		
	}
	
	public MianshishenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 求职账号
	 */
					
	private String qiuzhizhanghao;
	
	/**
	 * 求职姓名
	 */
					
	private String qiuzhixingming;
	
	/**
	 * 学历
	 */
					
	private String xueli;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 申请标题
	 */
					
	private String shenqingbiaoti;
	
	/**
	 * 申请内容
	 */
					
	private String shenqingneirong;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
	/**
	 * 公司账号
	 */
					
	private String gongsizhanghao;
	
	/**
	 * 公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：求职账号
	 */
	public void setQiuzhizhanghao(String qiuzhizhanghao) {
		this.qiuzhizhanghao = qiuzhizhanghao;
	}
	/**
	 * 获取：求职账号
	 */
	public String getQiuzhizhanghao() {
		return qiuzhizhanghao;
	}
	/**
	 * 设置：求职姓名
	 */
	public void setQiuzhixingming(String qiuzhixingming) {
		this.qiuzhixingming = qiuzhixingming;
	}
	/**
	 * 获取：求职姓名
	 */
	public String getQiuzhixingming() {
		return qiuzhixingming;
	}
	/**
	 * 设置：学历
	 */
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	/**
	 * 获取：学历
	 */
	public String getXueli() {
		return xueli;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：申请标题
	 */
	public void setShenqingbiaoti(String shenqingbiaoti) {
		this.shenqingbiaoti = shenqingbiaoti;
	}
	/**
	 * 获取：申请标题
	 */
	public String getShenqingbiaoti() {
		return shenqingbiaoti;
	}
	/**
	 * 设置：申请内容
	 */
	public void setShenqingneirong(String shenqingneirong) {
		this.shenqingneirong = shenqingneirong;
	}
	/**
	 * 获取：申请内容
	 */
	public String getShenqingneirong() {
		return shenqingneirong;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
	/**
	 * 设置：公司账号
	 */
	public void setGongsizhanghao(String gongsizhanghao) {
		this.gongsizhanghao = gongsizhanghao;
	}
	/**
	 * 获取：公司账号
	 */
	public String getGongsizhanghao() {
		return gongsizhanghao;
	}
	/**
	 * 设置：公司名称
	 */
	public void setGongsimingcheng(String gongsimingcheng) {
		this.gongsimingcheng = gongsimingcheng;
	}
	/**
	 * 获取：公司名称
	 */
	public String getGongsimingcheng() {
		return gongsimingcheng;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}

}

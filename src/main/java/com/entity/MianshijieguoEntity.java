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
 * 面试结果
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@TableName("mianshijieguo")
public class MianshijieguoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MianshijieguoEntity() {
		
	}
	
	public MianshijieguoEntity(T t) {
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
	 * 职位名称
	 */
					
	private String zhiweimingcheng;
	
	/**
	 * 职位类型
	 */
					
	private String zhiweileixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 面试结果
	 */
					
	private String mianshijieguo;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 公司账号
	 */
					
	private String gongsizhanghao;
	
	/**
	 * 公司名称
	 */
					
	private String gongsimingcheng;
	
	/**
	 * 求职账号
	 */
					
	private String qiuzhizhanghao;
	
	/**
	 * 求职姓名
	 */
					
	private String qiuzhixingming;
	
	/**
	 * 结果详情
	 */
					
	private String jieguoxiangqing;
	
	
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
	 * 设置：职位名称
	 */
	public void setZhiweimingcheng(String zhiweimingcheng) {
		this.zhiweimingcheng = zhiweimingcheng;
	}
	/**
	 * 获取：职位名称
	 */
	public String getZhiweimingcheng() {
		return zhiweimingcheng;
	}
	/**
	 * 设置：职位类型
	 */
	public void setZhiweileixing(String zhiweileixing) {
		this.zhiweileixing = zhiweileixing;
	}
	/**
	 * 获取：职位类型
	 */
	public String getZhiweileixing() {
		return zhiweileixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：面试结果
	 */
	public void setMianshijieguo(String mianshijieguo) {
		this.mianshijieguo = mianshijieguo;
	}
	/**
	 * 获取：面试结果
	 */
	public String getMianshijieguo() {
		return mianshijieguo;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
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
	 * 设置：结果详情
	 */
	public void setJieguoxiangqing(String jieguoxiangqing) {
		this.jieguoxiangqing = jieguoxiangqing;
	}
	/**
	 * 获取：结果详情
	 */
	public String getJieguoxiangqing() {
		return jieguoxiangqing;
	}

}

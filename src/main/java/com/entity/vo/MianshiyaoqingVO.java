package com.entity.vo;

import com.entity.MianshiyaoqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 面试邀请
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
public class MianshiyaoqingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 职位类型
	 */
	
	private String zhiweileixing;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 邀请内容
	 */
	
	private String yaoqingneirong;
		
	/**
	 * 邀请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yaoqingshijian;
		
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
	 * 设置：邀请内容
	 */
	 
	public void setYaoqingneirong(String yaoqingneirong) {
		this.yaoqingneirong = yaoqingneirong;
	}
	
	/**
	 * 获取：邀请内容
	 */
	public String getYaoqingneirong() {
		return yaoqingneirong;
	}
				
	
	/**
	 * 设置：邀请时间
	 */
	 
	public void setYaoqingshijian(Date yaoqingshijian) {
		this.yaoqingshijian = yaoqingshijian;
	}
	
	/**
	 * 获取：邀请时间
	 */
	public Date getYaoqingshijian() {
		return yaoqingshijian;
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
			
}

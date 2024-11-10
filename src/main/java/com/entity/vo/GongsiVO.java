package com.entity.vo;

import com.entity.GongsiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 公司
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
public class GongsiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 公司名称
	 */
	
	private String gongsimingcheng;
		
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 公司规模
	 */
	
	private String gongsiguimo;
		
	/**
	 * 企业代表
	 */
	
	private String qiyedaibiao;
		
	/**
	 * 创立时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chuanglishijian;
		
	/**
	 * 公司地址
	 */
	
	private String gongsidizhi;
		
	/**
	 * 发展历程
	 */
	
	private String fazhanlicheng;
		
	/**
	 * 公司介绍
	 */
	
	private String gongsijieshao;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
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
	 * 设置：公司规模
	 */
	 
	public void setGongsiguimo(String gongsiguimo) {
		this.gongsiguimo = gongsiguimo;
	}
	
	/**
	 * 获取：公司规模
	 */
	public String getGongsiguimo() {
		return gongsiguimo;
	}
				
	
	/**
	 * 设置：企业代表
	 */
	 
	public void setQiyedaibiao(String qiyedaibiao) {
		this.qiyedaibiao = qiyedaibiao;
	}
	
	/**
	 * 获取：企业代表
	 */
	public String getQiyedaibiao() {
		return qiyedaibiao;
	}
				
	
	/**
	 * 设置：创立时间
	 */
	 
	public void setChuanglishijian(Date chuanglishijian) {
		this.chuanglishijian = chuanglishijian;
	}
	
	/**
	 * 获取：创立时间
	 */
	public Date getChuanglishijian() {
		return chuanglishijian;
	}
				
	
	/**
	 * 设置：公司地址
	 */
	 
	public void setGongsidizhi(String gongsidizhi) {
		this.gongsidizhi = gongsidizhi;
	}
	
	/**
	 * 获取：公司地址
	 */
	public String getGongsidizhi() {
		return gongsidizhi;
	}
				
	
	/**
	 * 设置：发展历程
	 */
	 
	public void setFazhanlicheng(String fazhanlicheng) {
		this.fazhanlicheng = fazhanlicheng;
	}
	
	/**
	 * 获取：发展历程
	 */
	public String getFazhanlicheng() {
		return fazhanlicheng;
	}
				
	
	/**
	 * 设置：公司介绍
	 */
	 
	public void setGongsijieshao(String gongsijieshao) {
		this.gongsijieshao = gongsijieshao;
	}
	
	/**
	 * 获取：公司介绍
	 */
	public String getGongsijieshao() {
		return gongsijieshao;
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
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}

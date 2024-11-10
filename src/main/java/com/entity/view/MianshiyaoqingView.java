package com.entity.view;

import com.entity.MianshiyaoqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 面试邀请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@TableName("mianshiyaoqing")
public class MianshiyaoqingView  extends MianshiyaoqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MianshiyaoqingView(){
	}
 
 	public MianshiyaoqingView(MianshiyaoqingEntity mianshiyaoqingEntity){
 	try {
			BeanUtils.copyProperties(this, mianshiyaoqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

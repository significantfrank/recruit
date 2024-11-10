package com.entity.view;

import com.entity.GerenjianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 个人简历
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@TableName("gerenjianli")
public class GerenjianliView  extends GerenjianliEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GerenjianliView(){
	}
 
 	public GerenjianliView(GerenjianliEntity gerenjianliEntity){
 	try {
			BeanUtils.copyProperties(this, gerenjianliEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

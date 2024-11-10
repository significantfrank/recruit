package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MianshishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MianshishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MianshishenqingView;


/**
 * 面试申请
 *
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
public interface MianshishenqingService extends IService<MianshishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MianshishenqingVO> selectListVO(Wrapper<MianshishenqingEntity> wrapper);
   	
   	MianshishenqingVO selectVO(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);
   	
   	List<MianshishenqingView> selectListView(Wrapper<MianshishenqingEntity> wrapper);
   	
   	MianshishenqingView selectView(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MianshishenqingEntity> wrapper);

   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiweileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiweileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiweileixingView;


/**
 * 职位类型
 *
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
public interface ZhiweileixingService extends IService<ZhiweileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiweileixingVO> selectListVO(Wrapper<ZhiweileixingEntity> wrapper);
   	
   	ZhiweileixingVO selectVO(@Param("ew") Wrapper<ZhiweileixingEntity> wrapper);
   	
   	List<ZhiweileixingView> selectListView(Wrapper<ZhiweileixingEntity> wrapper);
   	
   	ZhiweileixingView selectView(@Param("ew") Wrapper<ZhiweileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiweileixingEntity> wrapper);

   	

}


package com.dao;

import com.entity.MianshishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MianshishenqingVO;
import com.entity.view.MianshishenqingView;


/**
 * 面试申请
 * 
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
public interface MianshishenqingDao extends BaseMapper<MianshishenqingEntity> {
	
	List<MianshishenqingVO> selectListVO(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);
	
	MianshishenqingVO selectVO(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);
	
	List<MianshishenqingView> selectListView(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);

	List<MianshishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<MianshishenqingEntity> wrapper);

	
	MianshishenqingView selectView(@Param("ew") Wrapper<MianshishenqingEntity> wrapper);
	

}

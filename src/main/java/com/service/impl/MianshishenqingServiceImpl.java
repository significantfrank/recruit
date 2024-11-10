package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MianshishenqingDao;
import com.entity.MianshishenqingEntity;
import com.service.MianshishenqingService;
import com.entity.vo.MianshishenqingVO;
import com.entity.view.MianshishenqingView;

@Service("mianshishenqingService")
public class MianshishenqingServiceImpl extends ServiceImpl<MianshishenqingDao, MianshishenqingEntity> implements MianshishenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MianshishenqingEntity> page = this.selectPage(
                new Query<MianshishenqingEntity>(params).getPage(),
                new EntityWrapper<MianshishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MianshishenqingEntity> wrapper) {
		  Page<MianshishenqingView> page =new Query<MianshishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MianshishenqingVO> selectListVO(Wrapper<MianshishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MianshishenqingVO selectVO(Wrapper<MianshishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MianshishenqingView> selectListView(Wrapper<MianshishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MianshishenqingView selectView(Wrapper<MianshishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

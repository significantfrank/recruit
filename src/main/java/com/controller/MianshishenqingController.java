package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MianshishenqingEntity;
import com.entity.view.MianshishenqingView;

import com.service.MianshishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 面试申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@RestController
@RequestMapping("/mianshishenqing")
public class MianshishenqingController {
    @Autowired
    private MianshishenqingService mianshishenqingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MianshishenqingEntity mianshishenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiuzhizhe")) {
			mianshishenqing.setQiuzhizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongsi")) {
			mianshishenqing.setGongsizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MianshishenqingEntity> ew = new EntityWrapper<MianshishenqingEntity>();

		PageUtils page = mianshishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshishenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MianshishenqingEntity mianshishenqing, 
		HttpServletRequest request){
        EntityWrapper<MianshishenqingEntity> ew = new EntityWrapper<MianshishenqingEntity>();

		PageUtils page = mianshishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mianshishenqing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MianshishenqingEntity mianshishenqing){
       	EntityWrapper<MianshishenqingEntity> ew = new EntityWrapper<MianshishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mianshishenqing, "mianshishenqing")); 
        return R.ok().put("data", mianshishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MianshishenqingEntity mianshishenqing){
        EntityWrapper< MianshishenqingEntity> ew = new EntityWrapper< MianshishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mianshishenqing, "mianshishenqing")); 
		MianshishenqingView mianshishenqingView =  mianshishenqingService.selectView(ew);
		return R.ok("查询面试申请成功").put("data", mianshishenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MianshishenqingEntity mianshishenqing = mianshishenqingService.selectById(id);
        return R.ok().put("data", mianshishenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MianshishenqingEntity mianshishenqing = mianshishenqingService.selectById(id);
        return R.ok().put("data", mianshishenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MianshishenqingEntity mianshishenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mianshishenqing);
        mianshishenqingService.insert(mianshishenqing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MianshishenqingEntity mianshishenqing, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mianshishenqing);
        mianshishenqingService.insert(mianshishenqing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MianshishenqingEntity mianshishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mianshishenqing);
        mianshishenqingService.updateById(mianshishenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<MianshishenqingEntity> list = new ArrayList<MianshishenqingEntity>();
        for(Long id : ids) {
            MianshishenqingEntity mianshishenqing = mianshishenqingService.selectById(id);
            mianshishenqing.setSfsh(sfsh);
            mianshishenqing.setShhf(shhf);
            list.add(mianshishenqing);
        }
        mianshishenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mianshishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}

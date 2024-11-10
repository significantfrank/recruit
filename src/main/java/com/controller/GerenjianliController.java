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

import com.entity.GerenjianliEntity;
import com.entity.view.GerenjianliView;

import com.service.GerenjianliService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 个人简历
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-05 14:41:23
 */
@RestController
@RequestMapping("/gerenjianli")
public class GerenjianliController {
    @Autowired
    private GerenjianliService gerenjianliService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GerenjianliEntity gerenjianli,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiuzhizhe")) {
			gerenjianli.setQiuzhizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GerenjianliEntity> ew = new EntityWrapper<GerenjianliEntity>();

		PageUtils page = gerenjianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gerenjianli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GerenjianliEntity gerenjianli, 
		HttpServletRequest request){
        EntityWrapper<GerenjianliEntity> ew = new EntityWrapper<GerenjianliEntity>();

		PageUtils page = gerenjianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gerenjianli), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GerenjianliEntity gerenjianli){
       	EntityWrapper<GerenjianliEntity> ew = new EntityWrapper<GerenjianliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gerenjianli, "gerenjianli")); 
        return R.ok().put("data", gerenjianliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GerenjianliEntity gerenjianli){
        EntityWrapper< GerenjianliEntity> ew = new EntityWrapper< GerenjianliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gerenjianli, "gerenjianli")); 
		GerenjianliView gerenjianliView =  gerenjianliService.selectView(ew);
		return R.ok("查询个人简历成功").put("data", gerenjianliView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GerenjianliEntity gerenjianli = gerenjianliService.selectById(id);
		gerenjianli.setClicknum(gerenjianli.getClicknum()+1);
		gerenjianli.setClicktime(new Date());
		gerenjianliService.updateById(gerenjianli);
        gerenjianli = gerenjianliService.selectView(new EntityWrapper<GerenjianliEntity>().eq("id", id));
        return R.ok().put("data", gerenjianli);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GerenjianliEntity gerenjianli = gerenjianliService.selectById(id);
		gerenjianli.setClicknum(gerenjianli.getClicknum()+1);
		gerenjianli.setClicktime(new Date());
		gerenjianliService.updateById(gerenjianli);
        gerenjianli = gerenjianliService.selectView(new EntityWrapper<GerenjianliEntity>().eq("id", id));
        return R.ok().put("data", gerenjianli);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GerenjianliEntity gerenjianli, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gerenjianli);
        gerenjianliService.insert(gerenjianli);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GerenjianliEntity gerenjianli, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gerenjianli);
        gerenjianliService.insert(gerenjianli);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GerenjianliEntity gerenjianli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gerenjianli);
        gerenjianliService.updateById(gerenjianli);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gerenjianliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GerenjianliEntity gerenjianli, HttpServletRequest request,String pre){
        EntityWrapper<GerenjianliEntity> ew = new EntityWrapper<GerenjianliEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = gerenjianliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gerenjianli), params), params));
        return R.ok().put("data", page);
    }










}

package com.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PeixunbanEntity;
import com.entity.view.PeixunbanView;

import com.service.PeixunbanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 培训班
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@RestController
@RequestMapping("/peixunban")
public class PeixunbanController {
    @Autowired
    private PeixunbanService peixunbanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PeixunbanEntity peixunban, HttpServletRequest request){

        EntityWrapper<PeixunbanEntity> ew = new EntityWrapper<PeixunbanEntity>();
		PageUtils page = peixunbanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunban), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PeixunbanEntity peixunban, HttpServletRequest request){
        EntityWrapper<PeixunbanEntity> ew = new EntityWrapper<PeixunbanEntity>();
		PageUtils page = peixunbanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, peixunban), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PeixunbanEntity peixunban){
       	EntityWrapper<PeixunbanEntity> ew = new EntityWrapper<PeixunbanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( peixunban, "peixunban")); 
        return R.ok().put("data", peixunbanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PeixunbanEntity peixunban){
        EntityWrapper< PeixunbanEntity> ew = new EntityWrapper< PeixunbanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( peixunban, "peixunban")); 
		PeixunbanView peixunbanView =  peixunbanService.selectView(ew);
		return R.ok("查询培训班成功").put("data", peixunbanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PeixunbanEntity peixunban = peixunbanService.selectById(id);
        return R.ok().put("data", peixunban);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PeixunbanEntity peixunban = peixunbanService.selectById(id);
        return R.ok().put("data", peixunban);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        PeixunbanEntity peixunban = peixunbanService.selectById(id);
        if(type.equals("1")) {
        	peixunban.setThumbsupnum(peixunban.getThumbsupnum()+1);
        } else {
        	peixunban.setCrazilynum(peixunban.getCrazilynum()+1);
        }
        peixunbanService.updateById(peixunban);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PeixunbanEntity peixunban, HttpServletRequest request){
    	peixunban.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunban);

        peixunbanService.insert(peixunban);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PeixunbanEntity peixunban, HttpServletRequest request){
    	peixunban.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(peixunban);

        peixunbanService.insert(peixunban);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PeixunbanEntity peixunban, HttpServletRequest request){
        //ValidatorUtils.validateEntity(peixunban);
        peixunbanService.updateById(peixunban);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        peixunbanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PeixunbanEntity> wrapper = new EntityWrapper<PeixunbanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = peixunbanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

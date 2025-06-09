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

import com.entity.QiyewenhuaEntity;
import com.entity.view.QiyewenhuaView;

import com.service.QiyewenhuaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 企业文化
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@RestController
@RequestMapping("/qiyewenhua")
public class QiyewenhuaController {
    @Autowired
    private QiyewenhuaService qiyewenhuaService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyewenhuaEntity qiyewenhua, HttpServletRequest request){

        EntityWrapper<QiyewenhuaEntity> ew = new EntityWrapper<QiyewenhuaEntity>();
		PageUtils page = qiyewenhuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiyewenhua), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiyewenhuaEntity qiyewenhua, HttpServletRequest request){
        EntityWrapper<QiyewenhuaEntity> ew = new EntityWrapper<QiyewenhuaEntity>();
		PageUtils page = qiyewenhuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiyewenhua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyewenhuaEntity qiyewenhua){
       	EntityWrapper<QiyewenhuaEntity> ew = new EntityWrapper<QiyewenhuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiyewenhua, "qiyewenhua")); 
        return R.ok().put("data", qiyewenhuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyewenhuaEntity qiyewenhua){
        EntityWrapper< QiyewenhuaEntity> ew = new EntityWrapper< QiyewenhuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiyewenhua, "qiyewenhua")); 
		QiyewenhuaView qiyewenhuaView =  qiyewenhuaService.selectView(ew);
		return R.ok("查询企业文化成功").put("data", qiyewenhuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyewenhuaEntity qiyewenhua = qiyewenhuaService.selectById(id);
        return R.ok().put("data", qiyewenhua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyewenhuaEntity qiyewenhua = qiyewenhuaService.selectById(id);
        return R.ok().put("data", qiyewenhua);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        QiyewenhuaEntity qiyewenhua = qiyewenhuaService.selectById(id);
        if(type.equals("1")) {
        	qiyewenhua.setThumbsupnum(qiyewenhua.getThumbsupnum()+1);
        } else {
        	qiyewenhua.setCrazilynum(qiyewenhua.getCrazilynum()+1);
        }
        qiyewenhuaService.updateById(qiyewenhua);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiyewenhuaEntity qiyewenhua, HttpServletRequest request){
    	qiyewenhua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiyewenhua);

        qiyewenhuaService.insert(qiyewenhua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiyewenhuaEntity qiyewenhua, HttpServletRequest request){
    	qiyewenhua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qiyewenhua);

        qiyewenhuaService.insert(qiyewenhua);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QiyewenhuaEntity qiyewenhua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiyewenhua);
        qiyewenhuaService.updateById(qiyewenhua);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiyewenhuaService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QiyewenhuaEntity> wrapper = new EntityWrapper<QiyewenhuaEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = qiyewenhuaService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

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


import com.dao.PeixunbanbaomingDao;
import com.entity.PeixunbanbaomingEntity;
import com.service.PeixunbanbaomingService;
import com.entity.vo.PeixunbanbaomingVO;
import com.entity.view.PeixunbanbaomingView;

@Service("peixunbanbaomingService")
public class PeixunbanbaomingServiceImpl extends ServiceImpl<PeixunbanbaomingDao, PeixunbanbaomingEntity> implements PeixunbanbaomingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunbanbaomingEntity> page = this.selectPage(
                new Query<PeixunbanbaomingEntity>(params).getPage(),
                new EntityWrapper<PeixunbanbaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunbanbaomingEntity> wrapper) {
		  Page<PeixunbanbaomingView> page =new Query<PeixunbanbaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeixunbanbaomingVO> selectListVO(Wrapper<PeixunbanbaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeixunbanbaomingVO selectVO(Wrapper<PeixunbanbaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeixunbanbaomingView> selectListView(Wrapper<PeixunbanbaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunbanbaomingView selectView(Wrapper<PeixunbanbaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

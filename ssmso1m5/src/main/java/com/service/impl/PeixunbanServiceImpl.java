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


import com.dao.PeixunbanDao;
import com.entity.PeixunbanEntity;
import com.service.PeixunbanService;
import com.entity.vo.PeixunbanVO;
import com.entity.view.PeixunbanView;

@Service("peixunbanService")
public class PeixunbanServiceImpl extends ServiceImpl<PeixunbanDao, PeixunbanEntity> implements PeixunbanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunbanEntity> page = this.selectPage(
                new Query<PeixunbanEntity>(params).getPage(),
                new EntityWrapper<PeixunbanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunbanEntity> wrapper) {
		  Page<PeixunbanView> page =new Query<PeixunbanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeixunbanVO> selectListVO(Wrapper<PeixunbanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeixunbanVO selectVO(Wrapper<PeixunbanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeixunbanView> selectListView(Wrapper<PeixunbanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunbanView selectView(Wrapper<PeixunbanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

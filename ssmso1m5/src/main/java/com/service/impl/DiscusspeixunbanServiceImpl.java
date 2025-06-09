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


import com.dao.DiscusspeixunbanDao;
import com.entity.DiscusspeixunbanEntity;
import com.service.DiscusspeixunbanService;
import com.entity.vo.DiscusspeixunbanVO;
import com.entity.view.DiscusspeixunbanView;

@Service("discusspeixunbanService")
public class DiscusspeixunbanServiceImpl extends ServiceImpl<DiscusspeixunbanDao, DiscusspeixunbanEntity> implements DiscusspeixunbanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusspeixunbanEntity> page = this.selectPage(
                new Query<DiscusspeixunbanEntity>(params).getPage(),
                new EntityWrapper<DiscusspeixunbanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusspeixunbanEntity> wrapper) {
		  Page<DiscusspeixunbanView> page =new Query<DiscusspeixunbanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusspeixunbanVO> selectListVO(Wrapper<DiscusspeixunbanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusspeixunbanVO selectVO(Wrapper<DiscusspeixunbanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusspeixunbanView> selectListView(Wrapper<DiscusspeixunbanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusspeixunbanView selectView(Wrapper<DiscusspeixunbanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

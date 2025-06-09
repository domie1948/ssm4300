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


import com.dao.DiscussqiyewenhuaDao;
import com.entity.DiscussqiyewenhuaEntity;
import com.service.DiscussqiyewenhuaService;
import com.entity.vo.DiscussqiyewenhuaVO;
import com.entity.view.DiscussqiyewenhuaView;

@Service("discussqiyewenhuaService")
public class DiscussqiyewenhuaServiceImpl extends ServiceImpl<DiscussqiyewenhuaDao, DiscussqiyewenhuaEntity> implements DiscussqiyewenhuaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqiyewenhuaEntity> page = this.selectPage(
                new Query<DiscussqiyewenhuaEntity>(params).getPage(),
                new EntityWrapper<DiscussqiyewenhuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqiyewenhuaEntity> wrapper) {
		  Page<DiscussqiyewenhuaView> page =new Query<DiscussqiyewenhuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussqiyewenhuaVO> selectListVO(Wrapper<DiscussqiyewenhuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqiyewenhuaVO selectVO(Wrapper<DiscussqiyewenhuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqiyewenhuaView> selectListView(Wrapper<DiscussqiyewenhuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqiyewenhuaView selectView(Wrapper<DiscussqiyewenhuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

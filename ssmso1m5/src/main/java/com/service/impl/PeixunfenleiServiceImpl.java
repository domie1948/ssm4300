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


import com.dao.PeixunfenleiDao;
import com.entity.PeixunfenleiEntity;
import com.service.PeixunfenleiService;
import com.entity.vo.PeixunfenleiVO;
import com.entity.view.PeixunfenleiView;

@Service("peixunfenleiService")
public class PeixunfenleiServiceImpl extends ServiceImpl<PeixunfenleiDao, PeixunfenleiEntity> implements PeixunfenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunfenleiEntity> page = this.selectPage(
                new Query<PeixunfenleiEntity>(params).getPage(),
                new EntityWrapper<PeixunfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunfenleiEntity> wrapper) {
		  Page<PeixunfenleiView> page =new Query<PeixunfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PeixunfenleiVO> selectListVO(Wrapper<PeixunfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PeixunfenleiVO selectVO(Wrapper<PeixunfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PeixunfenleiView> selectListView(Wrapper<PeixunfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunfenleiView selectView(Wrapper<PeixunfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

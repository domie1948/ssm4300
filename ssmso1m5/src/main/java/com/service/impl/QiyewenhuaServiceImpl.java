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


import com.dao.QiyewenhuaDao;
import com.entity.QiyewenhuaEntity;
import com.service.QiyewenhuaService;
import com.entity.vo.QiyewenhuaVO;
import com.entity.view.QiyewenhuaView;

@Service("qiyewenhuaService")
public class QiyewenhuaServiceImpl extends ServiceImpl<QiyewenhuaDao, QiyewenhuaEntity> implements QiyewenhuaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiyewenhuaEntity> page = this.selectPage(
                new Query<QiyewenhuaEntity>(params).getPage(),
                new EntityWrapper<QiyewenhuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiyewenhuaEntity> wrapper) {
		  Page<QiyewenhuaView> page =new Query<QiyewenhuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QiyewenhuaVO> selectListVO(Wrapper<QiyewenhuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiyewenhuaVO selectVO(Wrapper<QiyewenhuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiyewenhuaView> selectListView(Wrapper<QiyewenhuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiyewenhuaView selectView(Wrapper<QiyewenhuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

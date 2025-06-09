package com.dao;

import com.entity.QiyewenhuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiyewenhuaVO;
import com.entity.view.QiyewenhuaView;


/**
 * 企业文化
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface QiyewenhuaDao extends BaseMapper<QiyewenhuaEntity> {
	
	List<QiyewenhuaVO> selectListVO(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
	
	QiyewenhuaVO selectVO(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
	
	List<QiyewenhuaView> selectListView(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);

	List<QiyewenhuaView> selectListView(Pagination page,@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
	
	QiyewenhuaView selectView(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
	
}

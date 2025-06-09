package com.dao;

import com.entity.PeixunbanbaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeixunbanbaomingVO;
import com.entity.view.PeixunbanbaomingView;


/**
 * 培训班报名
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunbanbaomingDao extends BaseMapper<PeixunbanbaomingEntity> {
	
	List<PeixunbanbaomingVO> selectListVO(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
	
	PeixunbanbaomingVO selectVO(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
	
	List<PeixunbanbaomingView> selectListView(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);

	List<PeixunbanbaomingView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
	
	PeixunbanbaomingView selectView(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
	
}

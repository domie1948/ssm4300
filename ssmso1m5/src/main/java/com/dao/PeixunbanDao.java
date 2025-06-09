package com.dao;

import com.entity.PeixunbanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeixunbanVO;
import com.entity.view.PeixunbanView;


/**
 * 培训班
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunbanDao extends BaseMapper<PeixunbanEntity> {
	
	List<PeixunbanVO> selectListVO(@Param("ew") Wrapper<PeixunbanEntity> wrapper);
	
	PeixunbanVO selectVO(@Param("ew") Wrapper<PeixunbanEntity> wrapper);
	
	List<PeixunbanView> selectListView(@Param("ew") Wrapper<PeixunbanEntity> wrapper);

	List<PeixunbanView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunbanEntity> wrapper);
	
	PeixunbanView selectView(@Param("ew") Wrapper<PeixunbanEntity> wrapper);
	
}

package com.dao;

import com.entity.DiscusspeixunbanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusspeixunbanVO;
import com.entity.view.DiscusspeixunbanView;


/**
 * 培训班评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface DiscusspeixunbanDao extends BaseMapper<DiscusspeixunbanEntity> {
	
	List<DiscusspeixunbanVO> selectListVO(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
	
	DiscusspeixunbanVO selectVO(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
	
	List<DiscusspeixunbanView> selectListView(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);

	List<DiscusspeixunbanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
	
	DiscusspeixunbanView selectView(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
	
}

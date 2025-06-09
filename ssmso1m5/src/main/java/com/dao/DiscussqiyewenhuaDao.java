package com.dao;

import com.entity.DiscussqiyewenhuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqiyewenhuaVO;
import com.entity.view.DiscussqiyewenhuaView;


/**
 * 企业文化评论表
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface DiscussqiyewenhuaDao extends BaseMapper<DiscussqiyewenhuaEntity> {
	
	List<DiscussqiyewenhuaVO> selectListVO(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
	
	DiscussqiyewenhuaVO selectVO(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
	
	List<DiscussqiyewenhuaView> selectListView(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);

	List<DiscussqiyewenhuaView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
	
	DiscussqiyewenhuaView selectView(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
	
}

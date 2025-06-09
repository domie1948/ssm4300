package com.dao;

import com.entity.PeixunfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PeixunfenleiVO;
import com.entity.view.PeixunfenleiView;


/**
 * 培训分类
 * 
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunfenleiDao extends BaseMapper<PeixunfenleiEntity> {
	
	List<PeixunfenleiVO> selectListVO(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
	
	PeixunfenleiVO selectVO(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
	
	List<PeixunfenleiView> selectListView(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);

	List<PeixunfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
	
	PeixunfenleiView selectView(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
	
}

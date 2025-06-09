package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeixunbanbaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeixunbanbaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunbanbaomingView;


/**
 * 培训班报名
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunbanbaomingService extends IService<PeixunbanbaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunbanbaomingVO> selectListVO(Wrapper<PeixunbanbaomingEntity> wrapper);
   	
   	PeixunbanbaomingVO selectVO(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
   	
   	List<PeixunbanbaomingView> selectListView(Wrapper<PeixunbanbaomingEntity> wrapper);
   	
   	PeixunbanbaomingView selectView(@Param("ew") Wrapper<PeixunbanbaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunbanbaomingEntity> wrapper);
   	
}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusspeixunbanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusspeixunbanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusspeixunbanView;


/**
 * 培训班评论表
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface DiscusspeixunbanService extends IService<DiscusspeixunbanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusspeixunbanVO> selectListVO(Wrapper<DiscusspeixunbanEntity> wrapper);
   	
   	DiscusspeixunbanVO selectVO(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
   	
   	List<DiscusspeixunbanView> selectListView(Wrapper<DiscusspeixunbanEntity> wrapper);
   	
   	DiscusspeixunbanView selectView(@Param("ew") Wrapper<DiscusspeixunbanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusspeixunbanEntity> wrapper);
   	
}


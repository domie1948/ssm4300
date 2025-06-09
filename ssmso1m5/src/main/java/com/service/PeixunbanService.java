package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeixunbanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeixunbanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunbanView;


/**
 * 培训班
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunbanService extends IService<PeixunbanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunbanVO> selectListVO(Wrapper<PeixunbanEntity> wrapper);
   	
   	PeixunbanVO selectVO(@Param("ew") Wrapper<PeixunbanEntity> wrapper);
   	
   	List<PeixunbanView> selectListView(Wrapper<PeixunbanEntity> wrapper);
   	
   	PeixunbanView selectView(@Param("ew") Wrapper<PeixunbanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunbanEntity> wrapper);
   	
}


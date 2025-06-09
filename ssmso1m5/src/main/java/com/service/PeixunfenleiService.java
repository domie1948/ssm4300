package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PeixunfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PeixunfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PeixunfenleiView;


/**
 * 培训分类
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface PeixunfenleiService extends IService<PeixunfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunfenleiVO> selectListVO(Wrapper<PeixunfenleiEntity> wrapper);
   	
   	PeixunfenleiVO selectVO(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
   	
   	List<PeixunfenleiView> selectListView(Wrapper<PeixunfenleiEntity> wrapper);
   	
   	PeixunfenleiView selectView(@Param("ew") Wrapper<PeixunfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunfenleiEntity> wrapper);
   	
}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiyewenhuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiyewenhuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiyewenhuaView;


/**
 * 企业文化
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface QiyewenhuaService extends IService<QiyewenhuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiyewenhuaVO> selectListVO(Wrapper<QiyewenhuaEntity> wrapper);
   	
   	QiyewenhuaVO selectVO(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
   	
   	List<QiyewenhuaView> selectListView(Wrapper<QiyewenhuaEntity> wrapper);
   	
   	QiyewenhuaView selectView(@Param("ew") Wrapper<QiyewenhuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiyewenhuaEntity> wrapper);
   	
}


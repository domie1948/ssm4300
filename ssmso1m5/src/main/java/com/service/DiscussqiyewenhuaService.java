package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqiyewenhuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqiyewenhuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqiyewenhuaView;


/**
 * 企业文化评论表
 *
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
public interface DiscussqiyewenhuaService extends IService<DiscussqiyewenhuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqiyewenhuaVO> selectListVO(Wrapper<DiscussqiyewenhuaEntity> wrapper);
   	
   	DiscussqiyewenhuaVO selectVO(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
   	
   	List<DiscussqiyewenhuaView> selectListView(Wrapper<DiscussqiyewenhuaEntity> wrapper);
   	
   	DiscussqiyewenhuaView selectView(@Param("ew") Wrapper<DiscussqiyewenhuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqiyewenhuaEntity> wrapper);
   	
}


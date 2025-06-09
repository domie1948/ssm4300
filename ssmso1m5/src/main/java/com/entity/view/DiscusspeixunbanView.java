package com.entity.view;

import com.entity.DiscusspeixunbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 培训班评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@TableName("discusspeixunban")
public class DiscusspeixunbanView  extends DiscusspeixunbanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusspeixunbanView(){
	}
 
 	public DiscusspeixunbanView(DiscusspeixunbanEntity discusspeixunbanEntity){
 	try {
			BeanUtils.copyProperties(this, discusspeixunbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

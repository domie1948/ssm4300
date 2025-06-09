package com.entity.view;

import com.entity.PeixunbanbaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 培训班报名
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@TableName("peixunbanbaoming")
public class PeixunbanbaomingView  extends PeixunbanbaomingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeixunbanbaomingView(){
	}
 
 	public PeixunbanbaomingView(PeixunbanbaomingEntity peixunbanbaomingEntity){
 	try {
			BeanUtils.copyProperties(this, peixunbanbaomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

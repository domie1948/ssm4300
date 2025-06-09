package com.entity.view;

import com.entity.PeixunbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 培训班
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@TableName("peixunban")
public class PeixunbanView  extends PeixunbanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PeixunbanView(){
	}
 
 	public PeixunbanView(PeixunbanEntity peixunbanEntity){
 	try {
			BeanUtils.copyProperties(this, peixunbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

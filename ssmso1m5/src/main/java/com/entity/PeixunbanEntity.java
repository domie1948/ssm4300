package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 培训班
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-29 22:44:03
 */
@TableName("peixunban")
public class PeixunbanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PeixunbanEntity() {
		
	}
	
	public PeixunbanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 培训班编号
	 */
					
	private String peixunbanbianhao;
	
	/**
	 * 培训班名称
	 */
					
	private String peixunbanmingcheng;
	
	/**
	 * 培训类型
	 */
					
	private String peixunleixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 价格
	 */
					
	private String jiage;
	
	/**
	 * 课时
	 */
					
	private String keshi;
	
	/**
	 * 上课时间
	 */
					
	private String shangkeshijian;
	
	/**
	 * 上课地点
	 */
					
	private String shangkedidian;
	
	/**
	 * 讲师介绍
	 */
					
	private String jiangshijieshao;
	
	/**
	 * 课程介绍
	 */
					
	private String kechengjieshao;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：培训班编号
	 */
	public void setPeixunbanbianhao(String peixunbanbianhao) {
		this.peixunbanbianhao = peixunbanbianhao;
	}
	/**
	 * 获取：培训班编号
	 */
	public String getPeixunbanbianhao() {
		return peixunbanbianhao;
	}
	/**
	 * 设置：培训班名称
	 */
	public void setPeixunbanmingcheng(String peixunbanmingcheng) {
		this.peixunbanmingcheng = peixunbanmingcheng;
	}
	/**
	 * 获取：培训班名称
	 */
	public String getPeixunbanmingcheng() {
		return peixunbanmingcheng;
	}
	/**
	 * 设置：培训类型
	 */
	public void setPeixunleixing(String peixunleixing) {
		this.peixunleixing = peixunleixing;
	}
	/**
	 * 获取：培训类型
	 */
	public String getPeixunleixing() {
		return peixunleixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public String getJiage() {
		return jiage;
	}
	/**
	 * 设置：课时
	 */
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	/**
	 * 获取：课时
	 */
	public String getKeshi() {
		return keshi;
	}
	/**
	 * 设置：上课时间
	 */
	public void setShangkeshijian(String shangkeshijian) {
		this.shangkeshijian = shangkeshijian;
	}
	/**
	 * 获取：上课时间
	 */
	public String getShangkeshijian() {
		return shangkeshijian;
	}
	/**
	 * 设置：上课地点
	 */
	public void setShangkedidian(String shangkedidian) {
		this.shangkedidian = shangkedidian;
	}
	/**
	 * 获取：上课地点
	 */
	public String getShangkedidian() {
		return shangkedidian;
	}
	/**
	 * 设置：讲师介绍
	 */
	public void setJiangshijieshao(String jiangshijieshao) {
		this.jiangshijieshao = jiangshijieshao;
	}
	/**
	 * 获取：讲师介绍
	 */
	public String getJiangshijieshao() {
		return jiangshijieshao;
	}
	/**
	 * 设置：课程介绍
	 */
	public void setKechengjieshao(String kechengjieshao) {
		this.kechengjieshao = kechengjieshao;
	}
	/**
	 * 获取：课程介绍
	 */
	public String getKechengjieshao() {
		return kechengjieshao;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}

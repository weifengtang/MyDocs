package com.china.army.manager.modules.base.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 车辆管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@Data
@TableName("base_car")
@EqualsAndHashCode(callSuper = true)
public class BaseCar extends Model<BaseCar> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Integer id;
		//编号
		private Integer carid;
		//名称
		private String carname;
		//入装时间
		private Date cartime;
		//司机
		private String cardriver;
		//用途
		private String caruse;
		//车型
		private String cartype;
		//价格
		private String carprice;
		//颜色
		private String carcolor;
	
}

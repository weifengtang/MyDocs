package com.china.army.manager.modules.base.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 单位管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@Data
@TableName("base_unit")
@EqualsAndHashCode(callSuper = true)
public class BaseUnit extends Model<BaseUnit> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Long id;
		//单位名称
		private String unitname;
		//军事主官
		private String leadername;
		//政治主官
		private String leadername2;
		//单位领导id
		private Long leaderUserId;
		//单位驻址
		private String adderss;
		//单位电话
		private String phone;
		//公告信息
		private String naticemsg;
		//备注
		private String remark;
	
}

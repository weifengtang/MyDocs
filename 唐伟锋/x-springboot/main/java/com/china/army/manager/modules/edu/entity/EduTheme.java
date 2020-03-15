package com.china.army.manager.modules.edu.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 教育主题管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 12:51:23
 */
@Data
@TableName("edu_theme")
@EqualsAndHashCode(callSuper = true)
public class EduTheme extends Model<EduTheme> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Integer id;
		//主题
		private String edutypename;
		//创建人
		private String eautypecreateuser;
		//创建单位
		private String edutypecreateunit;
		//负责领导
		private String edutypecreateleader;
		//创建时间
		private Date edutypecreatetime;
		//标识
		private String flag;
	
}

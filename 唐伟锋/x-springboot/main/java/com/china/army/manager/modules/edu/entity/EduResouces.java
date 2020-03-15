package com.china.army.manager.modules.edu.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 教育资源管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 12:38:31
 */
@Data
@TableName("edu_resouces")
@EqualsAndHashCode(callSuper = true)
public class EduResouces extends Model<EduResouces> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Integer id;
		//类型id
		private Integer edutypeid;
		//标题
		private String eduname;
		//小标题
		private String edusecname;
		//内容
		private String educontent;
		//时长
		private String edutime;
		//作者
		private String eduuser;
		//责任主编
		private String eduleaderuser;
		//来源
		private String eduorigin;
		//单位
		private String eduunint;
		//图片地址
		private String eduimage;
		//备注
		private String remark;
		//创建时间
		private Date educreatetime;
		//修改人
		private String educreateuser;
		//更新时间
		private Date eduupdatetime;
		//链接地址
		private String url;
	
}

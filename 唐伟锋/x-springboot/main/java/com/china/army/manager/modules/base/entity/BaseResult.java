package com.china.army.manager.modules.base.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 训练成绩
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 11:37:25
 */
@Data
@TableName("base_result")
@EqualsAndHashCode(callSuper = true)
public class BaseResult extends Model<BaseResult> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Integer id;
		//训练科目ID
		private Integer subjectid;
		//训练科目
		private Integer subjectname;
		//训练时长
		private String subjecttime;
		//参训人员
		private String subjectuser;
		//军衔
		private String subjectlevel;
		//参训单位
		private String subjectunint;
		//带训领导
		private String subjectleadername;
		//总评
		private String evaluate;
		//备注
		private String remark;
	
}

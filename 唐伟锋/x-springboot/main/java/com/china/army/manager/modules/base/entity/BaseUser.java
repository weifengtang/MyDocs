package com.china.army.manager.modules.base.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;


/**
 * 士兵信息管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@Data
@TableName("base_user")
@EqualsAndHashCode(callSuper = true)
public class BaseUser extends Model<BaseUser> implements Serializable {
	private static final long serialVersionUID = 1L;

		//
		@TableId
		private Integer id;
		//士兵名字
		private String username;
		//军衔
		private String degree;
		//所属单位
		private String unit;
		//入伍时间
		private Date jionTime;
		//士兵电话
		private String mobile;
		//籍贯
		private String homeAddress;
		//家庭联系电话
		private String homePhone;
		//奖赏情况
		private String remark;
		//备注
		private String detail;
	
}

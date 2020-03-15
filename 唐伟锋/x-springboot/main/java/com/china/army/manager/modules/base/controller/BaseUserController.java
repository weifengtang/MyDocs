package com.china.army.manager.modules.base.controller;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.china.army.manager.modules.base.entity.BaseUser;
import com.china.army.manager.modules.base.service.BaseUserService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 士兵信息管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@RestController
@AllArgsConstructor
@RequestMapping("/base/baseuser")
public class BaseUserController  extends AbstractController {
    private final  BaseUserService baseUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('base:baseuser:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<BaseUser> queryWrapper = new QueryWrapper<>();
        IPage<BaseUser> sysConfigList = baseUserService.page(mpPageConvert.<BaseUser>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('base:baseuser:info')")
    public R info(@PathVariable("id')") Integer id){
        return R.ok().put("baseUser", baseUserService.getById(id));
    }


    /**
     * 新增士兵信息管理
     */
    @SysLog("新增士兵信息管理数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('base:baseuser:save')")
    public R save(@RequestBody BaseUser baseUser){
        baseUserService.save(baseUser);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改士兵信息管理数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('base:baseuser:update')")
    public R update(@RequestBody BaseUser baseUser){
		baseUserService.updateById(baseUser);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除士兵信息管理数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('base:baseuser:delete')")
    public R delete(@RequestBody Integer[] ids){
		baseUserService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

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
import com.china.army.manager.modules.base.entity.BaseCar;
import com.china.army.manager.modules.base.service.BaseCarService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 车辆管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@RestController
@AllArgsConstructor
@RequestMapping("/base/basecar")
public class BaseCarController  extends AbstractController {
    private final  BaseCarService baseCarService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('base:basecar:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<BaseCar> queryWrapper = new QueryWrapper<>();
        IPage<BaseCar> sysConfigList = baseCarService.page(mpPageConvert.<BaseCar>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('base:basecar:info')")
    public R info(@PathVariable("id')") Integer id){
        return R.ok().put("baseCar", baseCarService.getById(id));
    }


    /**
     * 新增车辆管理
     */
    @SysLog("新增车辆管理数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('base:basecar:save')")
    public R save(@RequestBody BaseCar baseCar){
        baseCarService.save(baseCar);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改车辆管理数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('base:basecar:update')")
    public R update(@RequestBody BaseCar baseCar){
		baseCarService.updateById(baseCar);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除车辆管理数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('base:basecar:delete')")
    public R delete(@RequestBody Integer[] ids){
		baseCarService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

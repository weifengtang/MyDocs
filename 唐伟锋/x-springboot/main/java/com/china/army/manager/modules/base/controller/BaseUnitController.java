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
import com.china.army.manager.modules.base.entity.BaseUnit;
import com.china.army.manager.modules.base.service.BaseUnitService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 单位管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-02-29 14:33:54
 */
@RestController
@AllArgsConstructor
@RequestMapping("/base/baseunit")
public class BaseUnitController  extends AbstractController {
    private final  BaseUnitService baseUnitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('base:baseunit:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<BaseUnit> queryWrapper = new QueryWrapper<>();
        IPage<BaseUnit> sysConfigList = baseUnitService.page(mpPageConvert.<BaseUnit>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('base:baseunit:info')")
    public R info(@PathVariable("id')") Long id){
        return R.ok().put("baseUnit", baseUnitService.getById(id));
    }


    /**
     * 新增单位管理
     */
    @SysLog("新增单位管理数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('base:baseunit:save')")
    public R save(@RequestBody BaseUnit baseUnit){
        baseUnitService.save(baseUnit);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改单位管理数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('base:baseunit:update')")
    public R update(@RequestBody BaseUnit baseUnit){
		baseUnitService.updateById(baseUnit);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除单位管理数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('base:baseunit:delete')")
    public R delete(@RequestBody Long[] ids){
		baseUnitService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

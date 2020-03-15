package com.china.army.manager.modules.edu.controller;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.china.army.manager.modules.edu.entity.EduResouces;
import com.china.army.manager.modules.edu.service.EduResoucesService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 教育资源管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 12:38:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/edu/eduresouces")
public class EduResoucesController  extends AbstractController {
    private final  EduResoucesService eduResoucesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('edu:eduresouces:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<EduResouces> queryWrapper = new QueryWrapper<>();
        IPage<EduResouces> sysConfigList = eduResoucesService.page(mpPageConvert.<EduResouces>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('edu:eduresouces:info')")
    public R info(@PathVariable("id") Integer id){
        return R.ok().put("eduResouces", eduResoucesService.getById(id));
    }


    /**
     * 新增教育资源管理
     */
    @SysLog("新增教育资源管理数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('edu:eduresouces:save')")
    public R save(@RequestBody EduResouces eduResouces){
        eduResoucesService.save(eduResouces);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改教育资源管理数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('edu:eduresouces:update')")
    public R update(@RequestBody EduResouces eduResouces){
		eduResoucesService.updateById(eduResouces);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除教育资源管理数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('edu:eduresouces:delete')")
    public R delete(@RequestBody Integer[] ids){
		eduResoucesService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

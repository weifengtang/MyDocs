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
import com.china.army.manager.modules.edu.entity.EduTheme;
import com.china.army.manager.modules.edu.service.EduThemeService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 教育主题管理
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 12:51:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/edu/edutheme")
public class EduThemeController  extends AbstractController {
    private final  EduThemeService eduThemeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('edu:edutheme:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<EduTheme> queryWrapper = new QueryWrapper<>();
        IPage<EduTheme> sysConfigList = eduThemeService.page(mpPageConvert.<EduTheme>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('edu:edutheme:info')")
    public R info(@PathVariable("id") Integer id){
        return R.ok().put("eduTheme", eduThemeService.getById(id));
    }


    /**
     * 新增教育主题管理
     */
    @SysLog("新增教育主题管理数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('edu:edutheme:save')")
    public R save(@RequestBody EduTheme eduTheme){
        eduThemeService.save(eduTheme);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改教育主题管理数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('edu:edutheme:update')")
    public R update(@RequestBody EduTheme eduTheme){
		eduThemeService.updateById(eduTheme);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除教育主题管理数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('edu:edutheme:delete')")
    public R delete(@RequestBody Integer[] ids){
		eduThemeService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

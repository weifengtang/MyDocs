package com.china.army.manager.modules.base.controller;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.china.army.manager.modules.base.entity.BaseResult;
import com.china.army.manager.modules.base.service.BaseResultService;
import com.china.army.common.utils.R;
import lombok.AllArgsConstructor;
import com.china.army.common.annotation.SysLog;
import com.china.army.common.base.AbstractController;
import java.util.Arrays;



/**
 * 训练成绩
 *
 * @author wft
 * @email 17346611033@163.com
 * @date 2020-03-01 11:37:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/base/baseresult")
public class BaseResultController  extends AbstractController {
    private final  BaseResultService baseResultService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasRole('base:baseresult:list')")
    public R list(@RequestParam Map<String, Object> params){
        //查询列表数据
        QueryWrapper<BaseResult> queryWrapper = new QueryWrapper<>();
        IPage<BaseResult> sysConfigList = baseResultService.page(mpPageConvert.<BaseResult>pageParamConvert(params),queryWrapper);
        return R.ok().put("page", mpPageConvert.pageValueConvert(sysConfigList));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @PreAuthorize("hasRole('base:baseresult:info')")
    public R info(@PathVariable("id") Integer id){
        return R.ok().put("baseResult", baseResultService.getById(id));
    }


    /**
     * 新增训练成绩
     */
    @SysLog("新增训练成绩数据")
    @RequestMapping("/save")
    @PreAuthorize("hasRole('base:baseresult:save')")
    public R save(@RequestBody BaseResult baseResult){
        baseResultService.save(baseResult);
        return R.ok();
    }


    /**
     * 修改
     */
    @SysLog("修改训练成绩数据")
    @RequestMapping("/update")
    @PreAuthorize("hasRole('base:baseresult:update')")
    public R update(@RequestBody BaseResult baseResult){
		baseResultService.updateById(baseResult);
        return R.ok();
    }


    /**
     * 删除
     */
    @SysLog("删除训练成绩数据")
    @RequestMapping("/delete")
    @PreAuthorize("hasRole('base:baseresult:delete')")
    public R delete(@RequestBody Integer[] ids){
		baseResultService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
	
}

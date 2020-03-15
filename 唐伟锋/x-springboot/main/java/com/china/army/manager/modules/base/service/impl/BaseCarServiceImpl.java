package com.china.army.manager.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.china.army.manager.modules.base.mapper.BaseCarMapper;
import com.china.army.manager.modules.base.entity.BaseCar;
import com.china.army.manager.modules.base.service.BaseCarService;



@Service
public class BaseCarServiceImpl extends ServiceImpl<BaseCarMapper, BaseCar> implements BaseCarService {
	
}

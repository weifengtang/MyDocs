package com.china.army.manager.modules.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.china.army.manager.modules.base.mapper.BaseUserMapper;
import com.china.army.manager.modules.base.entity.BaseUser;
import com.china.army.manager.modules.base.service.BaseUserService;



@Service
public class BaseUserServiceImpl extends ServiceImpl<BaseUserMapper, BaseUser> implements BaseUserService {
	
}

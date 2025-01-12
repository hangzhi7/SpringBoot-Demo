package com.hz.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.mapper.UserMapper;
import com.hz.model.User;
import com.hz.model.UserPageQuery;
import com.hz.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hz
 * @since 2025-01-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> listPagedUsers(UserPageQuery queryParams) {
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        Page<User> page = new Page<>(pageNum, pageSize);
        return this.baseMapper.listPagedUsers(page, queryParams);
    }

    @Override
    public boolean saveUser(User formData) {
        return this.save(formData);
    }

    @Override
    public User getUserFormData(Long id) {
        return this.getById(id);
    }

    @Override
    public boolean updateUser(User formData) {
        return this.updateById(formData);
    }

    @Override
    public boolean deleteUsers(String ids) {
        Assert.isTrue(StrUtil.isNotBlank(ids), "删除的数据为空");
        List<Long> idList = Arrays.stream(ids.split(","))
                .map(Long::parseLong)
                .toList();
        return this.removeByIds(idList);
    }
}

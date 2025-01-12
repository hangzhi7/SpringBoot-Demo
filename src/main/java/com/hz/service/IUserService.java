package com.hz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.model.User;
import com.hz.model.UserPageQuery;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author hz
 * @since 2025-01-06
 */
public interface IUserService extends IService<User> {


    IPage<User> listPagedUsers(UserPageQuery queryParams);

    boolean saveUser(User formData);

    User getUserFormData(Long id);

    boolean updateUser(User formData);

    boolean deleteUsers(String ids);
}

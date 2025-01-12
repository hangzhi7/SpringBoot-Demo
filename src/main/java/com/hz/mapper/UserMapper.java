package com.hz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.model.User;
import com.hz.model.UserPageQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author hz
 * @since 2025-01-06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> listPagedUsers(Page<User> page, UserPageQuery queryParams);
}

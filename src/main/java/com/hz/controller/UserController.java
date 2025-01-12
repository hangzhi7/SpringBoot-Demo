package com.hz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hz.common.PageResult;
import com.hz.common.Result;
import com.hz.model.User;
import com.hz.model.UserPageQuery;
import com.hz.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author hz
 * @since 2025-01-06
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    /**
     * 分页列表
     */
    @GetMapping("/page")
    public PageResult<User> listPagedUsers(UserPageQuery queryParams ) {
        IPage<User> result = userService.listPagedUsers(queryParams);
        return PageResult.success(result);
    }

    /**
     * 新增
     */
    @PostMapping
    public Result saveUser(@RequestBody User formData ) {
        boolean result = userService.saveUser(formData);
        return Result.judge(result);
    }

    /**
     * 根据id获取详情
     */
    @GetMapping("/{id}")
    public Result getUserForm(@PathVariable Long id) {
        User formData = userService.getUserFormData(id);
        return Result.success(formData);
    }

    /**
     * 修改
     */
    @PutMapping(value = "/{id}")
    public Result updateUser(@RequestBody User formData) {
        boolean result = userService.updateUser(formData);
        return Result.judge(result);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{ids}")
    public Result deleteUsers(@PathVariable String ids) {
        boolean result = userService.deleteUsers(ids);
        return Result.judge(result);
    }

}

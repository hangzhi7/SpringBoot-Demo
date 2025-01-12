package com.hz.config;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * mybatis-plus 字段自动填充
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", () -> DateUtil.parse(LocalDateTime.now().toString()), Date.class);
        this.strictUpdateFill(metaObject, "updateTime", () -> DateUtil.parse(LocalDateTime.now().toString()), Date.class);
    }

    /**
     * 更新填充更新时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", () -> DateUtil.parse(LocalDateTime.now().toString()), Date.class);
    }

}

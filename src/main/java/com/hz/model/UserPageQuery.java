package com.hz.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserPageQuery extends User {

    private int pageNum = 1;
    private int pageSize = 10;

}

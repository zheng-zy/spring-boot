package com.ls.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements Serializable {

    private String loginName;
    //    private String name;
//    private String password;
//    private Integer status;
    private Date createTime;
    private Date updateTime;
//    private String desc;

}

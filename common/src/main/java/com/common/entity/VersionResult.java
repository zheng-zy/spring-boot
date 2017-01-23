package com.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResult {

    private int version;
    private String info;
    private Date date;

}

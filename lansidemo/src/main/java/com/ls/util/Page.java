package com.ls.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    // 当前第几页
    private int page;
    // 一页几行
    private int rows;

}

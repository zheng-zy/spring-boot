package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/2.
 */
@Entity
@Table(name = "tbl_blog")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog implements Serializable {

    private static final long serialVersionUID = 1261089055578881606L;
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
    @Column
    private String desc;
}

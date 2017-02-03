package com.blog.dao;

import com.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/2.
 */
public interface BlogDao extends PagingAndSortingRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

//    @Query("select a from Blog a order by a.cteate_time desc")
//    List<Blog> list();


}

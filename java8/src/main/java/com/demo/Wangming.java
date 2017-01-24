package com.demo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/1/24.
 */
public class Wangming implements Delayed {

    private String name;
    //身份证
    private String id;
    //截止时间
    private long endTime;

    public Wangming(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    /**
     * 用来判断是否到了截止时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // TODO Auto-generated method stub
        return endTime - System.currentTimeMillis();
    }

    /**
     * 相互批较排序用
     */
    @Override
    public int compareTo(Delayed o) {
        // TODO Auto-generated method stub
        Wangming jia = (Wangming) o;
        return endTime - jia.endTime > 0 ? 1 : 0;
    }

}


package com.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/6.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogResult {

    private String uuid;
    private String url;
    private String httpMethod;
    private String ip;
    private String classMethod;
    private String args;
    private Object response;
    private Long startTime;
    private Long endTime;
    private Long spendTime;

    private void cal() {
        this.spendTime = this.endTime - this.startTime;
    }

    @Override
    public String toString() {
        cal();
        return "LogResult{" +
                "uuid='" + uuid + '\'' +
                ", url='" + url + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", ip='" + ip + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", args='" + args + '\'' +
                ", response=" + response +
                ", spendTime=" + spendTime +
                '}';
    }
}

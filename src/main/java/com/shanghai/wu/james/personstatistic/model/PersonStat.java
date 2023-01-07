package com.shanghai.wu.james.personstatistic.model;

import lombok.Data;

@Data
public class PersonStat {
    /**
     * 设备ID
     */
    private String eid;
    /**
     * 统计的人数
     */
    private int count;
    /**
     * 数据采集时间
     */
    private long time;
}

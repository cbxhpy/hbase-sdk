package com.github.CCwexiao.hbase.sdk.dsl.client;

import com.github.CCweixiao.hbase.sdk.common.lang.MyAssert;

import java.util.Date;

/**
 * @author leojie 2020/11/28 9:58 上午
 */
public class QueryExtInfo {
    private boolean isMaxVersionSet;
    private int maxVersions;

    private boolean isTimeRangeSet;
    private long minStamp;
    private long maxStamp;

    private boolean isLimitSet;
    private long limit;

    public QueryExtInfo() {}

    public void setMaxVersions(int maxVersions) {
        MyAssert.checkArgument(maxVersions > 0, String.format("The max version must >= 1, " +
                "current max version is %s.", maxVersions));
        this.maxVersions = maxVersions;
        this.isMaxVersionSet = true;
    }

    public void setTimeStamp(long ts) {
        setTimeRange(ts, ts + 1);
    }

    public void setTimeRange(Date minStamp, Date maxStamp) {
        MyAssert.checkNotNull(minStamp);
        MyAssert.checkNotNull(maxStamp);
        setTimeRange(minStamp.getTime(), maxStamp.getTime());
    }

    public void setTimeRange(long minStamp, long maxStamp) {
        MyAssert.checkArgument(minStamp <= maxStamp, String.format("The max timestamp must be >= min timestamp," +
                " but current max timestamp is %s, min timestamp is %s.", maxStamp, minStamp));
        this.minStamp = minStamp;
        this.maxStamp = maxStamp;
        this.isTimeRangeSet = true;
    }

    public void setLimit(long limit) {
        MyAssert.checkArgument(limit >= 0, "The value of limit must bi >= 0," +
                " but current limit is "+ limit);
        this.limit = limit;
        this.isLimitSet = true;
    }

    public boolean isLimitSet() {
        return isLimitSet;
    }

    public long getLimit() {
        return limit;
    }

    public boolean isMaxVersionSet() {
        return isMaxVersionSet;
    }

    public int getMaxVersions() {
        return maxVersions;
    }

    public boolean isTimeRangeSet() {
        return isTimeRangeSet;
    }

    public long getMinStamp() {
        return minStamp;
    }

    public long getMaxStamp() {
        return maxStamp;
    }
}

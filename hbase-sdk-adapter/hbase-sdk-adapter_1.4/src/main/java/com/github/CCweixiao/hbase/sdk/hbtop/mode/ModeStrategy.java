package com.github.CCweixiao.hbase.sdk.hbtop.mode;

import com.github.CCweixiao.hbase.sdk.hbtop.field.Field;
import com.github.CCweixiao.hbase.sdk.hbtop.field.FieldInfo;
import com.github.CCweixiao.hbase.sdk.hbtop.Record;
import edu.umd.cs.findbugs.annotations.Nullable;

import java.util.List;

import org.apache.hadoop.hbase.ClusterStatus;
import org.apache.hadoop.hbase.classification.InterfaceAudience;


/**
 * @author leojie 2021/1/16 9:14 下午
 */
@InterfaceAudience.Private
interface ModeStrategy {
    List<FieldInfo> getFieldInfos();

    Field getDefaultSortField();

    List<Record> getRecords(ClusterStatus clusterStatus);

    @Nullable
    DrillDownInfo drillDown(Record selectedRecord);
}

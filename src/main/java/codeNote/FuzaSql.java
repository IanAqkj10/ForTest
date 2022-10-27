package codeNote;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/16 11:53
 */

public class FuzaSql {

    /**
     筛选表1的两个不重复（factor_no，mn_no）字段 ，取时间最大的记录（collect_time）  内连接
    SELECT
    t1.id,
    t1.mn_no AS mnNo,
    t1.factor_no AS factorNo,
    t1.factor_rtd AS factorRtd,
    t1.factor_flag AS factorFlag,
    t1.collect_time AS collectTime
            FROM
    tb_message_history_rtd_20220915 t1
    LEFT JOIN tb_message_history_rtd_20220915 t2 ON t1.mn_no = t2.mn_no
    AND t1.factor_no = t2.factor_no
    AND t1.collect_time < t2.collect_time
            WHERE
    t2.id IS NULL


     */
}
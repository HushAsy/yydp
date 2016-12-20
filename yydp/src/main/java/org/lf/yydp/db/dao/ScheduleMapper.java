package org.lf.yydp.db.dao;

import org.lf.yydp.db.pojo.Schedule;
import org.springframework.stereotype.Repository;
@Repository
public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}
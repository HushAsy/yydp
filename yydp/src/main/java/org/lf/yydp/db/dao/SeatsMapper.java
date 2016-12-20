package org.lf.yydp.db.dao;

import org.lf.yydp.db.pojo.Seats;
import org.springframework.stereotype.Repository;
@Repository
public interface SeatsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seats record);

    int insertSelective(Seats record);

    Seats selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seats record);

    int updateByPrimaryKey(Seats record);
}
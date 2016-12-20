package org.lf.yydp.db.dao;

import org.lf.yydp.db.pojo.Playhall;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayhallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Playhall record);

    int insertSelective(Playhall record);

    Playhall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Playhall record);

    int updateByPrimaryKey(Playhall record);
}
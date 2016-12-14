package org.lf.yydp.db.dao;

import org.lf.yydp.db.pojo.Film_info;

public interface Film_infoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Film_info record);

    int insertSelective(Film_info record);

    Film_info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Film_info record);

    int updateByPrimaryKeyWithBLOBs(Film_info record);

    int updateByPrimaryKey(Film_info record);
}
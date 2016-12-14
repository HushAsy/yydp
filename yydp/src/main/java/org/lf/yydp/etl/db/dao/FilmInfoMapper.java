package org.lf.yydp.etl.db.dao;

import org.lf.yydp.etl.db.pojo.FilmInfo;

public interface FilmInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilmInfo record);

    int insertSelective(FilmInfo record);

    FilmInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilmInfo record);

    int updateByPrimaryKeyWithBLOBs(FilmInfo record);

    int updateByPrimaryKey(FilmInfo record);
}
package org.lf.yydp.db.dao;

import org.lf.yydp.db.pojo.Actor_Film;


public interface Actor_FilmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Actor_Film record);

    int insertSelective(Actor_Film record);

    Actor_Film selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Actor_Film record);

    int updateByPrimaryKey(Actor_Film record);
}
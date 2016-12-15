package org.lf.yydp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.lf.yydp.db.pojo.Film;

public interface FilmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Film record);

    int insertSelective(Film record);

    Film selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Film record);

    int updateByPrimaryKey(Film record);
    
    @Select("select * from film")
    @ResultMap("org.lf.yydp.db.dao.FilmMapper.BaseResultMap")
    List<Film> selectAllFilm();
    
}
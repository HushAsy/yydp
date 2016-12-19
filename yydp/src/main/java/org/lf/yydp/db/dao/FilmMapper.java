package org.lf.yydp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lf.yydp.db.pojo.Film;
import org.springframework.stereotype.Repository;

@Repository
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
    
    @Select("select href  from film where href is not null")
    List<String> selectAllFilmHref();
    
    @Update("update film set picdownloadstatus=1,localimgpath=#{localImgPath} where id=#{id}")
    void updateFilmByimg(@Param("id")Integer id, @Param("localImgPath")String localImgPath);
    
    @Select("select * from film;")
    List<Film> selectImgList();
    
    
}
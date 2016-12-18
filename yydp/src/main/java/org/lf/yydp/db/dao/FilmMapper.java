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
    
    @Select("select href  from film")
    List<String> selectAllFilmHref();
    
    @Update("update film set picdownloadstatus=1,localimgpath=#{localImgPath} where img = #{img}")
    void updateFilmByimg(@Param("img")String img, @Param("localImgPath")String localImgPath);
    
    @Select("select img from film where picdownloadstatus = 0")
    List<String> selectImgList();
    
    
}
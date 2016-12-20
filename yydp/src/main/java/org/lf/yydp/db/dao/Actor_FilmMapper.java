package org.lf.yydp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lf.yydp.db.pojo.Actor_Film;
import org.springframework.stereotype.Repository;

@Repository
public interface Actor_FilmMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Actor_Film record);

    int insertSelective(Actor_Film record);

    Actor_Film selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Actor_Film record);

    int updateByPrimaryKey(Actor_Film record);
    
    @Select("select * from actor_film where picture is not null")
    @ResultMap("org.lf.yydp.db.dao.Actor_FilmMapper.BaseResultMap")
    List<Actor_Film> selectActorImgHref();
    
    @Update("update actor_film set picDownLoadStatus = 1,localpathimg=#{localPath} where id=#{id}")
    void updateActor(@Param("id")Integer id,@Param("localPath")String localPath);
    
    @Select("select * from actor_film")
    @ResultMap("org.lf.yydp.db.dao.Actor_FilmMapper.BaseResultMap")
    List<Actor_Film> selectActorList();
    
    @Select("select * from actor_film where actorName=#{actorName} and f_id=#{f_id}")
    @ResultMap("org.lf.yydp.db.dao.Actor_FilmMapper.BaseResultMap")
    Actor_Film selectActorFilmByActorNameAndFid(@Param("actorName")String actorName, @Param("f_id")Integer fid);
}
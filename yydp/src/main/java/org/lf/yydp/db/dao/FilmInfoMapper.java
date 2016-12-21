package org.lf.yydp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lf.yydp.db.pojo.FilmInfo;
import org.springframework.stereotype.Repository;
@Repository
public interface FilmInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FilmInfo record);

    int insertSelective(FilmInfo record);

    FilmInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FilmInfo record);

    int updateByPrimaryKey(FilmInfo record);
    
    /**
     * 查询日期不为空的电影信息
     * @return
     */
    @Select("select * from film_info where f_duration is not null;")
    @ResultMap("org.lf.yydp.db.dao.FilmInfoMapper.BaseResultMap")
    List<FilmInfo> selectDurationIsNotNull();
    
    /**
     * 查询所有电影信息
     * @return
     */
    @Select("select * from film_info")
    @ResultMap("org.lf.yydp.db.dao.FilmInfoMapper.BaseResultMap")
    List<FilmInfo> selectList();
    
    @Select("select * from film_info where f_id=#{fid}")
    @ResultMap("org.lf.yydp.db.dao.FilmInfoMapper.BaseResultMap")
    FilmInfo selectFilm_infoByF_id(Integer fid);
    
    @Select("select * from film_info where bigimage is not null")
    @ResultMap("org.lf.yydp.db.dao.FilmInfoMapper.BaseResultMap")
    List<FilmInfo> selectBigHrefList();
    
    @Update("update film_info set picDownLoadStatus=1,localbigimage=#{localImgPath}  where f_id=#{id}")
    void updateFilmInfoImg(@Param("id")Integer id, @Param("localImgPath")String localImgPath);
    
}
package org.lf.yydp.db.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.lf.yydp.db.pojo.Seats;
import org.lf.yydp.service.model.MovieInfo;
import org.springframework.stereotype.Repository;
@Repository
public interface SeatsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seats record);

    int insertSelective(Seats record);

    Seats selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seats record);

    int updateByPrimaryKey(Seats record);
    
    @Select("SELECT  s.seat_id FROM seats AS s JOIN schedule AS sch ON sch.seat_id = s.id WHERE sch.plan_id=#{planId,jdbcType=INTEGER}")
    @ResultMap("org.lf.yydp.db.dao.SeatsMapper.BaseResultMap")
    List<Seats> getOrderedSeatsByPlanId(Integer planId);
    
    @Select ("SELECT distinct f.id,f.localImgPath,fi.f_name,fi.f_type,fi.f_country,fi.f_ontime,p.money FROM film AS f JOIN film_info AS fi ON fi.f_id=f.id JOIN plan AS p ON p.f_id = f.id WHERE p.id=#{plan_id,jdbcType=INTEGER} ")
    @ResultMap("org.lf.yydp.db.dao.SeatsMapper.MovieInfoResultMap")
    MovieInfo getMvieInfoByPid (Integer plan_id) ;
}
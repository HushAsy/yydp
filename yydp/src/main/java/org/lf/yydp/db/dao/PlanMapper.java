package org.lf.yydp.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.lf.yydp.db.pojo.Plan;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);
    
    @Select("select * from plan where f_id =#{f_id}")
    @ResultMap("org.lf.yydp.db.dao.PlanMapper.BaseResultMap")
    List<Plan> slectPlanByF_id(Integer f_id);
    
    @Select("select * from plan where id =#{id}")
    @ResultMap("org.lf.yydp.db.dao.PlanMapper.BaseResultMap")
    Plan slectPlanByplan_id(Integer id);
}
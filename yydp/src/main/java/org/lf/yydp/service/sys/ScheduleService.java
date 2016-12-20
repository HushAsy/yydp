package org.lf.yydp.service.sys;

import java.text.SimpleDateFormat;
import java.util.List;

import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.PlayhallMapper;
import org.lf.yydp.db.dao.ScheduleMapper;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.db.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ScheduleService {
	@Autowired
	private FilmInfoMapper filmInfoDao;
	
	@Autowired
	private ScheduleMapper scheduleDao;
	
	@Autowired
	private PlayhallMapper playDao;
	
	@Transactional(rollbackFor=Exception.class)
	public void insertScedule(){
		List<FilmInfo> listFilmInfo = filmInfoDao.selectDurationIsNotNull();
		Integer duration = null;
		for(FilmInfo filmInfo : listFilmInfo){
			filmInfo.getfId();
			duration = getMinutes(filmInfo.getfDuration());
		}
	}

	private Integer getMinutes(String str){
		return Integer.parseInt(str.replace("分钟", "").trim());
	}
	
	public void insertDate(Integer fid, Integer duration){
		SimpleDateFormat sdfT = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfP = new SimpleDateFormat("hh:MM:ss");
		Schedule schedule = new Schedule();
		schedule.setfId(fid);
		schedule.setMoney(30.0);
		scheduleDao.insert(null);
		
	}
}

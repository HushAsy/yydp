package org.lf.yydp.service.sys;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.PlayhallMapper;
import org.lf.yydp.db.dao.ScheduleMapper;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.db.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("deprecation")
@Service
public class ScheduleService {
	private static Calendar calenSce_time;
	private static Calendar calenPlay_time;
	private static Calendar calen_flag_time;
	private static int p_id = 1;
	private static boolean flag = false;
	private static Date dateNow = new Date();
	private static double money = 30.0;
	
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
		while(flag == false){
			for(FilmInfo filmInfo : listFilmInfo){
				duration = getMinutes(filmInfo.getfDuration());
				insertDate(filmInfo.getfId(), duration);
			}
		}
	}

	private Integer getMinutes(String str){
		return Integer.parseInt(str.replace("分钟", "").trim());
	}
	static{
		calenSce_time = Calendar.getInstance();
		calenSce_time.set(dateNow.getYear(), dateNow.getMonth(), dateNow.getDay(), 0, 0, 0);
		
		calenPlay_time = Calendar.getInstance();
		calenPlay_time.set(dateNow.getYear(), dateNow.getMonth(), dateNow.getDay(), 9, 0, 0);
		
		calen_flag_time = Calendar.getInstance();
		calen_flag_time.set(dateNow.getYear(), dateNow.getMonth(), dateNow.getDay(), 0, 0, 0);
	}
	private void insertDate(Integer fid, Integer duration){
		if(new Date(calenPlay_time.getTimeInMillis()).getHours()>21 || new Date(calenPlay_time.getTimeInMillis()).getHours()<9){
			if(p_id<10){
				calenPlay_time.set(Calendar.HOUR_OF_DAY, 9);
				p_id++;
				money = 30.0;
			}else{
				calenPlay_time.set(Calendar.HOUR_OF_DAY, 9);
				calenSce_time.add(Calendar.DATE, 1);
				p_id = 1 ;
				money = 30.0;
			}
		}
		if((new Date(calenSce_time.getTimeInMillis()).getDay()-new Date(calen_flag_time.getTimeInMillis()).getDay())>=3){
			flag = true;
			return;
		}
		Schedule schedule = new Schedule();
		schedule.setfId(fid);
		schedule.setMoney(money++);
		schedule.setScheTime(new Date(calenSce_time.getTimeInMillis()));
		schedule.setPlayTime(new Date(calenPlay_time.getTimeInMillis()));
		schedule.setPhId(p_id);
		if(flag == false){
			scheduleDao.insert(schedule);
		}
		calenPlay_time.add(Calendar.MINUTE, duration+30);
	}
}

package org.lf.yydp.service.sys;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.PlanMapper;
import org.lf.yydp.db.dao.PlayhallMapper;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.db.pojo.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("deprecation")
@Service
public class PlanService {
	private static Calendar calenPlay_time;
	private static Calendar calen_flag_time;//设定一个flag日期，作为循环结束的标志
	private static int p_id = 1;
	private static boolean flag = false;//当flag为false，进行排期，为true时结束。
	private static Date dateNow = new Date();
	private static double money = 30.0;
	
	@Autowired
	private FilmInfoMapper filmInfoDao;
	
	@Autowired
	private PlanMapper scheduleDao;
	
	@Autowired
	private PlayhallMapper playDao;
	
	/**
	 * 对电影进行排期
	 * schedule,film_info
	 */
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

	/**
	 * 将"*分钟"改为"*"
	 * @param str
	 * @return
	 */
	private Integer getMinutes(String str){
		return Integer.parseInt(str.replace("分钟", "").trim());
	}
	static{
		
		calenPlay_time = Calendar.getInstance();
		calenPlay_time.set(Calendar.HOUR_OF_DAY, 9);
		calenPlay_time.set(Calendar.MINUTE, 0);
		calenPlay_time.set(Calendar.SECOND, 0);
		
		calen_flag_time = Calendar.getInstance();
		calen_flag_time.set(dateNow.getYear(), dateNow.getMonth(), dateNow.getDay(), 0, 0, 0);
	}
	
	/**
	 * 排期规则，影厅共10个，早上9点开始放映，晚上9点结束，中间每场电影隔30分钟，
	 * 从数据库中表film取出电影id，根据所有的电影在所有的影厅进行循环，循环3天。
	 * @param fid
	 * @param duration
	 */
	private void insertDate(Integer fid, Integer duration){
		System.out.println(calenPlay_time.toString());
		if(new Date(calenPlay_time.getTimeInMillis()).getHours()>21 || new Date(calenPlay_time.getTimeInMillis()).getHours()<9){
			if(p_id<10){
				calenPlay_time.set(Calendar.HOUR_OF_DAY, 9);
				calenPlay_time.set(Calendar.MINUTE, 0);
				calenPlay_time.set(Calendar.SECOND, 0);
				p_id++;
				money = 30.0;
			}else{
				calenPlay_time.set(Calendar.HOUR_OF_DAY, 9);
				calenPlay_time.set(Calendar.MINUTE, 0);
				calenPlay_time.set(Calendar.SECOND, 0);
				calenPlay_time.add(Calendar.DATE, 1);
				p_id = 1 ;
				money = 30.0;
			}
		}
		if((new Date(calenPlay_time.getTimeInMillis()).getDay()-new Date(calen_flag_time.getTimeInMillis()).getDay())>=3){
			flag = true;
			return;
		}
		Plan schedule = new Plan();
		schedule.setfId(fid);
		schedule.setMoney(money++);
		schedule.setPlayTime(new Date(calenPlay_time.getTimeInMillis()));
		schedule.setStatus("0");
		schedule.setPhId(p_id);
		if(flag == false){
			scheduleDao.insert(schedule);
		}
		calenPlay_time.add(Calendar.MINUTE, duration+30);
	}
}

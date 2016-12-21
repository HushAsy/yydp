package org.lf.yydp.service.film;

import java.util.List;

import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.pojo.FilmInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmInfoService {
	@Autowired
	private FilmInfoMapper filmInfoDao;
	
	public List<FilmInfo> getFilmInfoList(){
		return filmInfoDao.selectList();
	}
}

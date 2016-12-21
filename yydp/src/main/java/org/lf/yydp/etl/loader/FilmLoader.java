package org.lf.yydp.etl.loader;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.etl.extract.FilmExtractor;
import org.lf.yydp.service.sys.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmLoader extends BaseLoader{
	private Logger logger = Logger.getLogger(FilmLoader.class);
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Autowired
	private DownLoadService downService;
	
	private List<Film> filmList = null;
	
	/**
	 * 电影网站首页下载，成功后返回true
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean load(String url) {
		try {
			FilmExtractor baseExt = new FilmExtractor(url);
			filmList = baseExt.getFilmList();
			for(Film film :filmList){
				if(filmMapper.selectByPrimaryKey(film.getId())==null){
					filmMapper.insertSelective(film);
				}
			}
			logger.info("Film: 数据插入成功！");
		} catch (IOException e) {
			logger.error("error!");
		} catch (InterruptedException e) {
			logger.error("error!");
		}
		return true;
	}
	
}

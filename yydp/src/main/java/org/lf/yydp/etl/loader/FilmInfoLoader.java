package org.lf.yydp.etl.loader;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.db.dao.Actor_FilmMapper;
import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Actor_Film;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.etl.extract.FilmInfoExtrator;
import org.lf.yydp.service.sys.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FilmInfoLoader extends BaseLoader{
	private Logger logger = Logger.getLogger(FilmInfoLoader.class);
	private FilmInfo filmInfo;
	private List<Actor_Film> listAc;
	private List<String> listFilmInfoHref = null;
	
	@Autowired
	private FilmInfoMapper film_intoDao;
	
	@Autowired
	private FilmMapper filmDao;
	
	@Autowired
	private Actor_FilmMapper actorDao;
	
	@Autowired
	private DownLoadService imgDownLoadService;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean load(String url) {
		listFilmInfoHref = filmDao.selectAllFilmHref();
		for(String filmInfo : listFilmInfoHref){
			loadfilmInfo(filmInfo);
		}
		return true;
	}
	
	private void loadfilmInfo(String url){
		try {
			FilmInfoExtrator baseExt = new FilmInfoExtrator(url);
			filmInfo = baseExt.getFilmInfo();
			film_intoDao.insert(filmInfo);
			listAc = baseExt.getListActors();
			for(Actor_Film actor: listAc){
				actorDao.insert(actor);
			}
		} catch (IOException e) {
			logger.error("error", e);
		} catch (InterruptedException e) {
			logger.error("error", e);
		}
	}
}

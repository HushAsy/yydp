package org.lf.yydp.etl.loader;

import java.io.IOException;
import java.util.List;

import org.lf.yydp.db.dao.Actor_FilmMapper;
import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.pojo.Actor_Film;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.etl.extract.FilmInfoExtrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FilmInfoLoader extends BaseLoader{
	private FilmInfo filmInfo;
	private List<Actor_Film> listAc;
	@Autowired
	private FilmInfoMapper film_intoDao;
	
	@Autowired
	private Actor_FilmMapper actorDao;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void load(String url) {
		try {
			FilmInfoExtrator baseExt = new FilmInfoExtrator(url);
			filmInfo = baseExt.getFilmInfo();
			film_intoDao.insert(filmInfo);
			listAc = baseExt.getListActors();
			for(Actor_Film actor: listAc){
				actorDao.insert(actor);
			}
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void downImg() {
		// TODO Auto-generated method stub
		
	}

}

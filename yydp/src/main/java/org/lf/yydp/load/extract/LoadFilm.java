package org.lf.yydp.load.extract;

import java.io.IOException;
import java.util.List;

import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.load.FilmLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoadFilm {
	@Autowired
	private FilmMapper filmDao;
	
	private List<Film> list;
	private FilmLoader film;
	
	@Transactional(rollbackFor=Exception.class)
	public void load(String url) throws IOException, InterruptedException{
		film = new FilmLoader(url);
		film.extract();
		list = film.getList();
		loadData();
	}
	
	public void loadData(){
		for(int i = 0; i<list.size(); i++){
			filmDao.insert(list.get(i));
		}
	}
}

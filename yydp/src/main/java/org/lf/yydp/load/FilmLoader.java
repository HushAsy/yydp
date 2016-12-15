package org.lf.yydp.load;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.load.extract.FilmExtract;
import org.springframework.stereotype.Service;
@Service
public class FilmLoader extends BaseLoad{
	private Logger logger = Logger.getLogger(FilmLoader.class);
	private FilmExtract filmExt;
	private List<Film> list; 
	
	public FilmLoader(){
		
	}
	
	public FilmLoader(String url) throws IOException, InterruptedException {
		super(url);
		extract();
	}
	
	@Override
	public void extract() {
		filmExt = new FilmExtract(parseFile);
		list = filmExt.getListFilm();
	}

	public List<Film> getList() {
		return list;
	}

	public void setList(List<Film> list) {
		this.list = list;
	}
	
	
	
}

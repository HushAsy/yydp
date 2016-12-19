package org.lf.yydp.etl.extract;

import java.io.IOException;
import java.util.List;

import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.etl.extract.form.FilmExtract;

public class FilmExtractor extends BaseExtractor{
	
	private List<Film> filmList = null;
	public FilmExtractor(String url) throws IOException, InterruptedException{
		super(url);
		extract();
	}
	
	@Override
	protected void extract() {
		FilmExtract baseExt = new FilmExtract(parseFile);
		filmList = (List<Film>) baseExt.getListModel();
	}

	public List<Film> getFilmList() {
		return filmList;
	}
	
}

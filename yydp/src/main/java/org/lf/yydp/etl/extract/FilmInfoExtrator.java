package org.lf.yydp.etl.extract;

import java.io.IOException;
import java.util.List;

import org.lf.yydp.db.pojo.Actor_Film;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.etl.extract.form.FilmInfoExtract;

public class FilmInfoExtrator extends BaseExtractor{
	private FilmInfo filmInfo;
	private List<Actor_Film> listActors;

	public FilmInfoExtrator(String url) throws IOException, InterruptedException{
		super(url);
		extract();
	}
	
	@Override
	protected void extract() {
		FilmInfoExtract extract = new FilmInfoExtract(parseFile);
		filmInfo = extract.getFilm_info();
		listActors = extract.getActor_Films();
	}

	public FilmInfo getFilmInfo() {
		return filmInfo;
	}

	public List<Actor_Film> getListActors() {
		return listActors;
	}
}

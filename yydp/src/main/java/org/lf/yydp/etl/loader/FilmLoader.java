package org.lf.yydp.etl.loader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.Utils.ImgDownLoad;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.etl.extract.FilmExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmLoader extends BaseLoader{
	private Logger logger = Logger.getLogger(FilmLoader.class);
	@Autowired
	private FilmMapper filmMapper;
	private List<Film> filmList = null;
	private List<String> filmImgStr = null;
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void load(String url) {
		try {
			FilmExtractor baseExt = new FilmExtractor(url);
			filmList = baseExt.getFilmList();
			for(Film film :filmList){
				if(filmMapper.selectByPrimaryKey(film.getId())==null){
					filmMapper.insertSelective(film);
				}
			}
			logger.info("数据插入成功！");
		} catch (IOException e) {
			logger.info("error!");
		} catch (InterruptedException e) {
			logger.info("error!");
		}
		downImg();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void downImg() {
		filmImgStr = filmMapper.selectImgList();
		/**
		 * 此处调用下载图片方法;
		 */
		ImgDownLoad imgDown = new ImgDownLoad(filmImgStr, "film");
		try {
			imgDown.downLoad();
		} catch (MalformedURLException e) {
			logger.info("下载出错！");
		}
	}

}

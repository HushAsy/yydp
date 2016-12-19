package org.lf.yydp.service.sys;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.Model.DownLoadModel;
import org.lf.yydp.db.dao.Actor_FilmMapper;
import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Actor_Film;
import org.lf.yydp.db.pojo.Film;
import org.lf.yydp.db.pojo.FilmInfo;
import org.lf.yydp.etl.imgDownLoad.ImgDownLoad;
import org.lf.yydp.etl.loader.FilmInfoLoader;
import org.lf.yydp.etl.loader.FilmLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DownLoadService {
	private Logger logger = Logger.getLogger(DownLoadService.class);
	@Autowired
	private FilmMapper filmDao;
	
	@Autowired
	private FilmInfoMapper filmInfoDao;
	
	@Autowired
	private Actor_FilmMapper actorDao;
	
	@Autowired
	private FilmLoader filmLoaderService;//首页文件下载
	
	@Autowired
	private FilmInfoLoader filmInfoService;//电影信息文件下载
	
	@Autowired
	private ImgDownLoad DownService;
	
	/**
	 * 文件下载
	 */
	public boolean downFilmFile(String url){
		if(filmLoaderService.load(url) == true){	
			downFileInfoFile();
		}
		return true;
	}
	
	/**
	 * 电影信息文件下载
	 */
	private void downFileInfoFile(){
		filmInfoService.load(null);
	}
	
	
	public void downImg(String filmPath, String filmInfoPath, String actorPath) throws MalformedURLException{
		downFilmImg(filmPath);
		downFilmInfoImg(filmInfoPath);
		downActorImg(actorPath);
		
		updateFilm(filmPath);
		updateFilmInfo(filmInfoPath);
		updateActor(actorPath);
	}
	
	private void updateFilm(String path){
		List<Film> listFilm = filmDao.selectAllFilm();
		for(Film film : listFilm){
			filmDao.updateFilmByimg(film.getId(), getPath(path)+File.separator+film.getId()+".jpg");
		}
		logger.info("film 更新成功");
	}
	
	private void updateFilmInfo(String path){
		List<FilmInfo> listFilm = filmInfoDao.selectList();
		for(FilmInfo film : listFilm){
			filmInfoDao.updateFilmInfoImg(film.getfId(), getPath(path)+File.separator+film.getfId()+".jpg");
		}
		logger.info("filmInfo 更新成功");
	}
	
	private void updateActor(String path){
		List<Actor_Film> listFilm = actorDao.selectActorList();
		for(Actor_Film film : listFilm){
			actorDao.updateActor(film.getId(), getPath(path)+File.separator+film.getId()+".jpg");
		}
		logger.info("actorInfo 更新成功");
	}
	
	private String getPath(String absPath){
		
		String[] strN = absPath.split("\\\\");
		String str = strN[strN.length-2]+File.separator+strN[strN.length-1];
		return str;
	}
	
	private void downFilmImg(String filmPath) throws MalformedURLException{
		DownService.setListModel(getSmallImgHrefList());
		DownService.setTmpDir(filmPath);
		DownService.downLoad();
	}
	
	private void downFilmInfoImg(String filmInfoPath) throws MalformedURLException{
		DownService.setTmpDir(filmInfoPath);
		DownService.setListModel(getBigImgHrefList());
		DownService.downLoad();
	}
	
	private void downActorImg(String actorPath) throws MalformedURLException{
		DownService.setTmpDir(actorPath);
		DownService.setListModel(getActorImgHrefList());
		DownService.downLoad();
	}
	/**
	 * 图片下载
	 * @return
	 */
	private List<DownLoadModel> getSmallImgHrefList(){
		List<Film> filmList = filmDao.selectImgList();
		List<DownLoadModel> listModel = new ArrayList<DownLoadModel>();
		DownLoadModel model = null;
		for(Film film : filmList){
			model = new DownLoadModel();
			model.setName(film.getId().toString());
			model.setUrl(film.getImg());
			listModel.add(model);
		}
		return listModel;
	}
	
	private List<DownLoadModel> getActorImgHrefList(){
		List<Actor_Film> filmInfoList = actorDao.selectActorImgHref();
		List<DownLoadModel> listModel = new ArrayList<DownLoadModel>();
		DownLoadModel model = null;
		for(Actor_Film filmInfo : filmInfoList){
			model = new DownLoadModel();
			model.setName(filmInfo.getId().toString());
			model.setUrl(filmInfo.getPicture());
			listModel.add(model);
		}
		return listModel;
	}
	
	private List<DownLoadModel> getBigImgHrefList(){
		List<FilmInfo> filmInfoList = filmInfoDao.selectBigHrefList();
		List<DownLoadModel> listModel = new ArrayList<DownLoadModel>();
		DownLoadModel model = null;
		for(FilmInfo filmInfo : filmInfoList){
			model = new DownLoadModel();
			model.setName(filmInfo.getfId().toString());
			model.setUrl(filmInfo.getBigimage());
			listModel.add(model);
		}
		return listModel;
	}
	
}

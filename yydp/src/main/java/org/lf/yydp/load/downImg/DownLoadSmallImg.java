package org.lf.yydp.load.downImg;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.db.pojo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DownLoadSmallImg {
	private Logger logger = Logger.getLogger(DownLoadSmallImg.class);
	private List<Film> filmList = null;
	private static File tmpDir = null;
	static {
		tmpDir = new File("temp/smallImg");
		if (!tmpDir.isDirectory()) {
			tmpDir.mkdirs();
		}
	};
	@Autowired
	private FilmMapper filmDao;

	private void download(Film film) throws Exception {
		DataInputStream dis = new DataInputStream(new URL(film.getImg()).openStream());
		File file = new File(tmpDir, film.getId() + ".jpg");
		if (file.exists()) {
			film.setLocalimgpath(file.getPath());
			logger.info(file.getAbsolutePath() + "文件已经存在！");
		} else {
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = dis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			logger.info(file.getAbsolutePath() + "下载完成！");
			film.setLocalimgpath(file.getPath());
			fos.flush();
			dis.close();
			fos.close();
		}
		updateFilmInfo(film);
	}

	@SuppressWarnings("static-access")
	public void dodo() throws Exception {
		filmList = filmDao.selectAllFilm();
		for (Film film : filmList) {
			download(film);
			Thread.currentThread().sleep(1000);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	void updateFilmInfo(Film film) {
		filmDao.updateByPrimaryKeySelective(film);
	}
}

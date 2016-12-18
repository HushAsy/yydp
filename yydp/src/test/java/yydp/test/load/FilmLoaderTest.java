package yydp.test.load;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lf.yydp.db.dao.FilmInfoMapper;
import org.lf.yydp.db.dao.FilmMapper;
import org.lf.yydp.etl.loader.FilmInfoLoader;
import org.lf.yydp.etl.loader.FilmLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
//	@Autowired
//	private LoadFilm film;
//	@Autowired
//	private DownLoadSmallImg dowm;
	@Autowired
	private FilmLoader filmL;
	
	@Autowired
	private FilmInfoLoader filmI;
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Test
	public void tt() throws Exception{
//		film.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
////		dowm.dodo();
//		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
//		filmI.load("http://movie.mtime.com/157155/");
//		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
	} 
}

package yydp.test.load;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lf.yydp.load.downImg.DownLoadSmallImg;
import org.lf.yydp.load.extract.LoadFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
	@Autowired
	private LoadFilm film;
	@Autowired
	private DownLoadSmallImg dowm;
	@Test
	public void tt() throws Exception{
//		film.load("http://theater.mtime.com/China_Guangdong_Province_Shenzen/");
		dowm.dodo();
	} 
}

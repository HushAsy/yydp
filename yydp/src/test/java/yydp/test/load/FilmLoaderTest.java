package yydp.test.load;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lf.yydp.db.dao.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
//	@Autowired
//	private FilmLoader filmL;
//	
//	@Autowired
//	private FilmInfoLoader filmI;
	
	@Autowired
	private FilmMapper filmMapper;
	
//	@Autowired
//	private ImgDownLoad imgDown;
	
//	@Autowired
//	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@Test
	public void tt() throws Exception{
//		film.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
//		dowm.dodo();
//		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
//		filmI.load("http://movie.mtime.com/157155/");
//		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
//		filmL.load("http://theater.mtime.com/China_Hubei_Province_Wuhan/");
//		filmL.downImg();
//		imgDown.downLoad();
//		ThreadPoolTaskExecutor tp= new ThreadPoolTaskExecutor();
//		tp.setCorePoolSize(5);
//		tp.setMaxPoolSize(10);
//		tp.setQueueCapacity(25);
//		ImgDownLoad imgDown = new ImgDownLoad();
//		imgDown.setTaskExecutor(tp);
		
	} 

}

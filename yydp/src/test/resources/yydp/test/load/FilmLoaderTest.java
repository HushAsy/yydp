package yydp.test.load;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lf.yydp.load.FilmLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
	@Test
	public void tt(){
		try {
			FilmLoader film = new FilmLoader("http://theater.mtime.com/China_Guangdong_Province_Shenzen/");
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	} 
}

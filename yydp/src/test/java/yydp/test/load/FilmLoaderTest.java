package yydp.test.load;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
	
	@Test
	public void tt() throws Exception{
//		Date dd = new Date();
//		Date dd1 = new Date(1482219514450L);
//		
//		System.out.println(dd.toLocaleString()+"--"+dd1.toLocaleString());
//		System.out.println(dd.getTime());
//		Calendar calen = Calendar.getInstance();
//		calen.add(Calendar.MINUTE, 30);
//		System.out.println(calen.toString());
//		Date date = new Date(1482222131750L);
//		System.out.println(date.toLocaleString());
		Calendar calen = Calendar.getInstance(Locale.CHINA);
		calen.set(2016, 11, 20,28,0,0);
		calen.add(Calendar.DATE, 1);
//		calen.add(Calendar.MINUTE, 107);
	} 

}

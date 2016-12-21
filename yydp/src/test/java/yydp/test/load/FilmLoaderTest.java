package yydp.test.load;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
	
	@Test
	public void tt() throws Exception{
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));    //获取东八区时间

		  int year = c.get(Calendar.YEAR);    //获取年
		  int month = c.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
		  int day = c.get(Calendar.DAY_OF_MONTH);    //获取当前天数
		  int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
		  int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数
		  int time = c.get(Calendar.HOUR_OF_DAY);       //获取当前小时
		  int min = c.get(Calendar.MINUTE);          //获取当前分钟
		  int xx = c.get(Calendar.SECOND);          //获取当前秒

		  System.out.println(time);
		  SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		  String curDate = s.format(c.getTime());  //当前日期
		  System.out.println("当前时间："+year + "-" + month + "-"+ day + " "+time + ":" + min +":" + xx);
		  System.out.println("第一天和最后天：" + first +"," + last);

		  System.out.println("当前日期curDate====：" + curDate);
	} 

}

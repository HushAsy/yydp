package yydp.test.load;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lf.yydp.db.dao.UserMapper;
import org.lf.yydp.db.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class FilmLoaderTest {
	@Autowired
	private UserMapper userDao;
	@Test
	@Transactional(rollbackFor=Exception.class)
	public void tt() throws Exception{
		Date dateNow = new Date();
		System.out.println(dateNow.toLocaleString());
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.YEAR );
		cal.set(2016,12, 20, 9, 0, 0);
		System.out.println(new Date(cal.getTimeInMillis()).toLocaleString());
	} 

}

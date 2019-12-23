package cn.tedu.store;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void getConnextion() throws SQLException {
		System.err.println(dataSource.getConnection());
	}
	
	@Test
	public void md5() {
		String password ="1234";//加盐加密
		String salt=UUID.randomUUID().toString();//随机盐加密
		String md5Password=DigestUtils.md5DigestAsHex((salt+password).getBytes());
		System.out.println(md5Password);
	}
	
	

}

package cn.tedu.store.mapper;
/**
 * 测试持久层
 */
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("TOO");
		user.setPassword("1234");
		System.err.println(user);
		Integer rows= mapper.insert(user);
		System.err.println("rows:"+rows);
		System.err.println(user);
	}
	@Test
	public void updatePasswordByUid() {//修改密码测试
	    Integer uid = 27;
	    String password = "258369";
	    String modifiedUser = "超级管理员";
	    Date modifiedTime = new Date();
	    Integer rows = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
	    System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateAvatarByUid() {//修改头像
	    Integer uid =2;
	    String avatar = "图片";
	    String modifiedUser = "超级管理员";
	    Date modifiedTime = new Date();
	    Integer rows = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
	    System.err.println("rows=" + rows);
	}

	@Test
	public void findByUid() {
	    Integer uid = 14;
	    User result = mapper.findByUid(uid);
	    System.err.println(result);
	}
	 
	
	@Test 
	public void findByUsername() {
		String username="spring";
		User result=mapper.findByUsername(username);
		System.err.println(result);
		
	}
	
	@Test
	public void updateInfoByUid() {//更新用户资料的测试
		User user = new User();
		user.setUid(2);
		user.setPhone("138112313");
		user.setEmail("132@qq.com");
		user.setGender(1);
		user.setModifiedUser("管理员");
		user.setModifiedTime(new Date());
		
		Integer rows=mapper.updateInfoByUid(user);
		System.err.println("rows"+rows);
	}

}

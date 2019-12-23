package cn.tedu.store.service;
/**
 * 业务层测试层
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private IUserService service;
	
	@Test
	public void reg() {//注册用户
		try {
			User user= new User();
			user.setUsername("xiaogui");
			user.setPassword("1234");
			service.reg(user);
			System.err.println(user);
			System.err.println("ok.");
			
		} catch (Exception e) {
			System.err.println(e.getCause());
		}
	}
	
	@Test
	public void login() {//登录
		try {
			String username="xiaogui";
			String password="1234";
			User user = service.login(username, password);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getCause());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void changePassword() {//修改密码
	    try {
	        Integer uid = 17;
	        String username = "系统管理员";
	        String oldPassword = "1234";
	        String newPassword = "8888";
	        service.changePassword(uid, username, oldPassword, newPassword);
	        System.err.println("OK.");
	    } catch (ServiceException e) {
	        System.err.println(e.getClass());
	        System.err.println(e.getMessage());
	    }
	}
	
	@Test
	public void changeInfo() {//修改资料
	    try {
	        Integer uid = 3;
	        String username = "系统管理员";
	        User user = new User();
	        user.setEmail("464@qq.com");
	        user.setUsername("roots");
	        user.setGender(1);
	        service.changeInfo(uid, username,user);
	        System.err.println("OK.");
	    } catch (ServiceException e) {
	        System.err.println(e.getClass());
	        System.err.println(e.getMessage());
	    }
	}
	
	@Test
	public void updateAvatarByUid() {//修改头像
	    try {
	        Integer uid = 2;
	        String username = "系统管理员";
	        String avatar = "fsdf";
	        service.changeAvatar(uid, username,avatar);
	        System.err.println("OK.");
	    } catch (ServiceException e) {
	        System.err.println(e.getClass());
	        System.err.println(e.getMessage());
	    }
	}

}

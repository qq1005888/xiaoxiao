package cn.tedu.store.service;

import cn.tedu.store.entity.User;
/**
 * 处理用户相关业务的业务接口
 * @author JAVA
 *
 */
public interface IUserService {
	/**
	 * 用户注册
	 * @param user  新用户注册
	 */
	void reg(User user);
	
	/**
	 * 用户登录
	 * @param username   用户名
	 * @param password   密码
	 * @return   返回值
	 */
	User login(String username,String password);
	/**
	 * 修改密码
	 * @param uid  当前登录的用户id
	 * @param username  当前登录的用户名
	 * @param oldPassword  原密码
	 * @param newPassword  新密码
	 */
	void changePassword(Integer uid,String username,String Password,String newPassword);
	
	/**
	 * 修改用户资料
	 * @param uid  当前登录的用户的id
	 * @param username  当前登录的用户名
	 * @param user   用户的新资料，可以包含手机号码，电子邮箱，性别
	 */
	void changeInfo(Integer uid,String username,User user);

	/**
	 * 获取当前登录的用户资料
	 * @param uid  当前登录的用户id
	 * @return  该用户的资料
	 */
	User getInfo(Integer uid);
	/**
	 * 修改头像
	 * @param uid  当前登录的
	 * @param username
	 * @param avatar
	 */
	void changeAvatar(Integer uid,String username,String avatar);

}

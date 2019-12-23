package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileIOException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;

import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{//用户的控制器

	@Autowired
	private IUserService userService;


	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		//先创建返回值对象
		//调用userService的reg()方法实现注册
		userService.reg(user);
		//在返回值对象中封装1表示成功

		return new JsonResult<Void>(OK);
	}


	@RequestMapping("login")
	public JsonResult<User> login(String username,String password,HttpSession session){

		User user=userService.login(username, password);
		//将uid.username存入到Session中
		session.setAttribute("uid", user.getUid());
		session.setAttribute("username", user.getUsername());
		System.out.println("用户登录成功");
		System.out.println("\tsession.uid="+user.getUid());
		System.out.println("\tsession.username="+user.getUsername());
		//返回
		return new JsonResult<>(OK,user);
	}

	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
		//从Session中获取uid和usename
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		//调用userService的方法实现功能
		userService.changePassword(uid,username,oldPassword,newPassword);
		return new JsonResult<>(OK);
	}
	
	@RequestMapping("change_info")
	public JsonResult<Void> changePassword(User user,HttpSession session){
		//从Session中获取uid和usename
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		//调用userService的方法实现功能
		userService.changeInfo(uid,username,user);
		return new JsonResult<>(OK);
	}

	@GetMapping("info")
	public JsonResult<User> getinfo(HttpSession session){
		//从Session中获取uid
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		//调用userService的方法实现功能
		User user = userService.getInfo(uid);
		System.err.println(user.getUsername());
		System.err.println(user.getGender());
		System.err.println(user.getEmail());
		System.err.println(user.getPhone());
		return new JsonResult<User>(OK,user);
	}
	
	//项目启动的时候，设定了上限值
	@Value("${project.avatar-max-size}")
	private int maxSize;
	//允许通过的文件类型
	private static final List<String> AVATART_TYPES= new ArrayList<>();
	static {
		AVATART_TYPES.add("image/jpeg");
		AVATART_TYPES.add("image/png");
	}
	@PostMapping("change_avatar")
	public JsonResult<String> changeAvatar(@RequestParam("file")MultipartFile file,HttpSession session){
		//检查上传的文件是否为空
		if(file.isEmpty()) {
			throw new FileEmptyException("请选择您要上传的头像文件");
		}
		
		//检查上传的文件大小
		if(file.getSize()>maxSize) {
			throw new FileSizeException("不允许上超过"+maxSize/1024+"的文件");
		}
		
		//检查上传的文件类型:imge/jpeg,image/png
		if(!AVATART_TYPES.contains(file.getContentType())) {
			throw new FileTypeException("你上传的头像类型超出了限制，允许上传的文件类型有:"+AVATART_TYPES);
		}
		
		//长篇代码:倒着写, 最小化
		
		//获取员文件名
		String originalFilename=file.getOriginalFilename();
		
		//保存上传头像的文件夹
		String dir=session.getServletContext().getRealPath("upload");
		File dirFile = new File(dir);
		if(!dirFile.exists()) {
			dirFile.mkdir();
		}
		//保存上传的头像时使用的文件名
		String name = System.currentTimeMillis()+"-"+System.nanoTime();
		String suffix="";
		int i = originalFilename.lastIndexOf(".");
		
		if(i>0) {
			suffix=originalFilename.substring(i);
		}
		String filename= name+suffix;
		//更新用户的头像
		// 用户头像的路径(响应给客户端的，且存入到数据库的)
				String avatar = "/upload/" + filename;
				System.out.println("avatar=" + avatar);
				
				try {
					// 执行保存
					File dest = new File(dir, filename);
					file.transferTo(dest);
				} catch (IllegalStateException e) {
					throw new FileStateException("文件状态异常，可能员文件已经无法访问，请重新选择文件");
				} catch (IOException e) {
					throw new FileIOException("读写文件时出现异常，请重新上传");
				}
				
				// 从Session中获取uid和username
				Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
				String username = session.getAttribute("username").toString();
				// 更新用户的头像
				userService.changeAvatar(uid, username, avatar);
				// 返回
				return new JsonResult<>(OK,avatar);
	}
}

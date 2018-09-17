package cn.orange.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.orange.bean.ResponseResult;
import cn.orange.bean.User;
import cn.orange.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;
	
	/*
	 * 显示登录界面
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin(HttpSession session){
		session.invalidate();
		return "login";
	}
	/*
	 * 退出清空session
	 */
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:../main/showHome.do";
	}
	/*
	 * 显示注册界面
	 */
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	/*
	 * 显示个人信息
	 */
	@RequestMapping("/showPersonalPage.do")
	public String showPerson(){
		return "personalPage";
	}
	/*
	 * 显示修改密码
	 */
	@RequestMapping("/showPersonalPwd.do")
	public String showPersonalPwd(){
		return "personalPwd";
	}
	/*
	 * 显示修改信息
	 */
	@RequestMapping("/showChangeUserInfo.do")
	public String showChangeUserInfo(){
		return "changeUserInfo";
	}
	/*
	 * 异步请求处理登录
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr=null;
		try{
			User user=userService.login(username, password);
			rr=new ResponseResult<Void>(1,"登录成功");
			session.setAttribute("user", user);
		}catch(RuntimeException ex){
			rr=new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	/*
	 * 异步处理注册
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(String username,String password,String nickname,String email,String phone,HttpSession session){
		ResponseResult<Void> rr=null;
		try{
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setPhone(phone);
			userService.addUser(user);
			session.setAttribute("user", user);
			rr=new ResponseResult<Void>(1,"注册成功");
		}catch(RuntimeException ex){
			rr=new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	/*
	 * 异步请求修改密码
	 */
	@RequestMapping("/changePwd.do")
	@ResponseBody
	public ResponseResult<Void> changePwd(HttpSession session,String oldPwd,String newPwd,String checkPwd){
		ResponseResult<Void> rr=null;
		try{
			userService.changePwd(this.getId(session), oldPwd, newPwd,checkPwd);
			rr=new ResponseResult<Void>(1,"修改成功");
		}catch(RuntimeException ex){
			rr=new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	/*
	 * 异步请求修改用户信息
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(String nickname,String email,String phone,HttpSession session){
		ResponseResult<Void> rr=null;
		try{
			userService.updateUser(this.getId(session), nickname, email, phone);
			User user=userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
			rr=new ResponseResult<Void>(1,"修改成功");
		}catch(RuntimeException ex){
			rr=new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
}

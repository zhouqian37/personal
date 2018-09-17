package cn.orange.service;

import cn.orange.bean.User;

public interface IUserService {
	/*
	 * 通过id获取用户
	 */
	User getUserById(Integer id);
	/*
	 * 通过username获取用户
	 */
	User getUserByUsername(String username);
	/*
	 * 处理登录逻辑
	 */
	User login(String username,String password);
	/*
	 * 添加用户
	 */
	void addUser(User user);
	/*
	 * 修改密码
	 */
	void changePwd(Integer id,String oldPwd,String newPwd,String checkPwd);
	/*
	 * 修改用户信息
	 */
	void updateUser(Integer id,String nickname,String email,String phone);
}

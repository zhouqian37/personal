package cn.orange.controller;

import javax.servlet.http.HttpSession;

import cn.orange.bean.User;

public class BaseController {
	// 从session中获取用户id的值
	public Integer getId(HttpSession session) {
		Integer id = null;
		User user = (User) session.getAttribute("user");
		if (user != null) {
			id = user.getId();
		}
		return id;
	}
}

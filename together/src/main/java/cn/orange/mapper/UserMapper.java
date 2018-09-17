package cn.orange.mapper;

import cn.orange.bean.User;

public interface UserMapper {
	/**
	 * 通过id查找用户
	 * @param id主键值
	 * @return User用户对象
	 */
	User selectById(Integer id);
	/**
	 * 通过用户名查找用户
	 * @param username
	 * @return 用户对象
	 */
	User selectByUsername(String username);
	/**
	 * 插入用户
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 修改用户信息
	 */
	void updateUser(User user);
}

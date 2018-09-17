package cn.orange.mapper;

import java.util.List;

import cn.orange.bean.Activity;
import cn.orange.bean.User;

public interface ActivityMapper {
	/**
	 * 查询所有活动
	 */
	List<Activity> selectAllAct(); 
	/**
	 * 添加活动
	 */
	void insertAct(Activity act);
	/**
	 * 通过uid查找活动
	 */
	List<Activity> selectUserActByUid(Integer uid);
	/**
	 * 模糊搜索，搜索栏查找活动
	 */
	List<Activity> selectActivityBySearch(String search);
	/**
	 * 通过活动id获取活动详情
	 */
	Activity selectActivityById(Integer id);
	/**
	 * 通过活动aid查询用户信息，并放入list中
	 */
	List<User> selectUserByAid(Integer aid);
	/**
	 * 通过分类id查询活动
	 */
	List<Activity> selectActivityByCategoryId(Integer id);
}

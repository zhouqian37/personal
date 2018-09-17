package cn.orange.service;

import java.util.List;

import cn.orange.bean.Activity;
import cn.orange.bean.User;

public interface IActivityService {
	/*
	 * 获取所有活动
	 */
	List<Activity> getAllAct();
	/*
	 * 创建活动，并返回自增主键值
	 */
	Integer addAct(String categoryId,String actName,String actPlace,String actDetail,String actCost,String actPrice,String actSum,String actTime);
	/*
	 * 通过用户id获取活动
	 */
	List<Activity> getActByUid(Integer uid);
	/*
	 * 搜索活动
	 */
	List<Activity> getActBySearch(String search);
	/*
	 * 通过id获取活动
	 */
	Activity getActById(Integer id);
	/*
	 * 通过活动id获取参与的用户
	 */
	List<User> getActUserByAid(Integer aid);
	/*
	 * 通过分类id获取活动
	 */
	List<Activity> getActByCategoryId(Integer categoryId);
}

package cn.orange.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.orange.bean.Activity;
import cn.orange.bean.User;
import cn.orange.mapper.ActivityMapper;

@Service
public class ActivityService implements IActivityService {
	@Resource
	private ActivityMapper activityMapper;
	/*
	 * 获取所有活动
	 */
	public List<Activity> getAllAct() {
		List<Activity> list=activityMapper.selectAllAct();
		return list;
	}
	/*
	 * 创建活动，并返回自增主键值
	 */
	public Integer addAct(String categoryId, String actName, String actPlace, String actDetail, String actCost,
			String actPrice, String actSum, String actTime) {
		Activity act=new Activity();
		act.setCategoryId(Integer.parseInt(categoryId));
		act.setActName(actName);
		act.setActPlace(actPlace);
		act.setActDetail(actDetail);
		act.setActCost(Double.parseDouble(actCost));
		act.setActPrice(Double.parseDouble(actPrice));
		act.setActSum(Integer.parseInt(actSum));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date time = sdf.parse(actTime);
			act.setActTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		activityMapper.insertAct(act);
		return act.getId();
	}
	/*
	 * 通过用户id获取活动
	 */
	public List<Activity> getActByUid(Integer uid) {
		List<Activity> list=activityMapper.selectUserActByUid(uid);
		return list;
	}
	/*
	 * 搜索活动
	 */
	public List<Activity> getActBySearch(String search) {
		List<Activity> list=activityMapper.selectActivityBySearch(search);
		return list;
	}
	/*
	 * 通过id获取活动
	 */
	public Activity getActById(Integer id) {
		Activity act=activityMapper.selectActivityById(id);
		return act;
	}
	/*
	 * 通过活动id获取参与的用户
	 */
	public List<User> getActUserByAid(Integer aid) {
		List<User> list=activityMapper.selectUserByAid(aid);
		return list;
	}
	/*
	 * 通过分类id获取活动
	 */
	public List<Activity> getActByCategoryId(Integer categoryId) {
		List<Activity> list=activityMapper.selectActivityByCategoryId(categoryId);
		return list;
	}

}

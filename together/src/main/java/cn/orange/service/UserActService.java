package cn.orange.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.orange.bean.UserAct;
import cn.orange.mapper.UserActMapper;

@Service
public class UserActService implements IUserActService {
	@Resource
	private UserActMapper userActMapper;
	/*
	 * 添加用户和活动信息关联信息
	 */
	public void addUserAct(Integer uid,Integer aid){
		UserAct ua=new UserAct();
		ua.setUid(uid);
		ua.setAid(aid);
		userActMapper.insertUserAct(ua);
	}
	/*
	 * 删除用户活动
	 */
	public void deleteUserAct(Integer uid, Integer aid) {
		userActMapper.deleteUserAct(uid, aid);
	}
	/*
	 * 通过活动aid查询已参加该活动人数
	 */
	public Integer getUserSumByAid(Integer aid){
		return userActMapper.selectUserSumByAid(aid);
	}
	/*
	 * 查看该用户有没有参加该活动
	 */
	public Integer getUser(Integer uid, Integer aid) {
		return userActMapper.selectUser(uid, aid);
	}
}

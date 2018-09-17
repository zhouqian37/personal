package cn.orange.service;

public interface IUserActService {
	/*
	 * 添加用户和活动信息关联信息
	 */
	void addUserAct(Integer uid,Integer aid);
	/*
	 * 删除用户活动
	 */
	void deleteUserAct(Integer uid,Integer aid);
	/*
	 * 通过活动aid查询已参加该活动人数
	 */
	Integer getUserSumByAid(Integer aid);
	/*
	 * 查看该用户有没有参加该活动
	 */
	Integer getUser(Integer uid,Integer aid);
}

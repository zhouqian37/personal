package cn.orange.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.orange.bean.UserAct;

public interface UserActMapper {
	/**
	 * 添加用户到活动中
	 * @param ua
	 */
	void insertUserAct(UserAct ua);
	/**
	 * 从活动中删除用户
	 * @param uid
	 * @param aid
	 */
	void deleteUserAct(@Param("uid") Integer uid,@Param("aid") Integer aid);
	/**
	 * 查询已参与活动的人数
	 * @param aid
	 * @return
	 */
	Integer selectUserSumByAid(Integer aid);
	/**
	 * 查询该用户是否参与此活动
	 * @param uid
	 * @param aid
	 * @return
	 */
	Integer selectUser(@Param("uid") Integer uid,@Param("aid") Integer aid);
}

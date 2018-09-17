package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.orange.bean.UserAct;
import cn.orange.mapper.UserActMapper;

public class TestUserAct {
	@Test
	public void testInsertUserAct(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserActMapper uam=ac.getBean("userActMapper",UserActMapper.class);
		UserAct ua=new UserAct();
		ua.setUid(1);
		ua.setAid(2);
		uam.insertUserAct(ua);
		ac.close();
	}
	
	@Test
	public void testDeleteUserAct(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserActMapper uam=ac.getBean("userActMapper",UserActMapper.class);
		uam.deleteUserAct(1,3);
		ac.close();
	}
	
	@Test
	public void testSelectUserSumByAid(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserActMapper uam=ac.getBean("userActMapper",UserActMapper.class);
		System.out.println(uam.selectUserSumByAid(3));
		ac.close();
	}
	
	@Test
	public void testSelectUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserActMapper uam=ac.getBean("userActMapper",UserActMapper.class);
		System.out.println(uam.selectUser(6, 2));
		ac.close();
	}
}

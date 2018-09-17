package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.orange.bean.User;
import cn.orange.mapper.UserMapper;
import cn.orange.service.IUserService;

public class TestUser {
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user=um.selectById(1);
		System.out.println(user);
		ac.close();
	}
	
	@Test
	public void testInsertUser(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("daidongmin");
		user.setPassword("123123");
		user.setNickname("ddm");
		user.setEmail("ddm@126.com");
		user.setPhone("13838384388");
		um.insertUser(user);
		ac.close();
	}
	
	@Test
	public void testGetUserById(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService userService=ac.getBean("userService",IUserService.class);
		User user=userService.getUserById(2);
		System.out.println(user);
		ac.close();
	}
	
	@Test
	public void testGetUserByUsername(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService userService=ac.getBean("userService",IUserService.class);
		User user=userService.getUserByUsername("daidongmin");
		System.out.println(user);
		ac.close();
	}
}

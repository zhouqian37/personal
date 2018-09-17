package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.orange.mapper.CategoryMapper;

public class TestCategory {
	@Test
	public void testSelectAllCategory(){
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("application-dao.xml");
		CategoryMapper cm=ac.getBean("categoryMapper",CategoryMapper.class);
		System.out.println(cm.selectAllCategory());
		ac.close();
	}
}

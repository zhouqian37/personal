package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.orange.bean.Activity;
import cn.orange.mapper.ActivityMapper;
import cn.orange.service.IActivityService;

public class TestActivity {
	@Test
	public void testSelectAllAct() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		System.out.println(am.selectAllAct());
		ac.close();
	}

	@Test
	public void testGetAllAct() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml",
				"application-service.xml");
		IActivityService as = ac.getBean("activityService", IActivityService.class);
		System.out.println(as.getAllAct());
		ac.close();
	}
	
	@Test
	public void testInsertActivity(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		Activity act=new Activity();
		act.setCategoryId(1);
		act.setActName("撸串");
		act.setActTime(new Date());
		act.setActPlace("南长街");
		act.setActDetail("一起来撸串");
		act.setActCost(200.00);
		act.setActSum(4);
		act.setActPrice(50.00);
		am.insertAct(act);
		ac.close();
	}
	
	@Test
	public void testSelectUserActByUid(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		System.out.println(am.selectUserActByUid(1));
		ac.close();
	}
	
	@Test
	public void testGetActByUid(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml",
				"application-service.xml");
		IActivityService as = ac.getBean("activityService", IActivityService.class);
		System.out.println(as.getActByUid(1));
		ac.close();
	}
	
	@Test
	public void testSelectBySearch(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		System.out.println(am.selectActivityBySearch("火锅"));
		ac.close();
	}
	
	@Test
	public void testSelectActById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		Activity act=am.selectActivityById(4);
		System.out.println(act);
		ac.close();
	}
	
	@Test
	public void testSelectActByCategoyId(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		ActivityMapper am = ac.getBean("activityMapper", ActivityMapper.class);
		List<Activity> list=am.selectActivityByCategoryId(1);
		System.out.println(list);
		ac.close();
	}
}

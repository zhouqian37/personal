package cn.orange.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.orange.bean.Activity;
import cn.orange.bean.ResponseResult;
import cn.orange.bean.User;
import cn.orange.service.IActivityService;
import cn.orange.service.IUserActService;
import cn.orange.service.excep.UsernameNotFoundException;

@Controller
@RequestMapping("/act")
public class ActivityController extends BaseController {
	@Resource
	private IActivityService activityService;
	@Resource
	private IUserActService userActService;
	/*
	 * 展示个人所有参加的活动
	 */
	@RequestMapping("/showActivity.do")
	public String showActivity(ModelMap map,HttpSession session){
		Integer uid=this.getId(session);
		List<Activity> listAct=activityService.getActByUid(uid);
		map.addAttribute("listAct", listAct);
		return "activity";
	}
	/*
	 * 显示创建活动页面
	 */
	@RequestMapping("/showCreateActivity.do")
	public String showCreateActivity(){
		return "createActivity";
	}
	/*
	 * 显示查询活动页面
	 */
	@RequestMapping("/showSearchResult.do")
	public String showSearchResult(ModelMap map,HttpSession session){
		List<Activity> list=(List<Activity>) session.getAttribute("listResult");
		map.addAttribute("list", list);
		return "searchResult";
	}
	/*
	 * 显示还未参加的活动详情页面
	 */
	@RequestMapping("/showActDetail.do")
	public String showActDetail(Integer id,ModelMap map){
		Activity act=activityService.getActById(id);
		map.addAttribute("act", act);
		return "actDetail";
	}
	/*
	 * 显示已参加的活动也面并显示参与的所有用户
	 */
	@RequestMapping("/showActUserDetail.do")
	public String showActUserDetail(Integer id,Integer aid,ModelMap map){
		Activity act=activityService.getActById(id);
		List<User> listUser=activityService.getActUserByAid(aid);
		map.addAttribute("act", act);
		map.addAttribute("listUser", listUser);
		return "actUserDetail";
	}
	/*
	 * 显示各个分类的所有活动
	 */
	@RequestMapping("/getCategoryAct.do")
	public String getCategoryAct(Integer categoryId,ModelMap map){
		List<Activity> listCateAct=activityService.getActByCategoryId(categoryId);
		map.addAttribute("listCateAct", listCateAct);
		return "categoryAct";
	}
	/*
	 * 异步请求完成创建活动
	 */
	@RequestMapping("/createActivity.do")
	@ResponseBody
	public ResponseResult<Void> addActivity(String categoryId, String actName, String actPlace, 
			String actDetail, String actCost,String actPrice, String actSum, String actTime,HttpSession session){
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		Integer aid=activityService.addAct(categoryId, actName, actPlace, actDetail, actCost, actPrice, actSum, actTime);
		Integer uid=this.getId(session);
		userActService.addUserAct(uid, aid);
		return rr;
	}
	/*
	 * 异步请求完成搜索活动，并将结果发给查询结果页面
	 */
	@RequestMapping("/search.do")
	@ResponseBody
	public ResponseResult<Void> getSearch(String search,HttpSession session){
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		List<Activity> listResult=activityService.getActBySearch(search);
		session.setAttribute("listResult", listResult);
		return rr;
	}
	/*
	 * 异步请求将用户添加到活动中
	 */
	@RequestMapping("/addUserToActivity.do")
	@ResponseBody
	public ResponseResult<Void> addUserToActivity(Integer uid,Integer aid){
		ResponseResult<Void> rr=null;
		Integer userSum=userActService.getUserSumByAid(aid);
		Integer sum=activityService.getActById(aid).getActSum();
		Integer result=userActService.getUser(uid, aid);
		if(result==0){
			if(userSum<sum){
				rr=new ResponseResult<Void>(1,"成功");
				userActService.addUserAct(uid, aid);
			}else{
				rr=new ResponseResult<Void>(0,"该活动人数已满");
			}
		}else{
			rr=new ResponseResult<Void>(0,"您已参加该活动");
		}
		return rr;
	}
	/*
	 * 异步请求离开该活动
	 */
	@RequestMapping("/leaveActivity.do")
	@ResponseBody
	public ResponseResult<Void> leaveActivity(Integer uid,Integer aid){
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		userActService.deleteUserAct(uid, aid);
		return rr;
	}
}

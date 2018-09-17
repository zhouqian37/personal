package cn.orange.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.orange.bean.Category;
import cn.orange.bean.ResponseResult;
import cn.orange.service.ICategoryService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private ICategoryService categoryService;
	/*
	 * 主页面
	 */
	@RequestMapping("/showHome.do")
	public String showHome(){
		return "home";
	}
	/*
	 * 异步请求获取所有分类并展示在页面上
	 */
	@RequestMapping("/getCategory.do")
	@ResponseBody
	public ResponseResult<List<Category>> getCategory(){
		ResponseResult<List<Category>> rr=new ResponseResult<List<Category>>(1,"成功");
		List<Category> listCate=categoryService.getAllCategory();
		rr.setData(listCate);
		return rr;
	}
}

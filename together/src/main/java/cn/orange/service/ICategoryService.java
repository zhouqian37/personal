package cn.orange.service;

import java.util.List;

import cn.orange.bean.Category;

public interface ICategoryService {
	/*
	 * 获得所有分类
	 */
	List<Category> getAllCategory();
}

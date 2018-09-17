package cn.orange.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.orange.bean.Category;
import cn.orange.mapper.CategoryMapper;

@Service
public class CategoryService implements ICategoryService {
	@Resource
	private CategoryMapper categoryMapper;
	/*
	 * 获得所有分类
	 */
	public List<Category> getAllCategory() {
		List<Category> list=categoryMapper.selectAllCategory();
		return list;
	}

}

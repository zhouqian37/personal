package cn.orange.mapper;

import java.util.List;

import cn.orange.bean.Category;

public interface CategoryMapper {
	/**
	 * 查找所有分类
	 */
	List<Category> selectAllCategory();
	/**
	 * 通过id查找分类
	 */
	Category selectCategoryById(Integer id);
}

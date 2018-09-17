package cn.orange.bean;

import java.io.Serializable;

public class Category implements Serializable {
	private static final long serialVersionUID = 2596859075752949486L;
	private Integer id;
	private String CategoryName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CategoryName == null) ? 0 : CategoryName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (CategoryName == null) {
			if (other.CategoryName != null)
				return false;
		} else if (!CategoryName.equals(other.CategoryName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", CategoryName=" + CategoryName + "]";
	}
	
}

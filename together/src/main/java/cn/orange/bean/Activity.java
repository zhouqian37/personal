package cn.orange.bean;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
	private static final long serialVersionUID = -2870605250059836296L;
	private Integer id;
	private Integer categoryId;
	private String actName;
	private String actPlace;
	private String actDetail;
	private Double actCost;
	private Double actPrice;
	private Integer actSum;
	private Date actTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getActName() {
		return actName;
	}
	public void setActName(String actName) {
		this.actName = actName;
	}
	public String getActPlace() {
		return actPlace;
	}
	public void setActPlace(String actPlace) {
		this.actPlace = actPlace;
	}
	public String getActDetail() {
		return actDetail;
	}
	public void setActDetail(String actDetail) {
		this.actDetail = actDetail;
	}
	public Double getActCost() {
		return actCost;
	}
	public void setActCost(Double actCost) {
		this.actCost = actCost;
	}
	public Double getActPrice() {
		return actPrice;
	}
	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}
	public Integer getActSum() {
		return actSum;
	}
	public void setActSum(Integer actSum) {
		this.actSum = actSum;
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actCost == null) ? 0 : actCost.hashCode());
		result = prime * result + ((actDetail == null) ? 0 : actDetail.hashCode());
		result = prime * result + ((actName == null) ? 0 : actName.hashCode());
		result = prime * result + ((actPlace == null) ? 0 : actPlace.hashCode());
		result = prime * result + ((actPrice == null) ? 0 : actPrice.hashCode());
		result = prime * result + ((actSum == null) ? 0 : actSum.hashCode());
		result = prime * result + ((actTime == null) ? 0 : actTime.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		Activity other = (Activity) obj;
		if (actCost == null) {
			if (other.actCost != null)
				return false;
		} else if (!actCost.equals(other.actCost))
			return false;
		if (actDetail == null) {
			if (other.actDetail != null)
				return false;
		} else if (!actDetail.equals(other.actDetail))
			return false;
		if (actName == null) {
			if (other.actName != null)
				return false;
		} else if (!actName.equals(other.actName))
			return false;
		if (actPlace == null) {
			if (other.actPlace != null)
				return false;
		} else if (!actPlace.equals(other.actPlace))
			return false;
		if (actPrice == null) {
			if (other.actPrice != null)
				return false;
		} else if (!actPrice.equals(other.actPrice))
			return false;
		if (actSum == null) {
			if (other.actSum != null)
				return false;
		} else if (!actSum.equals(other.actSum))
			return false;
		if (actTime == null) {
			if (other.actTime != null)
				return false;
		} else if (!actTime.equals(other.actTime))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
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
		return "Activity [id=" + id + ", categoryId=" + categoryId + ", actName=" + actName + ", actPlace=" + actPlace
				+ ", actDetail=" + actDetail + ", actCost=" + actCost + ", actPrice=" + actPrice + ", actSum=" + actSum
				+ ", actTime=" + actTime + "]";
	}
}

package com.zhanglei.hgshop.pojo;

import java.io.Serializable;

/** 
* @ClassName: SpecOption 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月4日 下午4:08:19 
*/
public class SpecOption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6784990756914172422L;
	private Integer id;
	private String optionName;
	private int specId;
	private int orders=0;
	@Override
	public String toString() {
		return "SpecOption [id=" + id + ", optionName=" + optionName + ", specId=" + specId + ", orders=" + orders
				+ "]";
	}
	public SpecOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpecOption(Integer id, String optionName, int specId, int orders) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.specId = specId;
		this.orders = orders;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + orders;
		result = prime * result + specId;
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
		SpecOption other = (SpecOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orders != other.orders)
			return false;
		if (specId != other.specId)
			return false;
		return true;
	}
	
}

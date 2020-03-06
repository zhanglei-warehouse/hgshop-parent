package com.zhanglei.hgshop.pojo;

import java.io.Serializable;

/**
 * @ClassName: Brand
 * @Description: TODO
 * @author: lei zhang
 * @date: 2020年3月3日 下午12:09:29
 */
public class Brand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8327645638494844862L;
	private Integer id;
	private String name;
	private String firstChar;
	private int deletedFlag;
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", firstChar=" + firstChar + ", deletedFlag=" + deletedFlag + "]";
	}
	public Brand(Integer id, String name, String firstChar, int deletedFlag) {
		super();
		this.id = id;
		this.name = name;
		this.firstChar = firstChar;
		this.deletedFlag = deletedFlag;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstChar() {
		return firstChar;
	}
	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}
	public int getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(int deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	
	
}

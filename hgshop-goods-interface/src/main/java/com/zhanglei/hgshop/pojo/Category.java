package com.zhanglei.hgshop.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 
* @ClassName: Category 
* @Description: TODO
* @author: lei zhang
* @date: 2020年3月3日 下午12:11:41 
*/
public class Category implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -780653814722373326L;

	private Integer id; // 
	
	private Integer parentId; // 上一级别分类的id  parent_id
	
	@JsonProperty("text")
	private String name;//分类的名称
	
	
	private String path;// 从根分类到当前分类的路径
	
	/**
	 * 子节点的列表
	 */
	@JsonProperty("nodes")
	private List<Category> children;// 从根分类到当前分类的路径

	@Override
	public String toString() {
		return "Category [id=" + id + ", parentId=" + parentId + ", name=" + name + ", path=" + path + ", children="
				+ children + "]";
	}

	public Category(Integer id, Integer parentId, String name, String path, List<Category> children) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.path = path;
		this.children = children;
	}

	public Category() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
	
	
}

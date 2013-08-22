package com.aixuexiao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级动态
 */
public class ClassesNews implements Serializable {
	
	/**
	 * 公告编号
	 */
	private int id;
	
	/**
	 * 班级编号
	 */
	private int classid;
	
	/**
	 * 公告内容
	 */
	private String content;
	
	/**
	 * 发布时间
	 */
	private Date inserttime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInserttime() {
		return inserttime;
	}

	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	
	
}

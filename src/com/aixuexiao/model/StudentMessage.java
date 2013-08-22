package com.aixuexiao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 给学生的留言
 */
public class StudentMessage implements Serializable {
	
	/**
	 * 留言编号
	 */
	private int id;
	
	/**
	 * 学生编号
	 */
	private int studentid;
	
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

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
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

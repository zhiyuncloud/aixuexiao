package com.aixuexiao.model;

import java.io.Serializable;

/**
 * 班级实体
 */
public class Classes implements Serializable {
	
	/**
	 * 班级编号 
	 */
	private int id;
	
	/**
	 * 班级名称 如： 三年级二班
	 */
	private String name;
	
	/**
	 * 班主任
	 */
	private String headteacher;
	
	/**
	 * 学生数量
	 */
	private int studentcount;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadteacher() {
		return headteacher;
	}

	public void setHeadteacher(String headteacher) {
		this.headteacher = headteacher;
	}

	public int getStudentcount() {
		return studentcount;
	}

	public void setStudentcount(int studentcount) {
		this.studentcount = studentcount;
	}

	
}

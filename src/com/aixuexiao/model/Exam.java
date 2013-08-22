package com.aixuexiao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 考试实体
 */
public class Exam implements Serializable {
	
	/**
	 * 考试编号
	 */
	private int id;
	
	/**
	 * 班级编号
	 */
	private int classid;
	
	/**
	 * 考试科目
	 */
	private String course;
	
	/**
	 * 考试时间
	 */
	private Date examtime;
	
	/**
	 * 考试满分
	 */
	private BigDecimal fullmarks;
	
	/**
	 * 平均分
	 */
	private BigDecimal average;
	
	/**
	 * 最高分
	 */
	private BigDecimal topmark;
	
	/**
	 * 最低分
	 */
	private BigDecimal lowestmark;
	
	/**
	 * 考试备注
	 */
	private String remark;

	/**
	 * 考试的成绩列表
	 */
	private List<ExamMark> examMarks;
	
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getExamtime() {
		return examtime;
	}

	public void setExamtime(Date examtime) {
		this.examtime = examtime;
	}

	
	public BigDecimal getFullmarks() {
		return fullmarks;
	}

	public void setFullmarks(BigDecimal fullmarks) {
		this.fullmarks = fullmarks;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	public BigDecimal getTopmark() {
		return topmark;
	}

	public void setTopmark(BigDecimal topmark) {
		this.topmark = topmark;
	}

	public BigDecimal getLowestmark() {
		return lowestmark;
	}

	public void setLowestmark(BigDecimal lowestmark) {
		this.lowestmark = lowestmark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<ExamMark> getExamMarks() {
		return examMarks;
	}

	public void setExamMarks(List<ExamMark> examMarks) {
		this.examMarks = examMarks;
	}

}

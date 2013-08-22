package com.aixuexiao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 考试分数
 */
public class ExamMark implements Serializable,Comparable<ExamMark> {
	
	/**
	 * 考试编号
	 */
	private int examid;
	
	/**
	 * 班级编号
	 */
	private int classid;
	
	/**
	 * 学生编号
	 */
	private int studentid;
	
	/**
	 * 学生姓名
	 */
	private String studentname;
	
	/**
	 * 考试时间
	 */
	private Date examtime;
	
	/**
	 * 分数
	 */
	private BigDecimal mark;
	
	/**
	 * 排名
	 */
	private int rank;
	 
	/**
	 * 考试备注
	 */
	private String remark;

	/**
	 * 所属考试实体
	 */
	private Exam exam;
	
	public int getExamid() {
		return examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public Date getExamtime() {
		return examtime;
	}

	public void setExamtime(Date examtime) {
		this.examtime = examtime;
	}
	
	public BigDecimal getMark() {
		return mark;
	}

	public void setMark(BigDecimal mark) {
		this.mark = mark;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	@Override
	public int compareTo(ExamMark em) {
		return this.mark.compareTo(em.mark);
	}

	@Override
	public String toString() {
		return "ExamMark [examid=" + examid + ", classid=" + classid
				+ ", studentid=" + studentid + ", examtime=" + examtime
				+ ", mark=" + mark + ", rank=" + rank + ", remark=" + remark
				+ ", exam=" + exam + "]";
	}

	 
	
	
}

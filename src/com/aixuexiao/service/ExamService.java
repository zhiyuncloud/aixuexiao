package com.aixuexiao.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aixuexiao.dao.ClassesDao;
import com.aixuexiao.dao.ExamDao;
import com.aixuexiao.dao.StudentDao;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.Exam;
import com.aixuexiao.model.ExamMark;
import com.aixuexiao.model.Student;

@Service("examService")
public class ExamService {

	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Resource(name="classesDao")
	private ClassesDao classesDao;
	
	@Resource(name="examDao")
	private ExamDao examDao;
	
	/**
	 * 保存考试信息
	 * @param exam
	 */
	public void addExam(Exam exam){
		examDao.addExam(exam);
		for(ExamMark em:exam.getExamMarks()){
			em.setExamid(exam.getId());
			examDao.addExamMark(em);
		}
	}
	
	/**
	 * 根据考试id查找数据库中考试信息
	 * @param id
	 * @return
	 */
	public Exam findExamById(int id){
		return examDao.findExamById(id);
	}
	
	/**
	 * 将数据库中Student数据分页查出
	 * @param start 其实数据条数
	 * @param size  展示数据每页的大小
	 */
	public List<Exam> listExam(int start,int size,Exam exam){
		return examDao.findExam(start,size,exam);
	}
	 
	public List<Student> findStudentByClassesId(int classesid) {
		return studentDao.findStudentByClassesId(classesid);
	}
	
	/**
	 * 根据学生编号查找对应的学生
	 * @param studentid 学生编号
	 * @return 学生数据
	 */
	public Student findStudentById(int studentid){
		return studentDao.findStudentById(studentid);
	}
	
	/**
	 * 将数据库中Classes数据全部查出
	 */
	public List<Classes> findAllClasses(){
		return classesDao.findAllClasses();
	}
	
}

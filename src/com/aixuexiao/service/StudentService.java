package com.aixuexiao.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aixuexiao.dao.ClassesDao;
import com.aixuexiao.dao.ExamDao;
import com.aixuexiao.dao.StudentDao;
import com.aixuexiao.dao.StudentMessageDao;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ExamMark;
import com.aixuexiao.model.Student;
import com.aixuexiao.model.StudentMessage;

@Service("studentService")
public class StudentService {

	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Resource(name="classesDao")
	private ClassesDao classesDao;
	
	@Resource(name="studentMessageDao")
	private StudentMessageDao studentMessageDao;
	
	@Resource(name="examDao")
	private ExamDao examDao;
	
	/**
	 * 根据学生编号查找对应的考试信息
	 * @param id 学生编号
	 * @param limit
	 * @return
	 */
	public List<ExamMark> findExamMarkByStudentId(int id ,int limit){
		return examDao.findExamMarkByStudentId(id, limit);
	}
	
	
	/**
	 * 将数据库中Student数据分页查出
	 * @param start 其实数据条数
	 * @param size  展示数据每页的大小
	 */
	public List<Student> listStudent(int start,int size,Student student){
		return studentDao.findStudent(start,size,student);
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
	 * 添加老师给学生的微信留言到数据库
	 * @param studentMessage
	 */
	public void addStudentMessage(StudentMessage studentMessage){
		studentMessageDao.addStudentMessage(studentMessage);
	}
	
	/**
	 * 根据id删除老师给学生的微信留言
	 * @param id
	 */
	public void deleteStudentMessageById(int id){
		studentMessageDao.deleteStudentMessageById(id);
	}
	
	/**
	 * 将数据库中Classes数据全部查出
	 */
	public List<Classes> findAllClasses(){
		return classesDao.findAllClasses();
	}
	
	/**
	 * 根据学生id查询对应学生的留言记录
	 * @param studentid 学生id
	 * @param limit  展示数据每页的大小
	 */
	public List<StudentMessage> listMessageByStudentId(int studentid,int limit){
		return studentMessageDao.findStudentMessageByStudentId(studentid, limit);
	}
	
	
}

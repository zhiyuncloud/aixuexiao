package com.aixuexiao.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aixuexiao.dao.ClassesDao;
import com.aixuexiao.dao.ClassesNewsDao;
import com.aixuexiao.dao.StudentDao;
import com.aixuexiao.model.Classes;
import com.aixuexiao.model.ClassesNews;
import com.aixuexiao.model.Student;

@Service("classesService")
public class ClassesService {

	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Resource(name="classesDao")
	private ClassesDao classesDao;
	
	@Resource(name="classesNewsDao")
	private ClassesNewsDao classesNewsDao;
	
	/**
	 * 将数据库中Classes数据分页查出
	 * @param start 其实数据条数
	 * @param size  展示数据每页的大小
	 */
	public List<Classes> listClasses(int start,int size,Classes classes){
		return classesDao.findClasses(start, size,classes);
	}
	 
	public void deleteClassesNewsById(int id){
		classesNewsDao.deleteClassesNewsById(id);
	}
	
	/**
	 * 添加班级动态到数据库
	 * @param classesNews
	 */
	public void addClassesNews(ClassesNews classesNews){
		classesNewsDao.addClassesNews(classesNews);
	}
	
	/**
	 * 获取指定班级的班级动态(钱1000个)
	 * @param classid 班级id
	 * @return
	 */
	public List<ClassesNews> findClassesNewsByClassId(int classid){
		return classesNewsDao.findClassesNewsByClassId(classid, 1000);
	}
	
	/**
	 * 添加班级到数据库中
	 * @param classes 班级对象
	 */
	public void addClasses(Classes classes){
		classesDao.addClasses(classes);
	}
	
	/**
	 * 根据id查找对应的Classes对象
	 * @param id 班级编号
	 * @return
	 */
	public Classes findClassesById(int id){
		return classesDao.findClassesById(id);
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
	 * 根据班级id查找对应班级所有学生
	 * @param classesid 班级id
	 * @return
	 */
	public List<Student> findStudentByClassesId(int classesid){
		return studentDao.findStudentByClassesId(classesid);
	}
	
	/**
	 * 添加学生信息至数据库中
	 * @param student 学生对象
	 */
	public void addStudent(Student student){
		studentDao.addStudent(student);
	}
	
	
	/**
	 * 删除数据库中对应id的学生信息
	 * @param student 学生对象
	 */
	public void deleteStudentById(int studentid){
		studentDao.deleteStudentById(studentid);
	}
	
	/**
	 * 自动更新指定班级的学生数量
	 * @param classid 班级id
	 */
	public void updateClassStudentCount(int classid){
		classesDao.updateClassStudentCount(classid);
	}
	
	public void updateStudentBy(Student student) {
		studentDao.updateStudent(student);
	}
	
}

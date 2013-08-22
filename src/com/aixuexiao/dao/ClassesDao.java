package com.aixuexiao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aixuexiao.model.Classes;

@Component("classesDao")
public class ClassesDao extends BaseDao {

	
	public List<Classes> findAllClasses() {
		return this.readSqlSession.selectList("com.aixuexiao.dao.ClassesDao.selectAllClasses");
	}
	
	public List<Classes> findClasses(int start,int size,Classes classes) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("size", size);
		map.put("classes", classes);
		return this.readSqlSession.selectList("com.aixuexiao.dao.ClassesDao.selectClasses",map);
	}
	
	public void addClasses(Classes classes){
		writerSqlSession.insert("com.aixuexiao.dao.ClassesDao.addClasses", classes);
	}
	
	public Classes findClassesById(int id){
		return readSqlSession.selectOne("com.aixuexiao.dao.ClassesDao.selectClassesById", id);
	}
	
	public void updateClassStudentCount(int classid){
		writerSqlSession.update("com.aixuexiao.dao.ClassesDao.updateClassStudentCount", classid);
	}
}

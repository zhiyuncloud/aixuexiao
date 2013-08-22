package com.aixuexiao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.aixuexiao.model.Message;
import com.aixuexiao.model.StudentMessage;

@Component("studentMessageDao")
public class StudentMessageDao extends BaseDao {


	public List<StudentMessage> findStudentMessageByStudentId(int studentid,int limit) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("studentid", studentid);
		map.put("limit", limit);
		return this.readSqlSession.selectList("com.aixuexiao.dao.StudentMessageDao.selectStudentMessageByStudentId",map);
	}
	
	public int addStudentMessage(StudentMessage studentMessage) {
		return this.writerSqlSession.insert("com.aixuexiao.dao.StudentMessageDao.addStudentMessage", studentMessage);
	}
	
	public int deleteStudentMessageById(int id) {
		return this.writerSqlSession.delete("com.aixuexiao.dao.StudentMessageDao.deleteStudentMessageById", id);
	}
	
}

package com.aixuexiao.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {

	@Resource(name="readSqlSession")
	public SqlSessionTemplate readSqlSession;
	
	@Resource(name="writerSqlSession")
	public SqlSessionTemplate writerSqlSession;
	
}

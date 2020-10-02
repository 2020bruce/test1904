package com.zk.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	private static SqlSessionFactory factory = null;
	private static SqlSession sqlSession = null;
	static {
		String config = "mybatis.xml";
		try {
			InputStream in = Resources.getResourceAsStream(config);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private SqlSessionUtil() {}
	
	public static SqlSession getSqlSession() {
		
		if(sqlSession == null) {
			sqlSession = factory.openSession();
		}
		return sqlSession;
	}
}

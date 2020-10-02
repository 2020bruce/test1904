package com.zk.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

public class TransactionInvocationHandler implements InvocationHandler{
	private Object target;
	public TransactionInvocationHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		SqlSession sqlSession = null;
		Object object = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			object = method.invoke(target, args);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}

		}
		
		
		return object;
	}
	
	public Object getTransactionInvocationHandlerObject() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				this);
	}

}

package com.zk.utils;

public class ServiceFactory {
	public static Object getProxy(Object service) {
		return new TransactionInvocationHandler(service).getTransactionInvocationHandlerObject();
	}
}

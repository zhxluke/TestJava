package com.lcb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HttpClientHandler implements InvocationHandler {
	private HttpClient httpClient;

	public Client getInstance(HttpClient httpClient) {
		// 绑定委托对象
		this.httpClient = httpClient;

		// 返回代理类
		return (Client) Proxy.newProxyInstance(httpClient.getClass()
				.getClassLoader(), httpClient.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (method.getName().equals("sendData")) {
			System.out.println("发送数据...");
			method.invoke(httpClient, args);
		} else if (method.getName().equals("receiveDate")) {
			System.out.println("接收数据...");
			method.invoke(httpClient, args);
		}
		return null;
	}

}

package com.lcb.proxy;

public class HttpClient implements Client{

	@Override
	public void sendData(String data) {
		System.out.println("数据已发送...");
	}

	@Override
	public void receiveDate(String data) {
		System.out.println("数据接收完成...");
	}

}

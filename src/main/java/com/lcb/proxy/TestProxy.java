package com.lcb.proxy;

public class TestProxy {
	public static void main(String[] args) {
		HttpClientProxy proxy1 = new HttpClientProxy(new HttpClient());
		proxy1.sendData("");
		proxy1.receiveDate("");
		
		System.out.println("-------------------");
		
		Client proxy = new HttpClientHandler().getInstance(new HttpClient());
		proxy.sendData("");
		proxy.receiveDate("");
	}
}

package com.lcb.proxy;

public class HttpClientProxy implements Client {
	private HttpClient httpClient;

	public HttpClientProxy(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public void sendData(String data) {
		System.out.println("..发送数据.");
		httpClient.sendData(data);
	}

	@Override
	public void receiveDate(String data) {
		System.out.println("接收数据...");
		httpClient.receiveDate(data);
	}

}

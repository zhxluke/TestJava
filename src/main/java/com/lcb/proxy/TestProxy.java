package com.lcb.proxy;


public class TestProxy {
    public static void main(String[] args) {
        HttpClientProxy proxy1 = new HttpClientProxy(new HttpClient());
        proxy1.sendData("A");
        proxy1.receiveDate("A");

        System.out.println("-------------------");
        Client proxy2 = new HttpClientHandler().getInstance(new HttpClient());
        proxy2.sendData("B");
        proxy2.receiveDate("B");

        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();
    }
}

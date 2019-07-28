package com.lcb.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloService extends Thread {
	private ServerSocket serverSocket;

	public HelloService(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void run() {
		try {
			while (true) {
				System.out.println("Waiting for client on port "
						+ serverSocket.getLocalPort());
				// blocked & waiting for income socket
				Socket client = serverSocket.accept();
				System.out.println("connected to "
						+ client.getRemoteSocketAddress());
				DataInputStream dis = new DataInputStream(
						client.getInputStream());
				byte[] cbuff = new byte[256];
				char[] charBuff = new char[256];
				int size = 0;
				while ((size = dis.read(cbuff)) > 0) {
					StringUtil.convertByteToChar(cbuff, charBuff, size);
					System.out.println(charBuff);
				}
				DataOutputStream dos = new DataOutputStream(
						client.getOutputStream());
				byte[] hello = "Hello, Java Socket".getBytes();
				dos.write(hello, 0, hello.length);
				dis.close();
				dos.close();
				client.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			HelloService service = new HelloService(9999);
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

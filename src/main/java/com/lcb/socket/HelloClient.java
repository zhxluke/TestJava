package com.lcb.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class HelloClient implements Runnable {
	private Socket socket;
	private SocketAddress address;

	public HelloClient(String serverHostName, int port) {
		address = new InetSocketAddress(serverHostName, port);
	}

	public void run() {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				System.out.println("请输入:");
				String str = br.readLine();
				if (socket == null || !socket.getKeepAlive()) {
					socket = new Socket();
					socket.connect(address);
				}
				DataOutputStream dos = new DataOutputStream(
						socket.getOutputStream());
				dos.write(str.getBytes());
				DataInputStream dis = new DataInputStream(
						socket.getInputStream());
				byte[] cbuff = new byte[256];
				char[] charBuff = new char[256];
				int size = 0;
				while ((size = dis.read(cbuff)) > 0) {
					StringUtil.convertByteToChar(cbuff, charBuff, size);
					System.out.println(charBuff);
				}
				System.out.println(dis.available());
				dis.close();
				dos.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		HelloClient client = new HelloClient("localhost", 9999);
		client.run();
	}

}

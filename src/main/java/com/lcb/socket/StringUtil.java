package com.lcb.socket;

public class StringUtil {

	public static void convertByteToChar(byte[] cbuff, char[] charBuff, int size) {
		for (int i = 0; i < charBuff.length; i++) {
			if (i < size) {
				charBuff[i] = (char) cbuff[i];
			} else {
				charBuff[i] = ' ';
			}
		}
	}
}

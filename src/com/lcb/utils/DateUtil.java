package com.lcb.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) {
		Date date = new Date();// 取时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date tomorrow = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		System.out.println(date);
		System.out.println(tomorrow);
	}
}

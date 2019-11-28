package com.lcb.schedule;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduleManager {
	private static int maxSize = 10;
	private static ScheduleManager sm = new ScheduleManager();
	private static ScheduledThreadPoolExecutor se = null;

	private ScheduleManager() {
		se = new ScheduledThreadPoolExecutor(maxSize);
		se.scheduleAtFixedRate(new VisitSchedule(), 0, 1, TimeUnit.SECONDS);
		se.scheduleAtFixedRate(new GsendSchedule(), 0, 5, TimeUnit.SECONDS);
	}

	public static ScheduleManager getScheduleManager() {
		return sm;
	}

}

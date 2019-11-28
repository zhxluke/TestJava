package com.lcb.command;

import java.util.ArrayList;
import java.util.List;

public class Producer {
	public static List<Command> produceRequests() {
		List<Command> queue = new ArrayList<Command>();
		queue.add(new Engineer());
		queue.add(new Politician());
		queue.add(new Programmer());
		return queue;
	}
}

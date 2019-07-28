package com.lcb.observer;

import java.util.Observable;
import java.util.Observer;

public class NameObserver implements Observer {
	private String name = null;

	public void update(Observable observable, Object obj) {
		if (obj instanceof String) {
			name = (String) obj;
			System.out.println("NameObserver :name changet to " + name);
		}
	}

}

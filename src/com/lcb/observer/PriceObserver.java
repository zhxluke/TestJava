package com.lcb.observer;

import java.util.Observable;
import java.util.Observer;

public class PriceObserver implements Observer {
	private float price = 0;

	public void update(Observable observable, Object obj) {
		if (obj instanceof Float) {
			price = ((Float) obj).floatValue();
			System.out.println("PriceObserver :price changet to " + price);
		}

	}

}

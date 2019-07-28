package com.lcb.observer;

import java.util.Observable;

public class Product extends Observable {
	private String name;
	private float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		setChanged();
		notifyObservers(new Float(price));
	}

}

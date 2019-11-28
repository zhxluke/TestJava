package com.lcb.state;

import java.awt.Color;

public class Sample {
	private Color color;

	public Sample(Color color) {
		this.color = color;
	}

	public void operate() {
		System.out.println(color.toString());
	}
}

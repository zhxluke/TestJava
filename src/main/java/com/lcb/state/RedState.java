package com.lcb.state;

import java.awt.Color;

public class RedState extends State {

	@Override
	public void handlePush(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public Color getColor() {
		return Color.red;
	}

}

package com.lcb.state;

import java.awt.Color;

public class GreenState extends State {

	@Override
	public void handlePush(Context c) {
		c.setState(new RedState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public Color getColor() {
		return Color.green;
	}

}

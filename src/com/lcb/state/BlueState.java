package com.lcb.state;

import java.awt.Color;

public class BlueState extends State {

	@Override
	public void handlePush(Context c) {
		c.setState(new GreenState());
	}

	@Override
	public void handlePull(Context c) {
		c.setState(new RedState());
	}

	@Override
	public Color getColor() {
		return Color.blue;
	}

}

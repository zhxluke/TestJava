package com.lcb.state;

public class TestState {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context c = new Context();
		c.setState(new BlueState());
		for (int i = 0; i < 10; i++) {
			c.pull();
		}
	}
}

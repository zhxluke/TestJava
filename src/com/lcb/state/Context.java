package com.lcb.state;

public class Context {
	private State state = null;

	public void setState(State state) {
		this.state = state;
	}

	public void push() {
		state.handlePush(this);
		Sample sample = new Sample(state.getColor());
		sample.operate();
	}

	public void pull() {
		state.handlePull(this);
		Sample sample = new Sample(state.getColor());
		sample.operate();
	}
}

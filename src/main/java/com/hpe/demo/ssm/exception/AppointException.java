package com.hpe.demo.ssm.exception;

import com.hpe.demo.ssm.enums.AppointStateEnum;

public class AppointException extends Exception {

	private static final long serialVersionUID = 1L;
	private AppointStateEnum state;

	public AppointException(AppointStateEnum state) {
		super(state.getStateInfo());
		this.state = state;
	}

	public AppointStateEnum getState() {
		return state;
	}

	public void setState(AppointStateEnum state) {
		this.state = state;
	}

}

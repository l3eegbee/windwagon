package com.windwagon.pmuportal.exceptions;

public class PMUError extends Exception {

	private static final long serialVersionUID = 1L;

	public PMUError() {
		super();
	}

	public PMUError(String message) {
		super(message);
	}

	public PMUError(String message, Throwable cause) {
		super(message, cause);
	}

	public PMUError(Throwable cause) {
		super(cause);
	}

}

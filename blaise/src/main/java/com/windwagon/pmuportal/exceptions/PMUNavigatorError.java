package com.windwagon.pmuportal.exceptions;

public class PMUNavigatorError extends PMUError {

	private static final long serialVersionUID = 1L;

	public PMUNavigatorError() {
		super();
	}

	public PMUNavigatorError(String message) {
		super(message);
	}

	public PMUNavigatorError(String message, Throwable cause) {
		super(message, cause);
	}

	public PMUNavigatorError(Throwable cause) {
		super(cause);
	}

}

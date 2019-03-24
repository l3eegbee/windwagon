package com.windwagon.pmuportal.exceptions;

public class PMUParserError extends PMUError {

	private static final long serialVersionUID = 1L;

	public PMUParserError() {
		super();
	}

	public PMUParserError(String message) {
		super(message);
	}

	public PMUParserError(String message, Throwable cause) {
		super(message, cause);
	}

	public PMUParserError(Throwable cause) {
		super(cause);
	}

}

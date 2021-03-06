package com.educandoweb.course.web.errors;

public class BadRequestAlertException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String entityName;

	private final String errorKey;

	public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
		super(defaultMessage);
		this.entityName = entityName;
		this.errorKey = errorKey;
	}

	public BadRequestAlertException(String message, Throwable cause) {
		super(message, cause);
		this.entityName = "";
		this.errorKey = "";
	}

	public String getEntityName() {
		return entityName;
	}

	public String getErrorKey() {
		return errorKey;
	}
}

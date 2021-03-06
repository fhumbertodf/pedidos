package com.educandoweb.course.web.errors;

public class ObjectNotFoundAlertException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final String entityName;

	private final String errorKey;

	public ObjectNotFoundAlertException(String defaultMessage, String entityName, String errorKey) {
		super(defaultMessage);
		this.entityName = entityName;
		this.errorKey = errorKey;
	}

	public ObjectNotFoundAlertException(String msg, Throwable cause) {
		super(msg, cause);
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
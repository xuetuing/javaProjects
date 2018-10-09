package com.xms.exception;

public class PasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public PasswordException(){}
	public PasswordException(String message){
		super(message);
	}
}

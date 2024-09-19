package com.project.myexceptions;

public class OrderNotFoundException extends Exception {
	public OrderNotFoundException(String message) {
		super(message);
	}
}

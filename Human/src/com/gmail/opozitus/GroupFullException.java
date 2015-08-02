package com.gmail.opozitus;

public class GroupFullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "В групі 10 осіб. Свторіть нову групу";
	}

}

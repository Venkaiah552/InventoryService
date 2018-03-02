package com.honeywell.util;

public enum Size {
	EXTRASMALL("XS"), SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRALARGE("XL"), DOUBLEEXTRALARGE("XXL");
	private String value;

	Size(String value) {
		this.value = value;
	}

}

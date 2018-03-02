package com.honeywell.util;

public enum Size {
	EXTRASMALL("XS"), SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRALARGE("XL"), DOUBLEEXTRALARGE("XXL");
	private String value;

	Size(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Size parse(String value) {
		Size right = null; // Default
		for (Size item : Size.values()) {
			if (item.getValue() == value) {
				right = item;
				break;
			}
		}
		return right;
	}
}

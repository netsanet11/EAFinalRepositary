package edu.mum.domain;

public enum OrderStatus {

	UNDELIV("Undelivered"), PREP("On Preparation"), INTR("In Transit"), DELIV("Delivered");

	String name;

	public String longName() {
		return this.name;
	}

	OrderStatus(String abv) {
		this.name = abv;
	}
}

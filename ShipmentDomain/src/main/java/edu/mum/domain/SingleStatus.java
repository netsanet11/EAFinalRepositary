package edu.mum.domain;

public enum SingleStatus {
	UNDELIVEDED("Undelivered"), PREPARING("Preparing"), INTRANSIT("Intransit"), DELIVERED("Delivered");
	
	private String str;
	SingleStatus(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}
}

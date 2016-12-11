package com.java.inheritance01.base;

public class BaseClass01 {

	private String privateString = "private String from BaseClass01";
	String packagePrivateString = "package private String from BaseClass01";
	protected String protectedString = "protected String from BaseClass01";
	public String publicString = "public String from BaseClass01";

	@SuppressWarnings(value = { "unused" })
	private void printPrivateString() {
		System.out.println("\t" + privateString);
	}

	void printPackagePrivateString() {
		System.out.println("\t" + packagePrivateString);
	}

	protected void printProtectedString() {
		System.out.println("\t" + protectedString);
	}

	public void printPublicString() {
		System.out.println("\t" + publicString);
	}
}

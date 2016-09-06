package com.java.bases;

public class HelloWorldWithParams { 
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		if (args != null && args.length != 0) {
			System.out.println(args[0]);
		}
	}
}

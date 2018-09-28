package com.hemant.reflection;

public class ReflectionExample {

	private String s;

	public ReflectionExample() {
		s = "HEMANT_KUMAR";
	}

	public void method1() {
		System.out.println("The string is" + s);
	}

	public void method2(int n) {
		System.out.println("The number is " + n);
	}

	@SuppressWarnings("unused")
	private void method3() {
		System.out.println("Private method is invoked");
	}

}

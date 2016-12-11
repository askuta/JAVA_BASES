package com.java.inheritance01.base;

public class MainInBasePackage {

	public static void main(String[] args) {
		// Create an object of the class BaseClass01 and print everything
		BaseClass01 baseObject = new BaseClass01();

		System.out.println("Print/access fields of an object of the BaseClass01 class from the package of BaseClass01:");
		// System.out.println("\t" + baseObject.privateString); // Cannot access private field from outside of the class BaseClass01
		System.out.println("\t" + baseObject.packagePrivateString); // Can access package private field from the package of the class BaseClass01
		System.out.println("\t" + baseObject.protectedString); // Can access protected field from the package of the class BaseClass01 and from derived classes
		System.out.println("\t" + baseObject.publicString); // Can access public field from everywhere

		System.out.println();
		System.out.println("Access methods of an object of the BaseClass01 class from the package of BaseClass01:");
		// baseObject.printPrivateString(); // Cannot access private method from outside of the class BaseClass01
		baseObject.printPackagePrivateString(); // Can access package private method from the package of the class BaseClass01
		baseObject.printProtectedString(); // Can access protected method from the package of the class BaseClass01 and from derived classes
		baseObject.printPublicString(); // Can access public method from everywhere
	}
}

package com.java.inheritance01;

import com.java.inheritance01.derived.DerivedClass01;

public class C01_Inheritance {

	public static void main(String[] args) {
		createDerivedObjectAndPrintEverything();
	}

	private static void createDerivedObjectAndPrintEverything() {
		DerivedClass01 derivedObject = new DerivedClass01();

		derivedObject.accessBaseFieldsInDerivedClass();
		System.out.println();
		derivedObject.accessBaseMethodsInDerivedClass();

		System.out.println();
		System.out.println("Print/access fields of an object of the class DerivedClass01 from a general package:");
		// System.out.println("\t" + derivedObject.privateString); // Cannot access private field from outside of the class BaseClass01
		// System.out.println("\t" + derivedObject.packagePrivateString); // Cannot access package private field from outside of the package of the base class
		// System.out.println("\t" + derivedObject.protectedString); // Cannot access protected field from outside of the package of the base class except from derived class
		System.out.println("\t" + derivedObject.publicString); // Can access public field from everywhere

		System.out.println();
		System.out.println("Access methods of an object of the class DerivedClass01 from a general package:");
		// derivedObject.printPrivateString(); // Cannot access private method from outside of the class BaseClass01
		// derivedObject.printPackagePrivateString(); // Cannot access package private method from outside of the package of the base class
		// derivedObject.printProtectedString(); // Cannot access protected method from outside of the package of the base class except from derived class
		derivedObject.printPublicString(); // Can access public method from everywhere
	}
}

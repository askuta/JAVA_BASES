package com.java.inheritance01.derived;

import com.java.inheritance01.base.BaseClass01;

public class DerivedClass01 extends BaseClass01 {

	public DerivedClass01() {
		super();
	}

	public void accessBaseFieldsInDerivedClass() {
		System.out.println("Print/access base class fields from derived class:");
		// System.out.println("\t" + super.privateString); // Cannot access private field from outside of the base class
		// System.out.println("\t" + super.packagePrivateString); // Cannot access package private field from outside of the package of the base class
		System.out.println("\t" + super.protectedString); // Can access protected field from derived class
		System.out.println("\t" + super.publicString); // Can access public field from everywhere
	}

	public void accessBaseMethodsInDerivedClass() {
		System.out.println("Access base class methods from derived class:");
		// super.printPrivateString(); // Cannot access private method from outside of the base class
		// super.printPackagePrivateString(); // Cannot access package private method from outside of the package of the base class
		super.printProtectedString(); // Can access protected method from the derived class
		super.printPublicString(); // Can access public method from everywhere
	}
}

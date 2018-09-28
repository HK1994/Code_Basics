package com.hemant.reflection;

/*
 * Advantages of Reflection
 * Extensibility Features: An application may make use of external, user-defined
 * classes by creating instances of extensibility objects using their
 * fully-qualified names. Debugging and testing tools: Debuggers use the
 * property of reflection to examine private members on classes.
 */

/*Drawbacks:

Performance Overhead: Reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.
Exposure of Internals: Reflective code breaks abstractions and therefore may change behavior with upgrades of the platform.*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		ReflectionExample obj = new ReflectionExample();

		Class<? extends ReflectionExample> cls = obj.getClass();
		System.out.println("The name of the class is " + cls.getName());

		Constructor<? extends ReflectionExample> c = cls.getConstructor();
		System.out.println("The name of the constructor is " + c.getName());

		System.out.println("The public method are:");

		Method[] methods = cls.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}

		Method methodcall1 = cls.getDeclaredMethod("method2", int.class); // create an object of method to be invoked
		methodcall1.invoke(obj, 10); // invoke a method of the class at runtime

		Field field = cls.getDeclaredField("s"); // Used to get the private field. Returns an object of type Field for
													// specified field name.
		field.setAccessible(true); // Allows to access the field irrespective of the access modifier used with the
									// field
		field.set(obj, " JAVA");
		Method methodcall2 = cls.getDeclaredMethod("method1");
		methodcall2.invoke(obj);

		Method methodcall3 = cls.getDeclaredMethod("method3"); // Through reflection we can access the private variables
																// and methods of a class with the help of its class
																// object and invoke the method by using the object
		methodcall3.setAccessible(true);
		methodcall3.invoke(obj);
	}

}

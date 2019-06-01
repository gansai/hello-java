package com.javaexamples.string;

public class CompareStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello World";
		//String somestr = "hello world";
		String somestr = "Dearth";
		
		Object obj = somestr;
		
		System.out.println(str.compareTo(somestr));
		System.out.println(str.compareToIgnoreCase(somestr));
		System.out.println(str.compareTo(obj.toString()));
		
		//Output
		//4 -- ascii diff of first odd character.
		//4
		//4

	}

}

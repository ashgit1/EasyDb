package com.ashish.easydb.utils;

public class Test {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		int index = url.lastIndexOf("/");
		int length = url.length();
		
		System.out.println("len: " + length + ", last index: " + index);
		
		System.out.println(url.substring(index + 1 , length));
		
	}

}

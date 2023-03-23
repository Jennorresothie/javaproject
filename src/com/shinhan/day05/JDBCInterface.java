package com.shinhan.day05;

public interface JDBCInterface {
	public static final String JDBC="JAVA Database Connetion";
	
	String JDBC2="JAVA Database Connetion";
	
	public abstract void dbConnect(String dbName);
	void dbConnect2(String dbName);
}

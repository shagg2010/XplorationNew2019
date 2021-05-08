package com.saurabh.dada.iq.impl;

public class JDBC_DifferenceExecute_ExecuteUpdate {

	/**
	 * Use of different execute() methods in JDBC:-
		boolean execute(String SQL) :-  It returns a boolean value true if a ResultSet object can be retrieved; otherwise, it returns false. 
			We can use this method to execute SQL DDL statements.

		int executeUpdate(String SQL) : - It returns the no of rows updated in db during the execution of the SQL statement. 
			We can use this method to execute SQL queries like, an INSERT, UPDATE, or DELETE Statement.

		ResultSet executeQuery(String SQL) :- It returns a ResultSet object. We can use this method when we want to execute SELECT queries in db.

		int[] executeBatch() :- JDBC allows a program to perform mutiple insertion or updation of data into database at single step. 
			executeBatch() is responsible to execute batch on statement object.

	 * 
	 */
	public static void main(String[] args) {
		
	}

}

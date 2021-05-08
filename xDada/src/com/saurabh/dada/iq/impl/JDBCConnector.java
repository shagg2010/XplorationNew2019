package com.saurabh.dada.iq.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnector {
	
	private static Connection oracle_conn = null;
	
	public static void main(String[] args) {
		if(args!=null && args.length ==5)
			verifyConnection(args);
		else{
			System.out.println("Usage: java -jar jdbccon.jar <hostname> <port> <databaseName>  <username> <password>");
		}
	}
	
	public static Connection getConnection(String hostname,String port,String databaseName, String username,String password){
		try{
			if(oracle_conn==null || oracle_conn.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Connection URL: " + "jdbc:oracle:thin:@" + hostname + ":" + port +":" + databaseName + "[" + username + "/" + password + "]");
				oracle_conn = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname + ":" + port +":" + databaseName,username,password);
				return oracle_conn;
			}
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.exit(0);
		}
		return null;		
	}
	
	public static void verifyConnection(String[] args){
		
		try{
			oracle_conn = getConnection(args[0], args[1], args[2] , args[3], args[4]);
			Statement statement = oracle_conn.createStatement();
			ResultSet rs = statement.executeQuery("select 1 from dual");
			while (rs.next()) {
				if(rs.getInt(1)==1){
					System.out.println("Connection Successful!");
				}
			}
			oracle_conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}

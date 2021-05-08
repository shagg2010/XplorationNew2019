package com.saurabh.dada.iq.impl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBConnectionProviderFactory {

	private volatile static DBConnectionProviderFactory factory = null;
	private Connection conn = null;
	public enum DBType { ORACLE, DB2, MYSQL};
	
	private DBConnectionProviderFactory(){
		//because it is a singleton class
	}
	
	public static void closeConnection() {
		if(factory!=null){
			if(factory.conn!=null){
				try{
					factory.conn.close();
					System.out.println("\nInfo: DB connection " + factory.conn.hashCode() +" closed gracefully!");
					factory.conn = null;
				}
				catch(SQLException e){
					e.printStackTrace();
					System.out.println("Info: Retrying to close the connection!");
					if(factory.conn!=null){
						try{
							factory.conn.close();
							factory.conn = null;
						}
						catch(SQLException e1){
							e.printStackTrace();		
						}
					}
				}
			}
		}
	}
	
	public static void closeSQLObjects(ResultSet rs, Statement statement, PreparedStatement pStatement){
		try{
			if(rs!=null){
				rs.close();
			}
			if(statement!=null){
				statement.close();
			}
			if(pStatement!=null){
				pStatement.close();
			}
		}
		catch(SQLException e){
			System.out.println("\n\nError: Error while closing ResultSet/Statement connection!");
		}
	}

	public static Connection getConnection(DBType type) {
		if(factory==null){
			synchronized(DBConnectionProviderFactory.class){
				if(factory==null){
					factory = new DBConnectionProviderFactory();
					try{
						if(factory.conn==null){
							Properties props = getDatabaseProperties(type);
							Class.forName((String)props.get("db.driver.class"));
							if(type==DBType.ORACLE){
								System.out.println("Info: Connection URL: " + "jdbc:oracle:thin:@"+ props.get("db.hostname") + ":" + props.get("db.port") + ":" + props.get("db.sid") + "[" + props.get("db.user") + "/" + props.get("db.password") + "]");
								factory.conn = DriverManager.getConnection("jdbc:oracle:thin:@" + props.get("db.hostname") + ":" + props.get("db.port") + ":" + props.get("db.sid"), (String)props.get("db.user"), (String)props.get("db.password"));
							}
							if(type==DBType.DB2){
								System.out.println("DB2 currently not supported!");
							}
							if(type==DBType.MYSQL){
								System.out.println("MySQL currently not supported!");
							}
						}
						System.out.println("\nInfo: Connection hashcode: " + factory.conn.hashCode());
						return factory.conn;
					}
					catch(ClassNotFoundException e){
						e.printStackTrace();
						System.exit(0);
					}
					catch(SQLException e){
						e.printStackTrace();
						System.exit(0);
					}
				}
			}
		}
		else{
			try{
				if(factory.conn==null){
					Properties props = getDatabaseProperties(type);
					Class.forName((String)props.get("db.driver.class"));
					if(type==DBType.ORACLE){
						System.out.println("Info: Connection URL: " + "jdbc:oracle:thin:@"+ props.get("db.hostname") + ":" + props.get("db.port") + ":" + props.get("db.sid") + "[" + props.get("db.user") + "/" + props.get("db.password") + "]");
						factory.conn = DriverManager.getConnection("jdbc:oracle:thin:@" + props.get("db.hostname") + ":" + props.get("db.port") + ":" + props.get("db.sid"), (String)props.get("db.user"), (String)props.get("db.password"));
					}
					if(type==DBType.DB2){
						System.out.println("DB2 currently not supported!");
					}
					if(type==DBType.MYSQL){
						System.out.println("MySQL currently not supported!");
					}
				}
				System.out.println("\nInfo: Connection hashcode: " + factory.conn.getClass().hashCode());
				return factory.conn;
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
				System.exit(0);
			}
			catch(SQLException e){
				e.printStackTrace();
				System.exit(0);
			}
		}
		return null;
	}
	
	private static Properties getDatabaseProperties(DBType type) {
		String path = null;
		if(type==DBType.ORACLE)
			path = "/oracle-database.properties";
		if(type==DBType.DB2)
			path = "/db2-database.properties";
		if(type==DBType.MYSQL)
			path = "/mysql-database.properties";
		InputStream in = DBConnectionProviderFactory.class.getResourceAsStream(path);
		if (in != null) {
			try {
				try {
					Properties props = new Properties();
					props.load(in);
					return props;
				} finally {
					in.close();
				}
			} catch (IOException e) {
				throw new InternalError(e.getMessage());
			}
		} else {
			throw new InternalError("Resource: " + path + " not found or data provided is incorrect!");
		}
	}

}

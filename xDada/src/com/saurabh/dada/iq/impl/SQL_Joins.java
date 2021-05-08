package com.saurabh.dada.iq.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

import com.saurabh.dada.iq.impl.utils.DBConnectionProviderFactory.DBType;
import com.saurabh.dada.iq.impl.utils.DBConnectionProviderFactory;

/**
 * 		This example uses CustomSupplier_DBScripts_Oracle.sql for creating DB tables.
 * 		Refer to images folder to understand SQL joins
 * 		and the following web-site for more details
 * 		http://www.techonthenet.com/oracle/joins.php
 * 
 */

	//Outer keyword in join SQL is optional in LEFT, RIGHT, FULL

	//INNER JOIN - select supp.supplier_id, supp.supplier_name, odrs.order_date from suppliers supp INNER JOIN orders odrs ON supp.supplier_id=odrs.supplier_id where supp.supplier_id=?

public class SQL_Joins {

	public static void main(String[] args) {
		try{
			Connection conn = DBConnectionProviderFactory.getConnection(DBType.ORACLE);
			exampleSelfJoin_Right(conn);
			exampleInnerJoin(conn);
			exampleLeftOuterJoin(conn);
			exampleRightOuterJoin(conn);
			exampleFullOuterJoin(conn);
			DBConnectionProviderFactory.closeConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void exampleSelfJoin_Right(Connection conn){
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			if(conn!=null){
				System.out.println("\t\t\t\t\t------- SELF JOIN (LEFT OUTER JOIN) -----");
				StringBuffer query = new StringBuffer("select e1.employee_id as EmpId, e1.last_name as Emp, e2.last_name as ManagerName, e2.employee_id as ManagerId from emp_mgrs e1 LEFT OUTER JOIN emp_mgrs e2 ON e1.manager_id=e2.employee_id");
				//query.append(" where supp.supplier_id=?");
				query.append(" order by e1.employee_id");
				System.out.println("\nSQL: "+query.toString());
				pStatement = conn.prepareStatement(query.toString());
				//pStatement.setString(1, "1");
				rs = pStatement.executeQuery();
				displaySQLResultSet(rs);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBConnectionProviderFactory.closeSQLObjects(rs, null, pStatement);
		}
	}
	
	public static void exampleFullOuterJoin(Connection conn){
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			if(conn!=null){
				System.out.println("\t\t\t\t\t------- FULL (OUTER) JOIN -----");
				StringBuffer query = new StringBuffer("select supp.supplier_id, supp.supplier_name, odrs.order_id ,odrs.order_date from suppliers supp FULL OUTER JOIN orders odrs ON supp.supplier_id=odrs.supplier_id");
				//query.append(" where supp.supplier_id=?");
				query.append(" order by supp.supplier_id");
				System.out.println("\nSQL: "+query.toString());
				pStatement = conn.prepareStatement(query.toString());
				//pStatement.setString(1, "1");
				rs = pStatement.executeQuery();
				displaySQLResultSet(rs);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBConnectionProviderFactory.closeSQLObjects(rs, null, pStatement);
		}	
	}
	
	public static void exampleRightOuterJoin(Connection conn){
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			if(conn!=null){
				System.out.println("\t\t\t\t\t------- RIGHT OUTER JOIN -----");
				StringBuffer query = new StringBuffer("select supp.supplier_id, supp.supplier_name, odrs.order_id ,odrs.order_date from suppliers supp RIGHT OUTER JOIN orders odrs ON supp.supplier_id=odrs.supplier_id");
				//query.append(" where supp.supplier_id=?");
				query.append(" order by supp.supplier_id");
				System.out.println("\nSQL: "+query.toString());
				pStatement = conn.prepareStatement(query.toString());
				//pStatement.setString(1, "1");
				rs = pStatement.executeQuery();
				displaySQLResultSet(rs);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBConnectionProviderFactory.closeSQLObjects(rs, null, pStatement);
		}	
	}
	
	public static void exampleLeftOuterJoin(Connection conn){
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			if(conn!=null){
				System.out.println("\t\t\t\t\t------- LEFT OUTER JOIN -----");
				StringBuffer query = new StringBuffer("select supp.supplier_id, supp.supplier_name, odrs.order_id ,odrs.order_date from suppliers supp LEFT OUTER JOIN orders odrs ON supp.supplier_id=odrs.supplier_id");
				//query.append(" where supp.supplier_id=?");
				query.append(" order by supp.supplier_id");
				System.out.println("\nSQL: "+query.toString());
				pStatement = conn.prepareStatement(query.toString());
				//pStatement.setString(1, "1");
				rs = pStatement.executeQuery();
				displaySQLResultSet(rs);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBConnectionProviderFactory.closeSQLObjects(rs, null, pStatement);
		}	
	}
	
	public static void exampleInnerJoin(Connection conn){
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		try{
			if(conn!=null){
				System.out.println("\t\t\t\t\t------- INNER JOIN -----");
				StringBuffer query = new StringBuffer("select supp.supplier_id, supp.supplier_name, odrs.order_date from suppliers supp INNER JOIN orders odrs ON supp.supplier_id=odrs.supplier_id");
				query.append(" where supp.supplier_id=?");
				query.append(" order by supp.supplier_id");
				System.out.println("\nSQL: "+query.toString());
				//rs = statement.executeQuery(query.toString());
				pStatement = conn.prepareStatement(query.toString());
				pStatement.setString(1, "1");			
				rs = pStatement.executeQuery();
				displaySQLResultSet(rs);
			}	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBConnectionProviderFactory.closeSQLObjects(rs, null, pStatement);
		}
	}
	
	public static final void displaySQLResultSet(ResultSet rs){
		try{
			ResultSetMetaData rsmd = rs.getMetaData();
			int rows = 0;			
			System.out.println();
			//System.out.println("Total Columns returned: " + rsmd.getColumnCount());
			for(int i=1;i<=rsmd.getColumnCount();i++){
				System.out.print(rsmd.getColumnName(i).toUpperCase()+"\t\t\t");
			}
			System.out.println();
			
			while (rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++){
					int type = rsmd.getColumnType(i);
					if (type == Types.VARCHAR || type == Types.CHAR) {
						System.out.print(rs.getString(i));	
						if(rs.getString(i)!=null && !rs.getString(i).isEmpty() && (rs.getString(i).length() < rsmd.getColumnName(i).length()-5)){
							System.out.print("\t\t\t\t");
						}
						else if(rs.getString(i)==null){
							System.out.print("\t\t\t\t");
						}
						else{
							System.out.print("\t\t\t");
						}
					}
					if (type == Types.INTEGER || type == Types.NUMERIC) {						
						System.out.print(rs.getLong(i));
						if(String.valueOf(rs.getLong(i)) != null)
							System.out.print("\t\t\t\t");
						else{
							System.out.print("\t\t\t");
						}
					}
					if (type == Types.DATE || type == Types.TIMESTAMP) {						
						System.out.print(rs.getTimestamp(i)+"\t\t\t");
					}
				}
				System.out.println();
				rows++;
			}
			System.out.println("Info: Total " + rsmd.getColumnCount() + " columns and " + rows + " records returned.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

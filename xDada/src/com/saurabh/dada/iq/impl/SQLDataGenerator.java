package com.saurabh.dada.iq.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;


/**
 * 
 * @author yadas
 *
 * Enable logging as well by providing the following vm arguments
 * 
 * -Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog -Dorg.apache.commons.logging.SimpleLog.log.com.pega.saurabh.sqldata=trace
 *
 */

public class SQLDataGenerator {
	
	//private static final String PROPS_FILE="tables.properties";
	private static final String SQL_FILE_NAME="input_data_table_data.sql"; 
	private static final String TABLE_NAME="data_table";
	private static final String SEQUENCE_NAME="dt_sequence";
	//private static final String DB_TYPE="db-type";
	public static enum DBType { ORACLE, DB2, MYSQL};
	private static int BUFFER_SIZE=32*1024; 
	//private static long NO_OF_RECORDS=100000;
	//private static final Log log = LogFactory.getLog(SQLDataGenerator.class);
	
	public static void main(String[] args) throws Exception {

		SQLDataGenerator.generateSQLFile(SQL_FILE_NAME, TABLE_NAME ,100000,true, DBType.ORACLE, 100, 100);

	}
	

	
	
	
	public static long generateSQLFile(final String fileName, final String tableName, final int noOfRecords, boolean createTable, final DBType dbType, int maxLimitX, int maxLimitY) throws Exception {

		long time1 = System.currentTimeMillis();
		//changes
		HashMap<String, String> distributionMap = new HashMap<String, String>();
		//
	        
	    FileOutputStream fos = new FileOutputStream(new File(fileName));
	    FileChannel fileChannel = fos.getChannel();
	    try{
	        	
	    	ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
		    String txtToWrite = null;
		    Random random = new Random();
		    
		    if(dbType==DBType.ORACLE){
		    	txtToWrite = "/* SQL Script for Oracle*/\n";
		    }else if(dbType==DBType.DB2){
		    	txtToWrite = "/* SQL Script for DB2*/\n";		    	
	    	}else{
	    		txtToWrite = "/* SQL Script for *****/\n";
	    		System.out.println("Invalid DB type");
	    		System.exit(0);
	    	}	
		    byteBuffer = ByteBuffer.wrap(txtToWrite.getBytes(Charset.forName("UTF-8")));
		    fileChannel.write(byteBuffer);
		        
		    txtToWrite = "create sequence " + SEQUENCE_NAME + " start with 1 increment by 1 cache 1000;\n";
		    byteBuffer = ByteBuffer.wrap(txtToWrite.getBytes(Charset.forName("UTF-8")));
		    fileChannel.write(byteBuffer);
		        
		    if(createTable==true){
		    	if(dbType==DBType.ORACLE){
		    		txtToWrite = "create table " + tableName + " (id varchar2(20) primary key,x number(20,2),y number(20,2));\n";
		    	}else if(dbType==DBType.DB2){
		    		txtToWrite = "create table " + tableName + " (id varchar(20),x decimal(20,10),y decimal(20,10));\n";
		    	}else{
		    		System.out.println("Invalid DB type");
		    		System.exit(0);
		    	}		    	
			    byteBuffer = ByteBuffer.wrap(txtToWrite.getBytes(Charset.forName("UTF-8")));
			    fileChannel.write(byteBuffer);
		    }
		  //changes
	        int a,b,c,d,e,f,g,h,ii,j;
	        a=b=c=d=e=f=g=h=ii=j=0;	   
		        
		    for(int i=1;i<=noOfRecords;i++){
		    	int x = random.nextInt(maxLimitX);
		        int y = random.nextInt(maxLimitY);
		        //changes
		        int Sum=x+y;
		        if(Sum>= 1 && Sum<45)
		        	distributionMap.put("1-45",new Double((++a*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum>=45 && Sum<65)
		        	distributionMap.put("46-65",new Double((++b*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum>=65 && Sum<80)
		        	distributionMap.put("65-80",new Double((++c*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 80 && Sum <92)
		        	distributionMap.put("80-92",new Double((++d*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 92 && Sum <105)
		        	distributionMap.put("92-105",new Double((++e*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 105 && Sum <118)
		        	distributionMap.put("105-118",new Double((++f*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 118 && Sum <135)
		        	distributionMap.put("118-135",new Double((++g*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 135 && Sum <153)
		        	distributionMap.put("135-153",new Double((++h*1.0d)/noOfRecords*100.0d).toString());
		        else if(Sum >= 153 && Sum <200)
		        	distributionMap.put("153-200",new Double((++ii*1.0d)/noOfRecords*100.0d).toString());
		        else
		        	distributionMap.put("other",new Double((++j*1.0d)/noOfRecords*100.0d).toString());
		        //
		        if(dbType==DBType.ORACLE){
		        	txtToWrite = "insert into " + tableName + " values(TO_CHAR(" + SEQUENCE_NAME + ".nextval)," + x + ","  + y+");\n";
		        }else if(dbType==DBType.DB2){
		        	txtToWrite = "insert into " + tableName + " values(cast((NEXTVAL FOR " + SEQUENCE_NAME + ") as varchar(20))," + x + ","  + y+");\n";
		        }
		        else{
		    		System.out.println("Invalid DB type");
		    		System.exit(0);
		    	}
				byteBuffer = ByteBuffer.wrap(txtToWrite.getBytes(Charset.forName("UTF-8")));
				fileChannel.write(byteBuffer);
				}
		        
		        txtToWrite = "commit;";
		        byteBuffer = ByteBuffer.wrap(txtToWrite.getBytes(Charset.forName("UTF-8")));
		        fileChannel.write(byteBuffer);
		        System.out.println("\nDistribution Map: " + distributionMap);

	        }
	        catch(FileNotFoundException e){
	        	e.printStackTrace();
	        }
	        finally{
	        	if(fos!=null){
	        		fos.close();
	        	}
	        	if(fileChannel!=null){
	        		fileChannel.close();
	        	}
	        }
	        
	        long time2 = System.currentTimeMillis();
	        System.out.println(dbType + " SQL File Ready. [Time taken by NIO: "+(time2-time1)/1000f+" seconds]");
	        return time2-time1;
	    }
	   

	
}

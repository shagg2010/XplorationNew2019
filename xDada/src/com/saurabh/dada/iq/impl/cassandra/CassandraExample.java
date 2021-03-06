package com.saurabh.dada.iq.impl.cassandra;

import java.util.List;
import java.util.UUID;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraExample {
	
	private Cluster cluster;
	private Session session;
	private String msg = "";
	
	private static final String KEYSPACE = "kjavaspace";
	private static final String TABLE = "MOVIES";
	private static final String CREATE_KEYSPACE = "CREATE KEYSPACE " + KEYSPACE + " WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};";
	private static final String USE_KEYSPACE = "USE " + KEYSPACE;
	
	private static final String CREATE_MOVIE_CQL =  "CREATE TABLE " + KEYSPACE + "." +  TABLE + " (title varchar, year int, description varchar, "  
		   + "mmpa_rating varchar, dustin_rating varchar, PRIMARY KEY (title, year))";
	
	private static final String INSERT_MOVIE_CQL = "INSERT INTO " + KEYSPACE + "." +  TABLE + " (title, year, description, mmpa_rating, dustin_rating) VALUES (?, ?, ?, ?, ?)";
	
	private static final String SELECT_MOVIE_CQL = "SELECT * FROM "  + KEYSPACE + "." +  TABLE;
	
	private static final String DELETE_MOVIE_CQL = "DELETE FROM "+ KEYSPACE + "." +  TABLE + " WHERE title = ? and year = ?";
	
	public static void main(final String[] args) {
	  
		CassandraExample client = new CassandraExample();
	    client.connect("127.0.0.1");

	    //client.createSchema(client.session);
	    client.useSchema(client.session);
	    //client.addMovies(client.session);
	    client.deleteMovie(client.session);
	    client.listMovies(client.session);
	    client.close(client.cluster);
	}
	
	public void connect(String node) {
	    cluster = Cluster.builder().addContactPoint(node).build();
	    Metadata metadata = cluster.getMetadata();
	    System.out.println("Cassandra connection established.");
	    msg = "Connected to cluster: " + metadata.getClusterName();
	    System.out.println(msg);
        
	    for (Host host : metadata.getAllHosts()) {
	        System.out.printf("Datatacenter: %s; Host: %s; Rack: %s \n",host.getDatacenter(), host.getAddress(), host.getRack());
	        session = cluster.connect();

	    }
	}

	public void close(Cluster cluster) {
	    cluster.close();
	}
	
	public void createSchema(Session session) {
	    //session.execute(CREATE_KEYSPACE);
	    session.execute(USE_KEYSPACE);
	    //session.execute(CREATE_MOVIE_CQL);
	}
	public void useSchema(Session session) {
	    session.execute(USE_KEYSPACE);
	}
	
	public void deleteMovie(Session session) {
		 session.execute(DELETE_MOVIE_CQL,"Andaaz Apna Apna",1996);
	}
	public void listMovies(Session session) {
		ResultSet results = session.execute(SELECT_MOVIE_CQL);
		List<Row> rowList = results.all();
		int i = 1;
		for(Row row: rowList) {
			System.out.println(i++ + "-" +row);
		}
	}
	
	public void addMovies(Session session) {
		 for(int i=1991;i<2020;i++) {
		    	persistMovie(session, UUID.randomUUID().toString(), i, UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
		    }
	}
	public void persistMovie(Session session, final String title, final int year, final String description,final String mmpaRating, final String dustinRating) {  
			   session.execute("INSERT INTO " +  KEYSPACE + "." + TABLE + " (title, year, description, mmpa_rating, dustin_rating) VALUES (?, ?, ?, ?, ?)",  
			      title, year, description, mmpaRating, dustinRating);  
	} 
}

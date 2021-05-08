package com.saurabh.dada.iq.impl.cassandra;

public class CassandraConnectorLocator {
	
	private static volatile CassandraConnector client = null;
	
	public static CassandraConnector getCassandraConnector() {
		if(client==null) {
			synchronized (CassandraConnectorLocator.class) {
				if(client==null) {
					final CassandraConnector client = new CassandraConnector();
					final String ipAddress = "localhost";
					final int port = 9042;
					System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
					client.connect(ipAddress, port);
				}
			}
		}
		return client;
	}
	
	public static void closeCassandraConnector() {
		if(client!=null) {
			client.closeConnector();
		}
	}

}

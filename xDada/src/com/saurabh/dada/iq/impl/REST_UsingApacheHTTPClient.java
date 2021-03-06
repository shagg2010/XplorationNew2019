package com.saurabh.dada.iq.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class REST_UsingApacheHTTPClient {
	
	public static String URL = "http://dummy.restapiexample.com/api/v1/employees";
	
	public static void main(String[] args) {
		apacheHTTPClient_Get(URL);
		
	}
	
	private static void apacheHTTPClient_Get(String URL) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URL);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void jersey_Get(String URL) {
		try {
			ClientConfig config = new DefaultClientConfig();
			  Client client = Client.create(config);
			  WebResource service = client.resource(UriBuilder.fromUri(URL).build());
			  // getting JSON data
			  System.out.println(service.accept(MediaType.APPLICATION_JSON).get(String.class));
			  // getting XML data
			  //System.out.println(service. path('restPath').path('resourcePath').accept(MediaType.APPLICATION_XML).get(String.class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void apacheHTTPClient_Post(String URL) {
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package com.saurabh.dada.iq.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Java8_Base64 {

	public static void main(String[] args) {

		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = "username:password";
		String encodedString = encoder.encodeToString(
		        normalString.getBytes(StandardCharsets.UTF_8) );
		
		//String encodedString = "dXNlcm5hbWU6cGFzc3dvcmQ=";
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decodedByteArray = decoder.decode(encodedString);
		//Verify the decoded string
		System.out.println(new String(decodedByteArray));

		
		try {
			// Encode using basic encoder
	        String base64encodedString = Base64.getEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
	        System.out.println("Base64 Encoded String (Basic) :" + base64encodedString);
			
	        // Decode
	        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
			
	        System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
	        base64encodedString = Base64.getUrlEncoder().encodeToString(
	           "TutorialsPoint?java8".getBytes("utf-8"));
	        System.out.println("Base64 Encoded String (URL) :" + base64encodedString);
			
	        StringBuilder stringBuilder = new StringBuilder();
			
	        for (int i = 0; i < 10; ++i) {
	           stringBuilder.append(UUID.randomUUID().toString());
	        }
	        System.out.println("Original String (MIME) :" + stringBuilder);
			
	        byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
	        String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
	        System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);
	        
	        byte[] mimeBytesDecoded = Base64.getMimeDecoder().decode(mimeEncodedString);
	        String mimeDecodedString = new String(mimeBytesDecoded,"utf-8");
	        System.out.println("Base64 Decoded String (MIME) :" + mimeDecodedString);
		}
		catch(Exception e) {
			//do nothing
		}
	}

}
class AA{
	
}
class BB extends AA{
	
}
class CC extends BB{
	
}

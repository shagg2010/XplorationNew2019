package com.saurabh.dada.iq.impl;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class String_Encoding {

	public static void main(String... args) throws Exception {
        final String s = "old crow medicine show";
        final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        System.out.println(s + " => " + encoded);
        final byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        System.out.println("Decoded: " + new String(decodedBytes));
    }

}

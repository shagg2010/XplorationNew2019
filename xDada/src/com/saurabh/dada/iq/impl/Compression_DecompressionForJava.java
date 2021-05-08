package com.saurabh.dada.iq.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.commons.io.IOUtils;

public class Compression_DecompressionForJava {
	//Also check LZMA compression algorithm - LZMA, short for Lempel-Ziv-Markov chain-Algorithm used to perform lossless data compression
	//https://dzone.com/articles/how-compress-and-uncompress
	//https://www.geeksforgeeks.org/compressing-and-decompressing-files-in-java/
	/*
	 * Code to create dummy txt file in windows (16 mb):
	 * echo "This is just a sample line appended to create a big file.. " > dummy.txt
	 * for /L %i in (1,1,18) do type dummy.txt >> dummy.txt
	 * 
	 */
	
	public static void main(String[] args) {
		try {
		File file = new File(".//resources//10mb_text.txt");		
		InputStream is = new FileInputStream(file);
		byte[] bytes = IOUtils.toByteArray(is);
		
		byte[] compressed = compress(bytes);
		
		byte[] decompressed = decompress(compressed);
		
		} catch (IOException | DataFormatException e) {
			e.printStackTrace();
		}
		

	}

	public static byte[] compress(byte[] data) throws IOException {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.setLevel(8);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		deflater.finish();
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer); // returns the generated code... index
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();
		System.out.println("Original: " + data.length / 1024 + " Kb");
		System.out.println("Compressed: " + output.length / 1024 + " Kb");
		return output;
	}
	
	public static byte[] decompress(byte[] data) throws IOException, DataFormatException {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!inflater.finished()) {
			int count = inflater.inflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		byte[] output = outputStream.toByteArray();
		//System.out.println("Original: " + data.length);
		//System.out.println("Compressed: " + output.length);
		System.out.println("Compressed: " + data.length / 1024 + " Kb");
		System.out.println("Decompressed: " + output.length / 1024 + " Kb");
		return output;
	}
}

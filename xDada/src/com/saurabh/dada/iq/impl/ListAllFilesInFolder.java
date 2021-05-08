package com.saurabh.dada.iq.impl;

import java.io.File;

public class ListAllFilesInFolder {

	/**
	 * @param args
	 */
	private static int total_dirs=1;
	private static int total_files=0;
	
	public static void main(String[] args) {
		listFilesForFolder(new File("C:\\workbench\\workspaceDev\\BRANCH_612\\products"));

	}

	
	public static void listFilesForFolder(final File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	total_dirs++;
	            listFilesForFolder(fileEntry);
	        } else {
	        	total_files++;
	            System.out.println(fileEntry.getName());
	        }
	    }
	    System.out.println("----------------------------------");
	    System.out.println("Total files: " + total_files + " in " + total_dirs + " directories." );
	    System.out.println("-----------------------------------");
	}
}

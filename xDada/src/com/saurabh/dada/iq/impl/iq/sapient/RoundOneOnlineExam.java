package com.saurabh.dada.iq.impl.iq.sapient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class RoundOneOnlineExam {

	public static void main(String[] args) {
		
		PS4.invoke();
		System.out.println();
		PS5.invoke();
		System.out.println();
		PS6.invoke();
		}
	
	static int method(){
		return true?null:0;
	}

}

//Question-5 code-output - file is overwritten by "line2"
class PS5{
	public static void invoke(){
		try{
			File f1 = new File("f1.txt");
			PrintWriter pw1 = new PrintWriter(f1);
			pw1.println("line1");
			pw1.close();
			PrintWriter pw2 = new PrintWriter("f1.txt");
			pw2.println("line2");
			pw2.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

//Question 6 - Output of the program
class PS6{
	
	public static void invoke(){
		System.out.print(Thread.currentThread().getName()+" ");
		T1 t1 = new T1();
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t1);
		T1.val=1;
		th1.start();
		T1.val=2;
		th2.run();
	}
	
	static class T1 implements Runnable{
		public static volatile int val=0;
		@Override
		public void run() {
			System.out.print(Thread.currentThread().getName()+ " " + val);
		}
	}
	
}

//Question 4 - changes in the array elements
class PS4{
	Integer[] a1 = {10,20,30};
	Integer[] a2 = a1;
	
	public static void invoke(){
		PS4 ps4 = new PS4();		
		System.out.print("Array Data a1: ");
		for(Integer i: ps4.a1){
			System.out.print(i + " ");
		}
		ps4.fix(ps4.a2);
		System.out.print("Array Data a2: ");
		for(Integer i: ps4.a2){
			System.out.print(i + " ");
		}
		System.out.print("ArrayList Data: ");
		List<Integer> list = Arrays.asList(ps4.a2);
		for(Integer i: list){
			System.out.print(i + " ");
		}
	}
	
	Integer[] fix(Integer[] a){
		a[0]=11;
		return a;
	}
}

// Question 2 related to assertion
class PS3{
	public void check(){
		assert false;
	}
}

//Question 1 which throws clause is valid
class PS1{
	
	public void createFile() throws IOException{
		
	}
}

class PS2 extends PS1{
	
	//public void createFile() throws Exception{
	public void createFile() throws FileNotFoundException{
		
	}
}
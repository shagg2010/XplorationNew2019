package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

	/** https://www.hackerearth.com/problem/algorithm/fun-with-fibonacci/
	 * @author yadas
	 */

public class FibonacciSeries_SumEvenOfEvens {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        BigInteger[] limits = new BigInteger[N];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            limits[i] = new BigInteger(line);
        }
        
        for (int i = 0; i < N; i++) {
        	System.out.println(fibonacciSumOfEvens(limits[i]));
        }

	}
	
	public static BigInteger fibonacciSumOfEvens(BigInteger limit){
		BigInteger v3= new BigInteger("0");
		BigInteger v0= new BigInteger("0");
		BigInteger v1= new BigInteger("1");
		BigInteger sum= new BigInteger("0");
		boolean input1Odd=false;
		boolean input2Odd=true;
		boolean sumOddType=true;
		//System.out.print(v0+" "+v1+" ");
		//System.out.print(input1Odd+" "+input2Odd+"    " + sumOddType+"\n");
		while(true){
			v3 = v0.add(v1);
			v0=v1;
			v1=v3;
			if(v3.compareTo(limit)==0||v3.compareTo(limit)==1)
				break;
			sumOddType=input1Odd&&input2Odd?false:true;
			input1Odd=input2Odd;
			input2Odd=sumOddType;
			if(!sumOddType)
				sum=sum.add(v3);
			//System.out.print(v3+ " ");
			/*System.out.println(input1Odd+" "+input2Odd+"   " + sumOddType);
			if(!sumOddType){
				System.out.print("]");
			}*/
		}
		return sum;
	}

}

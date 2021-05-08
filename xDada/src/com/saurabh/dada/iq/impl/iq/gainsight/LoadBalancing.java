package com.saurabh.dada.iq.impl.iq.gainsight;

public class LoadBalancing {
	
	public static int[] loads = {0,0,10,0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		//Saurabh
	}
	
	static int balanceLoad(int[] serverLoads) {
		int seconds=0;
		int totalLoad = totalLoad(serverLoads);
		int perLoad = totalLoad/serverLoads.length;
		
		for(int i=0;i<serverLoads.length-1;i++){
			if(serverLoads[i]<perLoad){
				shareLoad(serverLoads,i);
			}
		}
		return seconds;
    }
	
	static void shareLoad(int[] serverLoads,int i){
		
	}
	
	static boolean allEqual(int[] serverLoads){
		boolean result=true;
		for(int i=0;i<serverLoads.length-1;i++){
			if(serverLoads[i]!=serverLoads[i+1]){
				result=false;
				break;
			}
		}
		return result;
	}

	static int totalLoad(int[] serverLoads){
		int sum=0;
		for(int i=0;i<serverLoads.length;i++){
			sum=sum+serverLoads[i];
		}
		return sum;
	}
}

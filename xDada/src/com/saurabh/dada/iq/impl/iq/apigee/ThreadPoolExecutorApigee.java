package com.saurabh.dada.iq.impl.iq.apigee;

public class ThreadPoolExecutorApigee {
	
	public static void main(String[] args) {
		
		ThreadPoolWithJobAffinity threadPoolWithJobAffinity = new ThreadPoolWithJobAffinityExecutor(5,5);
		for(int i=0;i<100;i++){
			String jobId = new String("j"+((i%50)+1));
			//String jobId = new String("j8150");
			Job job = new Job("t"+(i+1));
			threadPoolWithJobAffinity.submit(jobId, job);
		}
		System.err.println("Total jobs type submitted (poolSize): " + ((ThreadPoolWithJobAffinityExecutor)threadPoolWithJobAffinity).totalRunningJobs());
		threadPoolWithJobAffinity.shutdown();
		//threadPoolWithJobAffinity.submit("j8150", new Job("jobss"));
		
		ThreadPoolWithJobAffinity threadPoolWithJobAffinity2 = new ThreadPoolWithJobAffinityExecutor(15,10);
		for(int i=0;i<100;i++){
			String jobId = new String("jid"+((i%15)+1)+"-2");
			Job job = new Job("t.2-"+(i+1));
			threadPoolWithJobAffinity2.submit(jobId, job);
		}
		threadPoolWithJobAffinity2.shutdown();
	}

}

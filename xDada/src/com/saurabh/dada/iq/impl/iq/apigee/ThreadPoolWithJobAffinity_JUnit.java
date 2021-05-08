package com.saurabh.dada.iq.impl.iq.apigee;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadPoolWithJobAffinity_JUnit {

	@Test
	public void testThreadPool(){
		ThreadPoolWithJobAffinity threadPoolWithJobAffinity1 = new ThreadPoolWithJobAffinityExecutor(5,5);
		for(int i=0;i<100;i++){
			String jobId = new String("jid"+((i%10)+1)+"-1");
			Job job = new Job("t.1-"+(i+1));
			threadPoolWithJobAffinity1.submit(jobId, job);
		}
		threadPoolWithJobAffinity1.shutdown();
		assertFalse(((ThreadPoolWithJobAffinityExecutor)threadPoolWithJobAffinity1).isRunning());
	}
	
	@Test
	public void testThreadPoolSizeLimit(){
		ThreadPoolWithJobAffinity threadPoolWithJobAffinity2 = new ThreadPoolWithJobAffinityExecutor(15,10);
		for(int i=0;i<100;i++){
			String jobId = new String("jid"+((i%15)+1)+"-2");
			Job job = new Job("t.2-"+(i+1));
			threadPoolWithJobAffinity2.submit(jobId, job);
		}
		assertEquals(((ThreadPoolWithJobAffinityExecutor)threadPoolWithJobAffinity2).totalRunningJobs(), 15);
		threadPoolWithJobAffinity2.shutdown();
		assertEquals(((ThreadPoolWithJobAffinityExecutor)threadPoolWithJobAffinity2).totalRunningJobs(), 0);
	}

}

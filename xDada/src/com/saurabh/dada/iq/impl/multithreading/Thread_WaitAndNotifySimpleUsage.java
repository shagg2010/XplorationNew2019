package com.saurabh.dada.iq.impl;

public class Thread_WaitAndNotifySimpleUsage {

	public static void main(String[] args) {
		Thread t = null;
		TaskF1 taskF1 = new TaskF1();
		for(int i=0;i<100;i++){
			t = new Thread(taskF1,"t"+(i+1));
			t.start();
			t.setName("t"+(i+1));
		}
	}

}
final class TaskF1 implements Runnable{
	
	private final Object lock = new Object();
	private boolean busy=false;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" trying to get inside synchronized block");
		try{
			synchronized (lock) {
				System.out.println(Thread.currentThread().getName()+" inside synchronized block");
				while(busy)
					lock.wait();
				busy=true;
				System.out.println(Thread.currentThread().getName()+" notified other thread.");
				busy=false;
				lock.notify();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*class ConnectionPool {
	private List<Connection> connections = createConnections();

	private List<Connection> createConnections() {
		List<Connection> conns = new ArrayList<Connection>(5);
		for (int i = 0; i < 5; i++) {
			try {
				conns.add(DriverManager.getConnection("abc"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conns;
	}

	public Connection getConnection() throws InterruptedException {
		synchronized (connections) {
			while (connections.isEmpty()) {
				connections.wait();
			}
			return connections.remove(0);
		}
	}
}*/
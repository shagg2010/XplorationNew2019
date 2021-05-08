package com.saurabh.dada.iq.impl.designpatterns.GOF.creational;

public class SingletonDesignPattern {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance1();
		Singleton s2 = Singleton.getInstance2();
		System.out.println(s1 + "\t" + s2);
		s1 = Singleton.getInstance1();
		s2 = Singleton.getInstance2();
		System.out.println(s1 + "\t" + s2);
	}

}

class Singleton{
	
	private static Singleton singleton = null;
	
	private Singleton() {
		//private
	}
	
	private static class LazyHolder {
		static {
			System.out.println("LazyHolder loaded!");
		}
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance1() {
		return LazyHolder.INSTANCE;
	}
	
	public static Singleton getInstance2() {
        if (singleton == null) { // first time lock
            synchronized (Singleton.class) {
                if (singleton == null) {  // second time lock
                	singleton = new Singleton();
                    System.out.println("New SearchBox Object Created........!");
                }
            }
        }
        return singleton;
    }
}
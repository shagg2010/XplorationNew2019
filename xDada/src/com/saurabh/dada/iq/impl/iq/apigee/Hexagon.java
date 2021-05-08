package com.saurabh.dada.iq.impl.iq.apigee;

public class Hexagon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 1; 
        int b = 2; 
        int c; 
        int d; 
        c = ++b; 
        d = a++; 
        c++; 
        b++; 
        ++a; 
        System.out.println(a + " " + b + " " + c); 
        
        double var1 = 1 + 5; 
        double var2 = var1 / 4; 
        int var3 = 1 + 5; 
        int var4 = var3 / 4; 
        System.out.print(var2 + " " + var4); 

	}

}

class A {
    public int i;
    protected int j;
}    

class B extends A {
    int j;
    void display() {
        super.j = 3;
        System.out.println(i + " " + j);
    }
}    

class Output {
    public static void main(String args[])
    {
        B obj = new B();
        obj.i=1;
        obj.j=2;   
        obj.display();     
    }
}  

class rec { 
    int func (int n) { 
        int result; 
        result = func (n - 1); 
        return result; 
    } 
} 
class Output1 { 
    public static void main(String args[]) { 
        rec obj = new rec() ; 
        System.out.print(obj.func(12)); 
    } 
} 

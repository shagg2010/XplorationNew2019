package com.yadas.code.java.ds;

public class XXOther {

	public static void main(String[] args) {
		System.out.println(StaticBlock.val);;

	}

}

class StaticBlock{
	public static int val = 0;
	static {
		System.out.println("L.L");
		Object a = null;
		System.out.println(a.hashCode());
	}
}

package com.saurabh.dada.iq.impl;

public class InnerClass_StaticAndNonStatic {

	/** A non-static nested class (or 'inner class') has full access to the members of the class within which it is nested. 
	 * A static nested class does not have a reference to a nesting instance, so a static nested class cannot 
	 * invoke non-static methods or access non-static fields of an instance of the class within which it is nested.
	 */
	private String val2;
	
	public static void main(String[] args) {
		
		InnerClass_StaticAndNonStatic.StaticInnerClass staticInnerClass = new InnerClass_StaticAndNonStatic.StaticInnerClass("StaticInnerClass");
		System.out.println(staticInnerClass.getVal());
		
		InnerClass_StaticAndNonStatic.NonStaticInnerClass nonStaticInnerClass = new InnerClass_StaticAndNonStatic().new NonStaticInnerClass("NonStaticInnerClass");
		System.out.println(nonStaticInnerClass.getVal());
		
		InnerClass_StaticAndNonStatic outerClass = new InnerClass_StaticAndNonStatic();
		outerClass.setVal2("!");
		InnerClass_StaticAndNonStatic.NonStaticInnerClass nsic = outerClass.new NonStaticInnerClass("Hello");
		System.out.println(nsic.getVal());
		
	}

	public static class StaticInnerClass{
		private String val;
		
		public StaticInnerClass(String val) {
			this.val = val;
		}
		public String getVal() {
			return val;
		}
		public void setVal(String val) {
			this.val = val;
		}
		
	}
	
	public class NonStaticInnerClass{
		private String val;
		
		public NonStaticInnerClass(String val) {
			this.val = val;
		}
		public String getVal() {
			return val + " " + InnerClass_StaticAndNonStatic.this.val2 + getVal2();
		}
		public void setVal(String val) {
			this.val = val;
		}
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}
	
	
}

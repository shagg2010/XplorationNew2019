package com.saurabh.dada.iq.impl.designpatterns.GOF.creational;

import java.util.Hashtable;

public class PrototypeDesignPattern {

	public static void main(String[] args) {
		
		Shape1 clonedShape = (Shape1) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType());
		clonedShape.draw();

		Shape1 clonedShape2 = (Shape1) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType());
		clonedShape2.draw();

		Shape1 clonedShape3 = (Shape1) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType());
		clonedShape3.draw();

	}
}
class ShapeCache {
	
	private static Hashtable<String, Shape1> shapeMap = new Hashtable<String, Shape1>();

	public static Shape1 getShape(String shapeId) {
		if(shapeMap == null || shapeMap.size()==0)
			loadCache();
		Shape1 cachedShape = shapeMap.get(shapeId);
		return (Shape1) cachedShape.clone();
	}

	// for each shape run database query and create shape
	// shapeMap.put(shapeKey, shape);
	// for example, we are adding three shapes

	public static void loadCache() {
		Circle1 circle = new Circle1();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square1 square = new Square1();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle1 rectangle = new Rectangle1();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
class Circle1 extends Shape1 {
	public Circle1() {
		type = "Circle";
	}
	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}
class Square1 extends Shape1 {
	public Square1() {
		type = "Square";
	}
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
class Rectangle1 extends Shape1 {
	public Rectangle1() {
		type = "Rectangle";
	}
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
abstract class Shape1 implements Cloneable {
	
	private String id;
	protected String type;
	
	abstract void draw();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Object clone(){
		Object clone = null;
		try{
			clone = super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return clone;
	}

}
